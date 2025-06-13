package com.example.testeregina;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLogEmail, txtLogSenha;
    Button btLogAcessar, btLogCadastre_se, btEsqueceuSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        btLogAcessar = findViewById(R.id.btLogAcessar);
        btLogCadastre_se = findViewById(R.id.btLogCadastre_se);
        txtLogEmail = findViewById(R.id.txtLogEmail);
        txtLogSenha = findViewById(R.id.txtLogSenha);
        btEsqueceuSenha = findViewById(R.id.btEsqueceuSenha);

        btLogAcessar.setOnClickListener(this);
        btLogCadastre_se.setOnClickListener(this);
        btEsqueceuSenha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLogAcessar) {
            validaLogin(); // O método validaLogin agora também trata a navegação
        } else if (v.getId() == R.id.btLogCadastre_se) {
            Intent tela = new Intent(this, Cadastre_se.class);
            startActivity(tela);
        } else if (v.getId() == R.id.btEsqueceuSenha) {
            Intent tela = new Intent(this, EsqueceuSenha.class);
            startActivity(tela);
        }
    }

    public void validaLogin() {
        String _email = txtLogEmail.getText().toString().trim();
        String _senha = txtLogSenha.getText().toString().trim();

        if (_email.isEmpty() || _senha.isEmpty()) {
            Toast.makeText(this, "E-mail e Senha devem ser preenchidos!", Toast.LENGTH_SHORT).show();
            return;
        }

        BancoController bd = new BancoController(getBaseContext());
        // A consulta já retorna o cursor com todos os dados do usuário, incluindo o nome
        Cursor dados = bd.ConsultaDadosLogin(_email, _senha);

        if (dados != null && dados.moveToFirst()) {
            // SUCESSO NO LOGIN: Extrai o nome do usuário do cursor
            // É importante garantir que a coluna NOME existe na sua tabela e na classe CriaBanco
            String nomeUsuario = dados.getString(dados.getColumnIndexOrThrow(CriaBanco.NOME));
            dados.close(); // Fecha o cursor após o uso

            // Inicia a HomeActivity e passa o nome do usuário
            Intent tela = new Intent(this, HomeActivity.class);
            tela.putExtra("NOME_USUARIO", nomeUsuario); // Adiciona o nome como um "extra"
            startActivity(tela);
            finish(); // Finaliza a tela de login para não poder voltar
        } else {
            // FALHA NO LOGIN
            if (dados != null) {
                dados.close();
            }
            Toast.makeText(this, "E-mail ou Senha inválidos.", Toast.LENGTH_SHORT).show();
        }
    }
}