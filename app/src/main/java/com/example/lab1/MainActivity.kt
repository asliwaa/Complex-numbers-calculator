package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //ROZGRZEWKA
        /*
        val btn1 = findViewById<Button>(R.id.btn1);

        btn1.setOnClickListener {
            val e = findViewById<EditText>(R.id.e);
            Toast.makeText(applicationContext, "Hello " + e.text, Toast.LENGTH_SHORT).show();
        } */

        //Zad.1
        /*
        Zaprojektować i zaimplementować kalkulator dla liczb zespolonych. Postać liczby
        zespolonej oraz operacje zostaną podane przez prowadzącego podczas laboratorium.
        Opracować szatę graficzną aplikacji (w miarę dostępnego czasu): zmienić kolory,
        rozmiary elementów aktywności, itp.
        */

        //Addition and subtraction buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd);
        val btnSub = findViewById<Button>(R.id.btnSub);

        //Complex number A
        val reA = findViewById<EditText>(R.id.reA);
        val imA = findViewById<EditText>(R.id.imA);
        //Complex number B
        val reB = findViewById<EditText>(R.id.reB);
        val imB = findViewById<EditText>(R.id.imB);

        btnAdd.setOnClickListener {
            val rA: Double = reA.text.toString().toDoubleOrNull() ?: 0.0;
            val iA: Double = imA.text.toString().toDoubleOrNull() ?: 0.0;
            val rB: Double = reB.text.toString().toDoubleOrNull() ?: 0.0;
            val iB: Double = imB.text.toString().toDoubleOrNull() ?: 0.0;
            val sumRe = rA+rB;
            val sumIm = iA+iB;

            if (sumIm < 0) {
                val tmp = sumIm * (-1);
                Toast.makeText(applicationContext,"Addition: " + sumRe + " - " + tmp + "i", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(applicationContext,"Addition: " + sumRe + " + " + sumIm + "i", Toast.LENGTH_LONG).show();
            }
        }

        btnSub.setOnClickListener {
            val rA: Double = reA.text.toString().toDoubleOrNull() ?: 0.0;
            val iA: Double = imA.text.toString().toDoubleOrNull() ?: 0.0;
            val rB: Double = reB.text.toString().toDoubleOrNull() ?: 0.0;
            val iB: Double = imB.text.toString().toDoubleOrNull() ?: 0.0;
            val diffRe = rA-rB;
            val diffIm = iA-iB;

            if (diffIm < 0) {
                val diffTmp = diffIm * (-1);
                Toast.makeText(applicationContext,"Subtraction: " + diffRe + " - " + diffIm + "i", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(applicationContext,"Subtraction: " + diffRe + " + " + diffIm + "i", Toast.LENGTH_LONG).show();
            }
        }

    }
}