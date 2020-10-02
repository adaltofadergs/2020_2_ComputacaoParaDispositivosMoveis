package br.pro.adalto.compras2020_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etPreco;
    private Button btnSalvar;
    private String acao;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        acao = getIntent().getExtras().getString("acao");

        etNome = findViewById(R.id.etNome);
        etPreco = findViewById(R.id.etPreco);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar(){
        if ( produto == null ){
            produto = new Produto();
        }

        String nome = etNome.getText().toString();
        if ( nome.isEmpty() ){
            AlertDialog.Builder alerta = new AlertDialog.Builder( this);
            alerta.setTitle("Atenção!");
            alerta.setMessage("O nome do produto deve ser preenchido!");
            alerta.setIcon( android.R.drawable.ic_dialog_alert );
            alerta.setPositiveButton("OK", null);
            alerta.show();
        }else{
            produto.setNome( nome );
            String sPreco = etPreco.getText().toString();
            if( sPreco.isEmpty() ){
                produto.setPreco( 0.0 );
            }else {
                sPreco = sPreco.replace( "," , ".");
                double preco = Double.valueOf( sPreco );
                produto.setPreco( preco );
            }

            if( acao.equals( "inserir" ) ){
                ProdutoDAO.inserir( this , produto );
                finish();
            }

        }
    }

}