package com.example.lesson1java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration extends AppCompatActivity {
    private EditText editName,  editSur ;
    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editName  =(EditText) findViewById(R.id.name_registr);
        editSur  = (EditText) findViewById(R.id.fam_registr);
        txtShow = (TextView) findViewById(R.id.text_read);
    }
    public void read (View view) {
       try {
           FileInputStream fileInput = openFileInput("myFile.txt");
           InputStreamReader reader = new InputStreamReader(fileInput);
           BufferedReader buffer = new BufferedReader(reader);
           StringBuffer strBuffer = new StringBuffer();
           String lines;
           while ((lines = buffer.readLine()) != null){
            strBuffer.append(lines + "\n");
           }
           txtShow.setText(strBuffer.toString());
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void write (View view) {
        String myTxt = editName.getText().toString();
        String myTxtTwo = editSur.getText().toString();
        try {
            FileOutputStream fileOutput = openFileOutput("myFile.txt", MODE_PRIVATE);
            fileOutput.write(myTxt.getBytes());
            fileOutput.write(myTxtTwo.getBytes());
            fileOutput.close();
            editName.setText("");
            editSur.setText("");
            Toast.makeText(Registration.this, "Имя и Фамилия сохранены", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
