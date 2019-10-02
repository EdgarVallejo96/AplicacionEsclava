package com.example.aplicacionesclava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class Aplicaciones extends AppCompatActivity {

    private ImageView ivUno, ivDos, ivTres, ivCuatro, ivCinco, ivSeis, ivSiete, ivOcho;
    private Button bRegresar, bActualizar;
    private String appUno = "com.spotify.music";
    private String appDos = "com.waze";
    private String appTres = "com.duolingo";
    private String appCuatro = "cc.forestapp";
    private String appCinco = "com.blackboard.android.bbstudent";
    private String appSeis = "com.android.contacts";
    private String appSiete = "com.shazam.android"; // com.facebook.katana com.shazam.android
    private String appOcho = "com.instagram.android"; // com.instagram.android com.ubercab
    private String appRestringidaUno = "com.instagram.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicaciones);

        ivUno = findViewById(R.id.iv_App_Uno);
        ivDos = findViewById(R.id.iv_App_Dos);
        ivTres = findViewById(R.id.iv_App_Tres);
        ivCuatro = findViewById(R.id.iv_App_Cuatro);
        ivCinco = findViewById(R.id.iv_App_Cinco);
        ivSeis = findViewById(R.id.iv_App_Seis);
        ivSiete = findViewById(R.id.iv_App_Siete);
        ivOcho = findViewById(R.id.iv_App_Ocho);
        bRegresar = findViewById(R.id.b_Regresar_Apps);
        bActualizar = findViewById(R.id.b_Actualizar);

        try {
            Drawable iconoUno = getPackageManager().getApplicationIcon(appUno);
            ivUno.setImageDrawable(iconoUno);
            Drawable iconoDos = getPackageManager().getApplicationIcon(appDos);
            ivDos.setImageDrawable(iconoDos);
            Drawable iconoTres = getPackageManager().getApplicationIcon(appTres);
            ivTres.setImageDrawable(iconoTres);
            Drawable iconoCuatro = getPackageManager().getApplicationIcon(appCuatro);
            ivCuatro.setImageDrawable(iconoCuatro);
            Drawable iconoCinco = getPackageManager().getApplicationIcon(appCinco);
            ivCinco.setImageDrawable(iconoCinco);
            Drawable iconoSeis = getPackageManager().getApplicationIcon(appSeis);
            ivSeis.setImageDrawable(iconoSeis);
            Drawable iconoSiete = getPackageManager().getApplicationIcon(appSiete);
            ivSiete.setImageDrawable(iconoSiete);
            Drawable iconoOcho = getPackageManager().getApplicationIcon(appOcho);
            ivOcho.setImageDrawable(iconoOcho);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void abrirAppUno(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appUno);
        startActivity(launchIntent);
    }

    public void abrirAppDos(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appDos);
        startActivity(launchIntent);
    }

    public void abrirAppTres(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appTres);
        startActivity(launchIntent);
    }

    public void abrirAppCuatro(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appCuatro);
        startActivity(launchIntent);
    }

    public void abrirAppCinco(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appCinco);
        startActivity(launchIntent);
    }

    public void abrirAppSeis(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appSeis);
        startActivity(launchIntent);
    }

    public void abrirAppSiete(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appSiete);
        startActivity(launchIntent);
    }

    public void abrirAppOcho(View view){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appOcho);
        startActivity(launchIntent);
    }
    public void actualizar_aplicaciones(View view){
        String tipoOperacion =   "app";
        ConexionOnline conexionOnline = new ConexionOnline(this);
        conexionOnline.execute(tipoOperacion, appOcho);
        Drawable cambiarIconoOcho = null;

        try {
            if(conexionOnline.get().equals(appRestringidaUno)) {
                appOcho = "com.ubercab";
            }
            cambiarIconoOcho = getPackageManager().getApplicationIcon(appOcho);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ivOcho.setImageDrawable(cambiarIconoOcho);
    }

    public void regresar(View view){
        super.finish();
    }
}
