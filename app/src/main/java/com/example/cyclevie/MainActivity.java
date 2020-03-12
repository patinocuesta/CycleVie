package com.example.cyclevie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    String valeur="bonjour";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("cycle", "activity cree");
    /*    int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }*/
    if(savedInstanceState!=null && savedInstanceState.getString("valeur")!=null){
        valeur=savedInstanceState.getString("valeur");
    }
        Toast.makeText(this, valeur, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cycle","activity a demarre");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cycle","activity a resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cycle","activity a pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cycle","activity a stoppe");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cycle","activity est detruite");
    }
    public void action(View view) {
        //finish();
        valeur="Bonjour à tous";
        Toast.makeText(this, valeur, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"LANDSCAPE", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation==Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this,"PORTRAIT", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("cycle", "onsaveinstantestate");
        savedInstanceState.putString("valeur", valeur);
    }
}
