package com.example.aplicacionesclava;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConexionOnline extends AsyncTask<String, Void, String> {
    private Context context;
    private AlertDialog alertDialog;
    public ConexionOnline(Context context) { // Esto estaba como Context ctx
        this.context = context; // Esto estaba como context = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Reglas Aplicadas: ");
    }

    @Override
    protected String doInBackground(String... datos) {
        String operacion = datos[0];
        String direccionWeb = "https://direccion_web/consultarApps.php";
        if(operacion.equals("app")) {
            try {
                String app = datos[1];
                URL url = new URL(direccionWeb);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String datosPost = URLEncoder.encode("app", "UTF-8") + "=" + URLEncoder.encode(app, "UTF-8");
                bufferedWriter.write(datosPost);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();// Al hacer post a los datos, puede haber una respuesta de la petición post.
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultado = "";
                String linea;
                while((linea = bufferedReader.readLine()) != null) {
                    resultado += linea;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultado;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String web = datos[1];
                direccionWeb = "https://parentalhub.000webhostapp.com/consultarPaginasWeb.php";
                URL url = new URL(direccionWeb);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String datosPost = URLEncoder.encode("web", "UTF-8") + "=" + URLEncoder.encode(web, "UTF-8");
                bufferedWriter.write(datosPost);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();// Al hacer post a los datos, puede haber una respuesta de la petición post.
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String resultado = "";
                String linea;
                while((linea = bufferedReader.readLine()) != null) {
                    resultado += linea;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return resultado;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String resultado) {
        alertDialog.setMessage(resultado);
        alertDialog.show();
    }
}
