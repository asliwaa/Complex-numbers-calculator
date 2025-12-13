package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Complex number A
        val reA = findViewById<EditText>(R.id.reA);
        val imA = findViewById<EditText>(R.id.imA);
        //Complex number B
        val reB = findViewById<EditText>(R.id.reB);
        val imB = findViewById<EditText>(R.id.imB);

        val operations = resources.getStringArray(R.array.Operations)


        val operationsSpinner = findViewById<Spinner>(R.id.operationsSpinner)
        if(operationsSpinner!=null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)

            operationsSpinner.adapter = adapter

            operationsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {

                    if (operations[position] == "I choose...") {
                        return
                    } else if (operations[position] == "Addition") {
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
                    } else {
                        val rA: Double = reA.text.toString().toDoubleOrNull() ?: 0.0;
                        val iA: Double = imA.text.toString().toDoubleOrNull() ?: 0.0;
                        val rB: Double = reB.text.toString().toDoubleOrNull() ?: 0.0;
                        val iB: Double = imB.text.toString().toDoubleOrNull() ?: 0.0;
                        val diffRe = rA-rB;
                        val diffIm = iA-iB;

                        if (diffIm < 0) {
                            val diffTmp = diffIm * (-1);
                            Toast.makeText(applicationContext,"Subtraction: " + diffRe + " - " + diffTmp + "i", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(applicationContext,"Subtraction: " + diffRe + " + " + diffIm + "i", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

    }
}