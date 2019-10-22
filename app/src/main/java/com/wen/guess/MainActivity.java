package com.wen.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    int secret = new Random().nextInt(10)+1;
    private TextView number;
    private ImageView result;
    String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"secret:" + secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.guess_number);
        result = findViewById(R.id.image);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
    public void reset() {
        secret = new Random().nextInt(10)+1;
        Log.d(TAG,"secret:" + secret);
    }
    public void resultButton (View view) {
        int guessNumber = Integer.parseInt(number.getText().toString());

        result.setVisibility(View.VISIBLE);
        result.setAlpha(1.0f);
        if (guessNumber == secret) {
            Toast.makeText(MainActivity.this, "Bingo", Toast.LENGTH_LONG).show();
            result.setImageResource(R.drawable.happy);
        } else if(guessNumber > secret) {
            Toast.makeText(MainActivity.this,"Lower",Toast.LENGTH_LONG).show();
            result.setImageResource(R.drawable.sad);
            result.animate().alpha(0.0f).setDuration(1200);
        } else if (guessNumber < secret) {
                Toast.makeText(MainActivity.this,"Higher",Toast.LENGTH_LONG).show();
            result.setImageResource(R.drawable.sad);
            result.animate().alpha(0.0f).setDuration(1200);
        }
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
}
