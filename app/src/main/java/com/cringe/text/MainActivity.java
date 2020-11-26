package com.cringe.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertText(View view) {
        String org = ((EditText) findViewById(R.id.text)).getText().toString();
        ((EditText) findViewById(R.id.text)).setText("");
        char split_conv[] = new char[org.length()];

        Boolean isCap = false;
        for (int i = 0; i < org.length(); i++) {
            if (isCap) {
                split_conv[i] = Character.toUpperCase(org.charAt(i));
                isCap = false;
            }
            else {
                split_conv[i] = Character.toLowerCase(org.charAt(i));
                isCap = true;
            }
        }

        String conv = new String(split_conv);

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", conv);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
        finish();
    }
}
