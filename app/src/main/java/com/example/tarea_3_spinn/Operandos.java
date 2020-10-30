package com.example.tarea_3_spinn;

import android.telephony.SubscriptionManager;
import android.widget.Switch;

public class Operandos {
    private int resultado, operando1, operando2;
    char  operador;

    public Operandos(int nivel) {
        //Fabricas 2 aleatorios. Los sumas o restas o lo que sea según el nivel. Creas un objeto O


        switch (nivel){
            case 0:
            operando1= pedirAleatorio(1);
            operando2= pedirAleatorio(1);
            operador = '+';
            resultado = operando1 + operando2;
                break;
            case 1:
                operando1= pedirAleatorio(2);
                operando2= pedirAleatorio(2);
                resultado = operando1 - operando2;
                operador = '-';
                break;
            case 2:
                operando1= pedirAleatorio(2);
                operando2= pedirAleatorio(2);
                resultado = operando1 * operando2;
                operador = 'X';
                break;
        }

         ;
    }

    private int pedirAleatorio(int i) {
        int factor= (int)Math.pow(10, i);
        return (int)(Math.random()*factor);
    }

    private Operandos(int num1, int num2, int resultado, char operador) {

        this.resultado = resultado;
        this.operador = operador;
    }


    public int getResultado() {
        return resultado;
    }

    public int getOperando1() {
        return operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public char getOperador() {
        return operador;
    }
}
