package com.example.testeregina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }


    public String insereDados(String _nome, String _cpf, String _email, String _senha, String _telefone) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", _nome);
        valores.put("email", _email);
        valores.put("cpf", _cpf);
        valores.put("telefone", _telefone);
        valores.put("senha", _senha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao cadastrar";
        else
            return "Cadastrado com Sucesso";
    }
    public Cursor ConsultaDadosLogin(String _email, String _senha){
        Cursor cursor;
        String[] campos = { "codigo","nome","cpf","email","senha"};
        String where = "email = '" + _email + "' and senha = '" + _senha + "'";
        db = banco.getReadableDatabase();


        // select * from usuarios where _email = 'digitado' and _senha = 'senha'
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
