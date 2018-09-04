package com.dev.inicialapp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqLiteDBHelper extends SQLiteOpenHelper {
    //definição do nome do banco de dados e versão
    public static final String DATABASE_NOME="info.db";
    private static final int DATABASE_VERSAO=1;

    //definição do nome da tabela de dados do usuário
    public static final String TABLE_NOME="usuario";

    //definição dos atributos da tabela USUARIO
    public static final String COLUMN_ID="usuarioID";
    public static final String COLUMN_NOME="nome";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_SENHA="senha";
    public static final String COLUMN_FONE="fone";

    //public SQLiteDatabase db;

    //sentença SQL para criar tabela
    private static final String CREATE_TABLE_QUERY=
            "CREATE TABLE " + TABLE_NOME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOME+" TEXT,"+
            COLUMN_EMAIL+" TEXT,"+
            COLUMN_SENHA+" TEXT,"+
            COLUMN_FONE+" TEXT " + ")";

    //Construtor
    public SqLiteDBHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOME);
        onCreate(sqLiteDatabase);
    }
}
