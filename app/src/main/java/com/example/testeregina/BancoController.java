package com.example.testeregina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private final CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    // Método corrigido para aceitar todos os parâmetros do cadastro
    public String insereDados(String nome, String email, String cpf, String telefone, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.EMAIL, email);
        valores.put(CriaBanco.CPF, cpf);
        valores.put(CriaBanco.TELEFONE, telefone);
        valores.put(CriaBanco.SENHA, senha);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro Inserido com sucesso";
        }
    }

    // Este método já estava correto e usará as novas constantes de CriaBanco
    public Cursor ConsultaDadosLogin(String email, String senha){
        db = banco.getReadableDatabase();

        String[] projection = {
                CriaBanco.CODIGO,
                CriaBanco.NOME, // Adicionado para poder pegar o nome no login
                CriaBanco.EMAIL,
                CriaBanco.SENHA
        };

        String selection = CriaBanco.EMAIL + " = ? AND " + CriaBanco.SENHA + " = ?";
        String[] selectionArgs = { email, senha };

        Cursor cursor = db.query(
                CriaBanco.TABELA,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        return cursor;
    }
}