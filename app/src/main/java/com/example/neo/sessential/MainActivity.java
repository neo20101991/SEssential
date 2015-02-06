package com.example.neo.sessential;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void startCalculator(View view) {

        Intent startCalculatorIntent = new Intent(this,
                Calculator.class);
        startActivity(startCalculatorIntent);

    }

    public void startTranslator(View view) {

        Intent startTranslatorIntent = new Intent(this,
                Translator.class);
        startActivity(startTranslatorIntent);

    }

    public void startNotes(View view) {

        Intent startNoteIntent = new Intent(this,
                NoteList.class);
        startActivity(startNoteIntent);

    }

    public void startLocation(View view) {
        Intent startLocationIntent = new Intent(this,
                SplashScreen.class);
        startActivity(startLocationIntent);
    }
}
