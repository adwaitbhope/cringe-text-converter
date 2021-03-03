package com.cringe.text;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class IntentReceiverActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence text = getIntent()
                .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);

        String convertedText = TextProcessor.convertText(text.toString());

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_PROCESS_TEXT, convertedText);
        setResult(RESULT_OK, intent);
        finish();
    }
}