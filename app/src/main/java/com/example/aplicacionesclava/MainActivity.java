package com.example.aplicacionesclava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button aplicaciones;
    private Button paginasWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aplicaciones = findViewById(R.id.b_Aplicaciones);
        paginasWeb = findViewById(R.id.b_Paginas_Web);
    }

    public void abrir_aplicaciones(View view){
        Intent aplicaciones = new Intent(this, Aplicaciones.class);
        startActivity(aplicaciones);
    }

    public void abrir_navegador_web(View view){
        Intent navegador_web = new Intent(this, NavegadorWeb.class);
        startActivity(navegador_web);
    }
}
