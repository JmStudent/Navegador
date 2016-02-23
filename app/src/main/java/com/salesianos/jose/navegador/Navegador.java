package com.salesianos.jose.navegador;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Navegador extends AppCompatActivity {

    //Creamos variables
    private EditText mSearch = null;
    private Button mGo = null;
    WebView mPagina = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        //Valor a las variables excepto el WebView
        mSearch = (EditText) findViewById(R.id.cuadroText);
        mGo = (Button) findViewById(R.id.botonWeb);

        //Le damos valor a la variable webview y cargamos la página en local
        mPagina = (WebView) findViewById(R.id.vistaWeb);
        mPagina.loadUrl("file:///android_asset/web.html");

        //Activamos Java para que se vea la imagen
        WebSettings activarJava = mPagina.getSettings();
        activarJava.setJavaScriptEnabled(true);

        //
        mGo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String pagina = mSearch.getEditableText().toString();
                mPagina.loadUrl(pagina);
            }
        });

        //Cargamos google, dentro de la página.
        mPagina.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView browser, String url) {
                browser.loadUrl(url);
                mSearch.setText(url);
                return(true);
            }
        });


    }
}
