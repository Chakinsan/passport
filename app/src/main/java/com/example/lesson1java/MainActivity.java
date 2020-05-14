package com.example.lesson1java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imj7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoogen_layout);
        addListennerOnImaje();
    }
    public void addListennerOnImaje () {
        imj7 = findViewById(R.id.imageView7);
        imj7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder a_bilder = new AlertDialog.Builder(MainActivity.this);
                        a_bilder.setMessage("Вы хотите закрыть приложение?")
                                .setCancelable(false)
                                .setPositiveButton("ДА", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog alert = a_bilder.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();
                    }
                }
        );
    }

}
