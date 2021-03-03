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

        String convertedText = convertText(text.toString());

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_PROCESS_TEXT, convertedText);
        setResult(RESULT_OK, intent);
        finish();
    }

    public String convertText(String originalText) {
        char split_conv[] = new char[originalText.length()];

        Boolean isCap = false;
        for (int i = 0; i < originalText.length(); i++) {
            char currentChar = Character.toLowerCase(originalText.charAt(i));
            char replacedChar;

            switch (currentChar) {
                case 'i':
                    replacedChar = 'i';
                    break;
                case 'l':
                case 't':
                    replacedChar = Character.toUpperCase(currentChar);
                    break;
                default:
                    if (isCap) {
                        replacedChar = Character.toUpperCase(currentChar);
                        isCap = false;
                    }
                    else {
                        replacedChar = Character.toLowerCase(currentChar);
                        isCap = true;
                    }
            }
            split_conv[i] = replacedChar;
        }

        return new String(split_conv);
    }

}