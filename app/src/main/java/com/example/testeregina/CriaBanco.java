package com.example.testeregina;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    // Nomes da tabela e colunas definidos como constantes públicas
    public static final String TABELA = "contatos";
    public static final String CODIGO = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String CPF = "cpf";
    public static final String TELEFONE = "telefone";
    public static final String SENHA = "senha";

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Usando as constantes para criar a tabela
        String sql = "CREATE TABLE " + TABELA + "("
                + CODIGO + " integer primary key autoincrement,"
                + NOME + " text,"
                + EMAIL + " text,"
                + CPF + " text,"
                + TELEFONE + " text,"
                + SENHA + " text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
