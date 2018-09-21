package com.example.belester.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText telefonoEditText;
EditText paginaEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telefonoEditText = (EditText)findViewById(R.id.telefono);
        paginaEditText = (EditText)findViewById(R.id.paginaweb);
    }
public void intentTeleno (View view){
        String numero =telefonoEditText.getText().toString();
        if(TextUtils.isDigitsOnly(numero) && numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + numero));
            startActivity(intent);
        }else {
            telefonoEditText.setError("El telefono tiene que ser de 10 digitos");
        }
}
public void intentWeb(View view){
        String url = paginaEditText.getText().toString();
        if(URLUtil.isAboutUrl(url)) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW);
            mapIntent.setData(Uri.parse(url));
            startActivity(mapIntent);
        }
    }


public void intentMaps(View view){
        Uri gmmIntenUri =Uri.parse("geo;37.7749-122-419");
       Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntenUri);
       mapIntent.setPackage("com.google.android.apps.maps");
       startActivity(mapIntent);

    }

}
