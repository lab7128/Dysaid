package com.dys3.dys3;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main3Activity extends Activity implements
        TextToSpeech.OnInitListener {
    /**
     * Called when the activity is first created.
     */

    private TextToSpeech tts;
    private Button btnSpeak;
    private ToggleButton tb;
    private ToggleButton tb2;
    private ToggleButton tb3;
    private ToggleButton tb4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tb = (ToggleButton) findViewById(R.id.o1);
        tb2=(ToggleButton) findViewById(R.id.o2);
        tb3= (ToggleButton) findViewById(R.id.o3);
        tb4=(ToggleButton) findViewById(R.id.o4);

        tb.setOnClickListener(new View.OnClickListener() { //diectly creating onclick
            @Override
            public void onClick(View view) {
                if (tb.isChecked()) {
                    Toast.makeText(Main3Activity.this, "right answer", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(i);

                    finish();
                }
            }

        });

        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb2.isChecked()){
                    Toast.makeText(Main3Activity.this, "wrong answer", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(i);
                }
            }
        });

        tb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tb3.isChecked()){
                    Toast.makeText(Main3Activity.this, "wrong answer", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(i);
                }
            }
        });
        tb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb4.isChecked()){
                    Toast.makeText(Main3Activity.this, "wrong answer", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(i);
                }
            }
        });
        tts = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.btnSpeak);


        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.UK);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);

            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {
        String txtText = "choose the word that rhymes with goose";
        String text = txtText.toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}

