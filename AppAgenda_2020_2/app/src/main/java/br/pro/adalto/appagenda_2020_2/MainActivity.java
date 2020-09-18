package br.pro.adalto.appagenda_2020_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spEstado, spCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spEstado = findViewById(R.id.spEstado);
        spCidade = findViewById(R.id.spCidade);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String estado = adapterView.getItemAtPosition( i ).toString();
                carregarCidades( estado );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private void carregarCidades( String estadoSelecionado ){

        String[] cidadesPR = {"Selecione...", "Curitiba", "Cascavél"};
        String[] cidadesSC = {"Selecione...", "Florianópolis", "Itajaí"};
        String[] cidadesRS = {"Selecione...", "Porto Alegre", "Viamão"};

        String[] cidades;

        switch ( estadoSelecionado ){
            case "PR":
                cidades = cidadesPR;
                spCidade.setEnabled(true);
                break;
            case "SC":
                cidades = cidadesSC;
                spCidade.setEnabled(true);
                break;
            case "RS":
                cidades = cidadesRS;
                spCidade.setEnabled(true);
                break;
            default:
                cidades = new String[]{ getResources().getString(R.string.selecionarEstado) };
                spCidade.setEnabled(false);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cidades);
        spCidade.setAdapter( adapter );
    }

}