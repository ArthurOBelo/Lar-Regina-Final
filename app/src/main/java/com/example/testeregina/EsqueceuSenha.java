package com.example.testeregina;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EsqueceuSenha extends AppCompatActivity {
    EditText txtEsqSenha, txtEsqEmail;

    Button btReenviarCodigo, btRedefineSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recuperar_senha);

        txtEsqSenha = findViewById(R.id.txtEsqSenha);
        txtEsqEmail = findViewById(R.id.txtEsqEmail);

        btReenviarCodigo = findViewById(R.id.btReenviarCodigo);
        btRedefineSenha = findViewById(R.id.btRedefineSenha);
    }

}

