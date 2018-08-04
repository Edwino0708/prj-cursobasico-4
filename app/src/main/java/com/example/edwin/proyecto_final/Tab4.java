package com.example.edwin.proyecto_final;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

public class Tab4 extends Fragment implements View.OnClickListener {

    int edad_antigua = 0;
    TextView mDateDisplay, txt_edad, txt_dif;
    EditText date_display;
    ImageButton icono_calendar;
    private DatePickerDialog mDatePicker;
    private java.util.Calendar mCalendar;
    private SimpleDateFormat mDateFormat;
    int fecha = 0;
    Button calcular;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab4, container, false);
        mDateDisplay =v.findViewById(R.id.date_display);
        date_display = v.findViewById(R.id.date_display);
        calcular = v.findViewById(R.id.btn_tab4_calcular);
        txt_edad = v.findViewById(R.id.txv_edad);
        txt_dif = v.findViewById(R.id.txt_dif_edad);
        calcular.setOnClickListener(this);

        mCalendar = java.util.Calendar.getInstance();
        mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        mDatePicker = new DatePickerDialog(getContext(), mDatePickerListener,
                mCalendar.get(java.util.Calendar.YEAR),
                mCalendar.get(java.util.Calendar.MONTH),
                mCalendar.get(java.util.Calendar.DATE));
        mDateDisplay = v.findViewById(R.id.date_display);
       icono_calendar = v.findViewById(R.id.ibt_calendar);
        icono_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatePicker.show();
            }
        });
        return v;
    }

    private DatePickerDialog.OnDateSetListener mDatePickerListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            mCalendar.set(Calendar.YEAR, i);
            mCalendar.set(java.util.Calendar.MONTH, i1);
            mCalendar.set(Calendar.DATE, i2);
            refreshDisplays();
        }
    };
    private void refreshDisplays() {
        mDateDisplay.setText(mDateFormat.format(mCalendar.getTime()));
     }

    @Override
    public void onClick(View view) {
        Calendar fecha_full = Calendar.getInstance();
        String sub = date_display.getText().toString();
        String year2;
        int year = fecha_full.get(Calendar.YEAR);

        year2 = sub.substring(6,10);
        fecha = Integer.parseInt(year2);

        year -= fecha;
        String fecha_year = getString(R.string.tb4_edad);
        txt_edad.setText(fecha_year +" : "+year);

        if(edad_antigua == 0){
            edad_antigua = year;
        }else{
            if(year > edad_antigua){
                edad_antigua = year - edad_antigua;
                String decir = getResources().getString(R.string.tb4_dif_edad);
                String decir2 = getResources().getString(R.string.tb4_dif_year);
                txt_dif.setText(decir+" : "+ edad_antigua +""+decir2);
                edad_antigua = 0;
            }else{
                edad_antigua -=year;
                String decir = getResources().getString(R.string.tb4_dif_edad);
                String decir2 = getResources().getString(R.string.tb4_dif_year);
                txt_dif.setText(decir+" : "+ edad_antigua +""+decir2);
                edad_antigua = 0;
            }
        }

    }
}