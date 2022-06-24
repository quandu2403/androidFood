package com.example.anfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.anfood.Login.Login;
import com.example.anfood.Login.Premire_Tutorial.Premire;
import com.example.anfood.Login.Register;

public class MainActivity extends AppCompatActivity {
ImageView logo;
Thread timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Thread(){
            @Override
            public void run(){
                try {
                    synchronized (this){
                        wait(5000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(MainActivity.this, Premire.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}

