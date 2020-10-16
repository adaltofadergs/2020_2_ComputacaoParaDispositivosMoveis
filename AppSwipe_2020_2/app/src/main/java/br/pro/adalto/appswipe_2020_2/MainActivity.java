package br.pro.adalto.appswipe_2020_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDirecao;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDirecao = findViewById(R.id.tvDirecao);
        layout = findViewById(R.id.layout);

        layout.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                mostrarDirecao("direita");
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                mostrarDirecao("esquerda");
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                mostrarDirecao("base");
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                mostrarDirecao("topo");
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
              //  mostrarDirecao("só tocou");
                return super.onTouch(v, event);
            }
        });


    }

    private void mostrarDirecao(String direcao){
        AlertDialog.Builder alerta = new AlertDialog.Builder( this );
        alerta.setTitle("Direção do Movimento");
        switch ( direcao ){
            case "direita":
                alerta.setMessage("Da esquerda para a direita");
                tvDirecao.setText("Da esquerda para a direita");
                break;
            case "esquerda":
                alerta.setMessage("Da direita para a esquerda");
                tvDirecao.setText("Da direita para a esquerda");
                break;
            case "topo":
                alerta.setMessage("Da baixo para cima");
                tvDirecao.setText("Da baixo para cima");
                break;
            case "base":
                alerta.setMessage("Da cima para baixo");
                tvDirecao.setText("Da cima para baixo");
                break;
            default:
                alerta.setMessage("Movimento não identificado");
                tvDirecao.setText("Movimento não identificado");
                break;
        }
        alerta.setPositiveButton("OK", null);
        alerta.show();
    }

}