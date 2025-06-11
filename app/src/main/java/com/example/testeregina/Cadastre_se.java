package com.example.testeregina;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cadastre_se extends AppCompatActivity implements View.OnClickListener {
    EditText txtCadNome, txtCadCPF, txtCadEmail, txtCadSenha, txtCadTelefone;
    Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_log);


        txtCadNome      = findViewById(R.id.txtCadNome);
        txtCadCPF       = findViewById(R.id.txtCadCPF);
        txtCadEmail     = findViewById(R.id.txtCadEmail);
        txtCadSenha     = findViewById(R.id.txtCadSenha);
        txtCadTelefone  = findViewById(R.id.txtCadTelefone);
        btnCadastrar     = findViewById(R.id.btnCadastrar);


        btnCadastrar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String _nome  = txtCadNome.getText().toString();
        String _cpf   = txtCadCPF.getText().toString();
        String _email = txtCadEmail.getText().toString();
        String _senha = txtCadSenha.getText().toString();
        String _telefone = txtCadTelefone.getText().toString();
        String msg = "";
        if (_nome.isEmpty()){
            msg = "O campo NOME deve ser preenchido!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }else{
            if (_cpf.isEmpty()) {
                msg = "O campo CPF deve ser preenchido!";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }else{
                if (_email.isEmpty()) {
                    msg = "O campo E-MAIL deve ser preenchido!";
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                }else{
                    if (_senha.isEmpty()) {
                        msg = "O campo SENHA deve ser preenchido!";
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                    }else{
                        BancoController bd = new BancoController(getBaseContext());
                        String resultado;


                        resultado = bd.insereDados(_nome,_cpf,_email, _senha, _telefone);


                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}