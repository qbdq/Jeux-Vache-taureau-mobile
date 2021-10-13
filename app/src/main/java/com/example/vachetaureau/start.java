package com.example.vachetaureau;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class start extends AppCompatActivity {
   int nb_tenta;
   int waqt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);


        Button base = (Button)findViewById(R.id.base);
        final   RadioButton mono = (RadioButton) findViewById(R.id.mono);
        final   RadioButton multi = (RadioButton) findViewById(R.id.multi);
        final   RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        final   RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        final   RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        final TextView textview2 = (TextView) findViewById(R.id.textView2);
        final RadioGroup radio = (RadioGroup) findViewById(R.id.radio) ;
        radio.setVisibility(View.GONE);
        mono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview2.setText("");
                radio.setVisibility(View.VISIBLE);
            }
        });
        multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textview2.setText("");
                radio.setVisibility(View.GONE);
            }
        });

        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent base = new Intent(start.this, Consultebase.class);
                startActivity(base);
            }
        });












        final   Button startbtn = (Button) findViewById(R.id.startbtn);
        startbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!mono.isChecked() && !multi.isChecked())
                {
                    textview2.setText("Vous devez choisir un mode de jeux");
                }
                else if (mono.isChecked() && (!radio1.isChecked() && !radio2.isChecked() && !radio3.isChecked() ))
                {
                    textview2.setText("Vous devez choisir niveau");
                }
                else if (mono.isChecked() && ( radio1.isChecked() || radio2.isChecked() || radio3.isChecked() ))
                {
                  if (radio1.isChecked())
                  {
                      waqt=25;
                      nb_tenta=15;
                  }
                    if (radio2.isChecked())
                    {
                        waqt=20;
                        nb_tenta=10;
                    }
                    if (radio3.isChecked())
                    {
                        waqt=15;
                        nb_tenta=5;
                    }


                    openactivityplay(); }
                else if (multi.isChecked())
                {
                    textview2.setText("On a pas implementé");
                }


            }
            public int getNb()
            {
             return nb_tenta;
            }
        });
    }
   public void openactivityplay (){
        Intent intent = new Intent(getBaseContext() , MainActivity.class);
        intent.putExtra("nbre",nb_tenta);
        intent.putExtra("wa9t",waqt);
        startActivity(intent);
    }
}
