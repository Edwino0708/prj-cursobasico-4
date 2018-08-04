package com.example.edwin.proyecto_final;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.content.ContentValues.TAG;


public class Tab2 extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    EditText txe_1,txe_2,txe_3,txe_4,txe_5,txe_6,txe_7;
    Button btn_Calcular;
    Switch cambiar;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab2, container, false);
        txe_1 = v.findViewById(R.id.txe_1);
        txe_2 = v.findViewById(R.id.txe_2);
        txe_3 = v.findViewById(R.id.txe_3);
        txe_4 = v.findViewById(R.id.txe_4);
        txe_5 = v.findViewById(R.id.txe_5);
        txe_6 = v.findViewById(R.id.txe_6);
        txe_7 = v.findViewById(R.id.txe_7);
        cambiar = v.findViewById(R.id.switch1);

        cambiar.setOnCheckedChangeListener(this);
        btn_Calcular = v.findViewById(R.id.btn_calcular);

        btn_Calcular.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
      Double tasaVel = 0.00,tasaDol=0.00,tasaEur=0.00,valorVel=0.00,valorDol=0.00,valorEur=0.00,valorDom=0.00;
      String tasVel,tasDol,tasEur,valVel,valDol,valEur,valDom;

      valDol = txe_4.getText().toString();
      valorDom = Double.parseDouble(valDol);

      tasVel = txe_1.getText().toString();
      tasDol = txe_2.getText().toString();
      tasEur = txe_3.getText().toString();

      tasaVel = Double.parseDouble(tasVel);
      tasaDol = Double.parseDouble(tasDol);
      tasaEur = Double.parseDouble(tasEur);

      valorVel = valorDom / tasaVel ;
      valorDol = valorDom / tasaDol;
      valorEur = valorDom / tasaEur;

      valorVel = Double.valueOf(Math.round(valorVel));
      valorDol = Double.valueOf(Math.round(valorDol));
      valorEur = Double.valueOf(Math.round(valorEur));

        txe_5.setText(valorVel.toString());
      txe_6.setText(valorDol.toString());
      txe_7.setText(valorEur.toString());

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
        {   txe_1.setEnabled(true);
            txe_2.setEnabled(true);
            txe_3.setEnabled(true);
        }
        else
        {
            txe_1.setEnabled(false);
            txe_2.setEnabled(false);
            txe_3.setEnabled(false);
            }
    }
}
