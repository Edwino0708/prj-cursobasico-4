package com.example.edwin.proyecto_final;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Tab3 extends Fragment implements View.OnClickListener {

    double monto,tasa;
    int meses;
    EditText txe_1,txe_2,txe_3;
    Spinner sp_tasa, sp_pago;
    Button btn_mostrar;
    String tasas;
    String pagos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab3, container, false);;

        txe_1 = v.findViewById(R.id.txe_tab3_1);
        txe_2 = v.findViewById(R.id.txe_tab3_2);
        txe_3 = v.findViewById(R.id.txe_tab3_3);

        btn_mostrar = v.findViewById(R.id.btn_tab3_mostrar);

        sp_tasa = v.findViewById(R.id.spinner_tab3);
        sp_pago = v.findViewById(R.id.spinner_tab3_2);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.tipo_Tasa,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tasa.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getActivity(), R.array.periodo_pago,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pago.setAdapter(adapter2);

        tasas = sp_tasa.getSelectedItem().toString();
        pagos = sp_pago.getSelectedItem().toString();
        btn_mostrar.setOnClickListener(this);

        return v;

    }

    public void valores(){
        monto = Double.parseDouble(txe_1.getText().toString());
        tasa = Double.parseDouble(txe_2.getText().toString());
        meses = Integer.parseInt(txe_3.getText().toString());

        if(tasas.equals("Anual")){
            tasa/=12;
        } tasa /=100;
        if(pagos.equals("Diario")){
            tasa/=30.4167;
        }if(pagos.equals("Semana")){
            tasa/=4.34524;
        }if(pagos.equals("Mensual")){
        }if(pagos.equals("Cuastrimetral")){
            tasa*=4;
        }if(pagos.equals("Anual")){
            tasa*=12;
        }
    }

    @Override
    public void onClick(View view) {
     valores();
     double total;
     String inf_pago = getResources().getString(R.string.tb3__inf_pago);
     String inf_meses = getResources().getString(R.string.tb3__inf_meses);
        total = monto *((tasa * Math.pow(1+tasa,meses)) /(Math.pow(1+tasa,meses)-1));
        total = Math.round(total);
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
        dialogo1.setTitle("Informacion de pago");
        dialogo1.setMessage(inf_pago+" : "+total+" "+inf_meses+" :"+meses);
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {

            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
             }
        });
        dialogo1.show();
    }
}
