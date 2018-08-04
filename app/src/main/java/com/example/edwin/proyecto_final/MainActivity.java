package com.example.edwin.proyecto_final;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Locale;

import static com.example.edwin.proyecto_final.R.color.fondoRojo;

public class MainActivity extends AppCompatActivity {

   private FragmentTabHost tabHost;
    private DialogFragment color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        tabHost= findViewById(android.R.id.tabhost);
        tabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("RPN"),Tab1.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("CM"),Tab2.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Pres"),Tab3.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("Edad"),Tab4.class, null);
    }

    //Metodo para Visualizar las opciones
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    //Metodo para esas opciones
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent in = new Intent(MainActivity.this,Favorito.class);
                startActivity(in);
                return true;

            case R.id.action_idioma:

                cambiarIdioma();
                return true;

            case R.id.action_fondo:
                cambiarFondo();
            return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void cambiarFondo(){
       final ConstraintLayout tab_0 = findViewById(R.id.tab_0);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set the dialog title
        builder.setTitle("Cambiar colo de Fondo")
                .setSingleChoiceItems(R.array.fondo, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String[] color = getResources().getStringArray(R.array.fondo);
                        int posicion = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                        Toast.makeText(MainActivity.this,"El fondo cambiara al color : " + color[posicion],Toast.LENGTH_LONG).show();
                        if(color[posicion].equals("Blanco")){
                            tab_0.setBackgroundColor(getResources().getColor(R.color.fondoBlanco));
                        }else{
                            if(color[posicion].equals("Rojo")){
                                tab_0.setBackgroundColor(getResources().getColor(R.color.fondoRojo));
                            }else{
                                if(color[posicion].equals("Verde")){
                                    tab_0.setBackgroundColor(getResources().getColor(R.color.fondoVerde));
                                }else{
                                    if(color[posicion].equals("Azul")){
                                        tab_0.setBackgroundColor(getResources().getColor(R.color.fondoAzul));
                                    }else{
                                            tab_0.setBackgroundColor(getResources().getColor(R.color.fondoGreay));
                                    }
                                }
                            }
                        }

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        tab_0.setBackgroundColor(getResources().getColor(R.color.fondoBlanco));
                    }
                })
                .show();
    }

    public void cambiarIdioma(){
        final ConstraintLayout tab_0 = findViewById(R.id.tab_0);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set the dialog title
        builder.setTitle("Cambiar el Idioma")
                .setSingleChoiceItems(R.array.idioma, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String[] idiom = getResources().getStringArray(R.array.idioma);
                        int posic = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                        Toast.makeText(MainActivity.this,"El idioma cambiara a : " + idiom[posic],Toast.LENGTH_LONG).show();

                        if(idiom[posic].equals("Esp")){
                            Locale idiom_es = new Locale("es","ES");
                            Locale.setDefault(idiom_es);
                            Configuration conf_es = new Configuration();
                            conf_es.locale = idiom_es;
                            getBaseContext().getResources().updateConfiguration(conf_es,getBaseContext().getResources().getDisplayMetrics());

                        }else{

                            Locale idiom_en = new Locale("en","EN");
                            Locale.setDefault(idiom_en);
                            Configuration conf_en = new Configuration();
                            conf_en.locale = idiom_en;
                            getBaseContext().getResources().updateConfiguration(conf_en,getBaseContext().getResources().getDisplayMetrics());

                        }
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Locale idiom_es = new Locale("es_ES","ES");
                        Locale.setDefault(idiom_es);
                        Configuration conf_es = new Configuration();
                        conf_es.locale = idiom_es;
                        getBaseContext().getResources().updateConfiguration(conf_es,getBaseContext().getResources().getDisplayMetrics());

                    }
                })
                .show();
    }
}
