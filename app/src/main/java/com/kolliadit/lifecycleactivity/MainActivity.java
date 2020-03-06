package com.kolliadit.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;
    TextView displayText;
    TextView stopText;
    TextView pauseText;
    TextView resumeText;
    TextView startText;
    TextView restartText;
    TextView destroyText;
    int[] scores = new int[]{0,0,0,0,0,0,0};
    int[] thissession=new int[]{0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref= getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
        for(int num=0;num<7;num++)
            scores[num]=pref.getInt(""+num,0);
        scores[0]++;
        editor.putInt("0", scores[0]);
        displayText=findViewById(R.id.create);
        stopText=findViewById(R.id.stop);
        pauseText=findViewById(R.id.pause);
        resumeText=findViewById(R.id.resume);
        startText=findViewById(R.id.start);
        restartText=findViewById(R.id.restart);
        destroyText=findViewById(R.id.destroy);
        stopText.setText("Stop: "+scores[4]+", "+thissession[4]);
        editor.apply();

        thissession[0]++;
        displayText.setText("Create: "+scores[0]+", "+thissession[0]);
        stopText.setText("Stop: "+scores[4]+", "+thissession[4]);
        startText.setText("Start: "+scores[1]+", "+thissession[1]);
        pauseText.setText("Pause: "+scores[3]+", "+thissession[3]);
        restartText.setText("Restart: "+scores[5]+", "+thissession[5]);
        destroyText.setText("Destroy: "+scores[6]+", "+thissession[6]);
    }
    @Override
    public void onStart() {

        super.onStart();
        thissession[1]++;
        scores[1]++;
        editor.putInt("1", scores[1]);
        editor.commit();
        startText.setText("Start: "+scores[1]+", "+thissession[1]);
    }
    @Override
    public void onResume() {

        super.onResume();
        thissession[2]++;
        scores[2]++;
        editor.putInt("2", scores[2]);
        editor.commit();
        resumeText.setText("Resume: "+scores[2]+", "+thissession[2]);
    }
    @Override
    public void onPause() {

        super.onPause();
        thissession[3]++;
        scores[3]++;
        editor.putInt("3", scores[3]);
        editor.commit();
        pauseText.setText("Pause: "+scores[3]+", "+thissession[3]);
    }
    @Override
    public void onStop() {


        thissession[4]++;
        scores[4]++;
        editor.putInt("4", scores[4]);
        editor.commit();
        stopText.setText("Stop: "+scores[4]+", "+thissession[4]);
        super.onStop();
    }
    @Override
    public void onRestart() {
        super.onRestart();

        thissession[5]++;
        scores[5]++;
        editor.putInt("5", scores[5]);
        editor.commit();
        restartText.setText("Restart: "+scores[5]+", "+thissession[5]);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        thissession[6]++;
        scores[6]++;
        editor.putInt("6", scores[6]);
        editor.commit();
        destroyText.setText("Destroy: "+scores[6]+", "+thissession[6]);

    }
    public void onC (View view){
        for(int x=0;x<7;x++)
        {
            scores[x]=0;
            thissession[x]=0;
            editor.putInt(""+x,0);
            editor.commit();
        }

        displayText.setText("Create: "+scores[0]+", "+thissession[0]);
        stopText.setText("Stop: "+scores[4]+", "+thissession[4]);
        startText.setText("Start: "+scores[1]+", "+thissession[1]);
        pauseText.setText("Pause: "+scores[3]+", "+thissession[3]);
        restartText.setText("Restart: "+scores[5]+", "+thissession[5]);
        destroyText.setText("Destroy: "+scores[6]+", "+thissession[6]);
        resumeText.setText("Resume: "+scores[2]+", "+thissession[2]);



    }

}