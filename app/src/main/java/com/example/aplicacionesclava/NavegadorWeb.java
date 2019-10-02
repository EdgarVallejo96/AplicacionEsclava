package com.example.aplicacionesclava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NavegadorWeb extends AppCompatActivity {

    private WebView wvNavegadorWeb;
    private EditText etDireccionWeb;
    private Button bRegresarWeb;
    private Button bBuscar;
    private Button bActualizarWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_web);

        wvNavegadorWeb = findViewById(R.id.wv_Navegador_Web);
        etDireccionWeb = findViewById(R.id.et_Direccion_Web);
        bRegresarWeb = findViewById(R.id.b_Regresar_Web);
        bBuscar = findViewById(R.id.b_Buscar);
        bActualizarWeb = findViewById(R.id.b_Actualizar_Web);

        wvNavegadorWeb.getSettings().setJavaScriptEnabled(true);
        wvNavegadorWeb.setWebViewClient(new WebViewClient());
        wvNavegadorWeb.loadUrl("https://unis.blackboard.com");
    }

    public void regresar(View view){
        super.finish();
    }

    public void buscar(View view){
        String https = "https://";
        String url = etDireccionWeb.getText().toString();
        String urlFinal = https + url.toLowerCase();
        String restriccionUno = https + "facebook.com";
        String restriccionDos = https + "instagram.com";
        String restriccionTres = https + "youtube.com";

        if(urlFinal.equals(restriccionUno) || urlFinal.equals(restriccionDos) || urlFinal.equals(restriccionTres)){
            etDireccionWeb.setText("Dirección prohibida. Intente de nuevo.");
        } else{
            wvNavegadorWeb.loadUrl(urlFinal);
            etDireccionWeb.setText("");
        }
    }

    public void actualizar_Paginas_Web(View view){
        String tipoOperacion = "web";
        ConexionOnline conexionOnline = new ConexionOnline(this);
        conexionOnline.execute(tipoOperacion, "unis.edu.gt");
    }
}
