package com.example.tarea_3_spinn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Scanner sc = new Scanner(System.in);
    Spinner spn;
    TextView primeroNumero, segundoNumero, operando, resultado, Winlose;
    Button jugar;
    Button comprobar;
    Operandos jugador;
    EditText meterTexto;
    TextView marcador;
    TextView juagadas;
    int partidas=5;
    int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primeroNumero = findViewById(R.id.tw_primerNumero);
        operando = findViewById(R.id.tw_operando);
        segundoNumero = findViewById(R.id.tw_segundoNumero);
        meterTexto = findViewById(R.id.et_Respuesta);
        resultado = findViewById(R.id.tw_resultado);
        spn = findViewById(R.id.spn_Niveles);
        jugar = findViewById(R.id.btn_jugar);
        comprobar = findViewById(R.id.btn_Comprobar);
        Winlose = findViewById(R.id.tv_WinLose);
        marcador = findViewById(R.id.tv_puntuacion);
        Score = 0;
        juagadas = findViewById(R.id.tv_juagadas);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jugar.setVisibility(View.INVISIBLE);
                juagadas.setText(String.valueOf("Juagadas disponibles  " + partidas));
                jugador = new Operandos(spn.getSelectedItemPosition());
                primeroNumero.setText(String.valueOf(jugador.getOperando1()));
                segundoNumero.setText(String.valueOf(jugador.getOperando2()));
                operando.setText(String.valueOf(jugador.getOperador()));
                partidas--;


            }

        });

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = (String.valueOf(meterTexto.getText()));
                String n2 = String.valueOf(jugador.getResultado());
                juagadas.setText(String.valueOf("Juagadas disponibles  " + partidas));
                partidas--;
                if (partidas <=5 && partidas >=0)
                    jugar.setVisibility(View.INVISIBLE);

               else{
                    jugar.setVisibility(View.VISIBLE);
                partidas =5;}
//                if (String.valueOf(meterTexto.getText()).equals("")) ;
 //               {
 //                   Winlose.setText("Tramposo");
 //               }


                if (n1.equals(n2)) {


                    resultado.setText(String.valueOf(jugador.getResultado()));
                    Score++;
                    meterTexto.setText("");
                    marcador.setText(String.valueOf("Puntuacion " + Score));

                    Winlose.setText("Ganador");
                } else
                    Winlose.setText("Perdedor");
            }
        });
    }
}