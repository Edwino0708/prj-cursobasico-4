package com.example.edwin.proyecto_final;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Tab1 extends Fragment implements View.OnClickListener{

    TextView txt_mostrar;
    Button btn_n,btn_n1,btn_n2,btn_n3,btn_n4,btn_n5,btn_n6,btn_n7,btn_n8,btn_n9,
    btn_o1,btn_o2,btn_o3,btn_o4,btn_o5,
    btn_f1,btn_f2,btn_f3,btn_f4;
    double valor1,valor2,resul,aux;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txt_mostrar = v.findViewById(R.id.txe_mostrador);
        //Referencia de los numeros
        btn_n = v.findViewById(R.id.btn_n);
        btn_n1 = v.findViewById(R.id.btn_n1);
        btn_n2 = v.findViewById(R.id.btn_n2);
        btn_n3 = v.findViewById(R.id.btn_n3);
        btn_n4 = v.findViewById(R.id.btn_n4);
        btn_n5 = v.findViewById(R.id.btn_n5);
        btn_n6 = v.findViewById(R.id.btn_n6);
        btn_n7 = v.findViewById(R.id.btn_n7);
        btn_n8 = v.findViewById(R.id.btn_n8);
        btn_n9 = v.findViewById(R.id.btn_n9);
        //Eventos de botones de los numeros
//        btn_n.getA
        btn_n.setOnClickListener(this);
        btn_n1.setOnClickListener(this);
        btn_n2.setOnClickListener(this);
        btn_n3.setOnClickListener(this);
        btn_n4.setOnClickListener(this);
        btn_n5.setOnClickListener(this);
        btn_n6.setOnClickListener(this);
        btn_n7.setOnClickListener(this);
        btn_n8.setOnClickListener(this);
        btn_n9.setOnClickListener(this);

        //Referencia de los Las operaciones importantes
        btn_o1 = v.findViewById(R.id.btn_o1);
        btn_o2 = v.findViewById(R.id.btn_o2);
        btn_o3 = v.findViewById(R.id.btn_o3);
        btn_o4 = v.findViewById(R.id.btn_o4);
        btn_o5 = v.findViewById(R.id.btn_o5);
        //Eventos de botones de las operaciones
        btn_o1.setOnClickListener(this);
        btn_o2.setOnClickListener(this);
        btn_o3.setOnClickListener(this);
        btn_o4.setOnClickListener(this);
        btn_o5.setOnClickListener(this);

        //Referencia de los Las Funciones
        btn_f1 = v.findViewById(R.id.btn_f1);
        btn_f2 = v.findViewById(R.id.btn_f2);
        btn_f3 = v.findViewById(R.id.btn_f3);
        btn_f4 = v.findViewById(R.id.btn_f4);
        //Eventos de botones de los numeros
        btn_f1.setOnClickListener(this);
        btn_f2.setOnClickListener(this);
        btn_f3.setOnClickListener(this);
        btn_f4.setOnClickListener(this);

      return v;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            //Casos de numeros
          case R.id.btn_n:
             txt_mostrar.setText(txt_mostrar.getText() + "0");
          break;
            case R.id.btn_n1:
                txt_mostrar.setText(txt_mostrar.getText() + "1");
                break;
            case R.id.btn_n2:
                txt_mostrar.setText(txt_mostrar.getText() + "2");
                break;
            case R.id.btn_n3:
                txt_mostrar.setText(txt_mostrar.getText() + "3");
                break;
            case R.id.btn_n4:
                txt_mostrar.setText(txt_mostrar.getText() + "4");
                break;
            case R.id.btn_n5:
                txt_mostrar.setText(txt_mostrar.getText() + "5");
                break;
            case R.id.btn_n6:
                txt_mostrar.setText(txt_mostrar.getText() + "6");
                break;
            case R.id.btn_n7:
                txt_mostrar.setText(txt_mostrar.getText() + "7");
                break;
            case R.id.btn_n8:
                txt_mostrar.setText(txt_mostrar.getText() + "8");
                break;
            case R.id.btn_n9:
                txt_mostrar.setText(txt_mostrar.getText() + "9");
                break;
            case R.id.btn_o2:
                aux=1;
                try {
                    valor1 = Double.parseDouble(txt_mostrar.getText().toString());
                    txt_mostrar.setText("");
                }catch (NumberFormatException e){}
                break;
            case R.id.btn_o3:
                aux=2;
                try {
                    valor1 = Double.parseDouble(txt_mostrar.getText().toString());
                    txt_mostrar.setText("");
                }catch (NumberFormatException e){}
                break;
            case R.id.btn_o5:
                aux=3;
                try {
                    valor1 = Double.parseDouble(txt_mostrar.getText().toString());
                    txt_mostrar.setText("");
                }catch (NumberFormatException e){}
                break;
            case R.id.btn_o4:
                aux=4;
                try {
                    valor1 = Double.parseDouble(txt_mostrar.getText().toString());
                    txt_mostrar.setText("");
                }catch (NumberFormatException e){}
                break;
            case R.id.btn_o1:
                try {
                    if(aux == 1){
                        try{
                            valor2 = Double.parseDouble(txt_mostrar.getText().toString());
                            txt_mostrar.setText("");
                            resul = valor1 + valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }catch (NumberFormatException e){
                            txt_mostrar.setText("");
                            resul = valor1 + valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }
                    }if(aux == 2){
                        try{
                            valor2 = Double.parseDouble(txt_mostrar.getText().toString());
                            txt_mostrar.setText("");
                            resul = valor1 - valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }catch (NumberFormatException e){
                            txt_mostrar.setText("");
                            resul = valor1 - valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }
                    }if(aux == 3){
                        try{
                            valor2 = Double.parseDouble(txt_mostrar.getText().toString());
                            txt_mostrar.setText("");
                            resul = valor1 * valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }catch (NumberFormatException e){
                            txt_mostrar.setText("");
                            resul = valor1 * valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }
                    }if(aux == 4){
                        try{
                            valor2 = Double.parseDouble(txt_mostrar.getText().toString());
                            txt_mostrar.setText("");
                            resul = valor1 / valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }catch (NumberFormatException e){
                            txt_mostrar.setText("");
                            resul = valor1 / valor2;
                            txt_mostrar.setText(String.valueOf(resul));
                        }
                    }

        }catch (NumberFormatException e){
                }
                break;
            case R.id.btn_f1:
                txt_mostrar.setText(txt_mostrar.getText() + ".");
                break;
            case R.id.btn_f2:
                aux = 5;
                txt_mostrar.setText(txt_mostrar.getText() + "%");
                break;
            case R.id.btn_f3:
                int n = txt_mostrar.length();
                String sub = txt_mostrar.getText().toString();
                String sub2 = sub.substring(n-1);
                txt_mostrar.setText(sub2);
                break;

            case R.id.btn_f4:
                txt_mostrar.setText("");
                    valor1 = 0;
                    valor2 = 0;
                    resul = 0;
                 break;



        }

    }
}