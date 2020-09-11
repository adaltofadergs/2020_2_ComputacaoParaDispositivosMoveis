package br.pro.adalto.app2020_2_aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etValor;
    private Button botao;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor = (EditText) findViewById(R.id.etValor);
        botao = (Button) findViewById(R.id.btnMultiplicar);
        tvResultado = findViewById(R.id.tvResultado);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular(){
        String valor = etValor.getText().toString();
        if( !valor.isEmpty() ){
            double v = Double.valueOf( valor );
            double resultado = v * 2;
            tvResultado.setText(  String.valueOf( resultado)  );
        }
    }


}