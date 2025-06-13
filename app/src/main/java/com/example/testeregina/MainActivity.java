package com.example.testeregina;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnCadastrar;
    EditText  txtCadnome, txtCadEmail, txtCadCPF, txtCadTelefone, txtCadSenha;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_log);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastro_log);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Cadastre_se), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txtCadnome = (EditText) findViewById(R.id.txtCadNome);
        txtCadEmail = (EditText) findViewById(R.id.txtCadEmail);
        txtCadCPF = (EditText) findViewById(R.id.txtCadCPF);
        txtCadTelefone = (EditText) findViewById(R.id.txtCadTelefone);





        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);


        btnCadastrar.setOnClickListener(this);



    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.btnCadastrar) {
            salvar();



    }
}


public void salvar() {
    String msg = "";
    String txtNome = txtCadnome.getText().toString();
    String txtEmail = txtCadEmail.getText().toString();
    String txtCPF = txtCadCPF.getText().toString();
    String txtTelefone = txtCadTelefone.getText().toString();
    String txtSenha = txtCadSenha.getText().toString();


    if (txtNome.length()==0 || txtEmail.length()<10)
    {
        msg = "Atenção - Os campos Nome e E-mail devem ser preenchidos!!!";
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }else {
        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDados(txtNome, txtEmail, txtCPF, txtTelefone, txtSenha);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
    }

}


public void limpar(){
    txtCadnome.setText("") ;
    txtCadEmail.setText("");
    txtCadCPF.setText("");
    txtCadTelefone.setText("");
    txtCadSenha.setText("");


}
}

