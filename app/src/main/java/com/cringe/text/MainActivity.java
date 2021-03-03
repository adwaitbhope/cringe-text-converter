package com.cringe.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button convertTextButton = findViewById(R.id.convert_button);
        convertTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((EditText) findViewById(R.id.text)).getText().toString();
                String convertedText = TextProcessor.convertText(text);
                ((EditText) findViewById(R.id.text)).setText("");

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("", convertedText);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
