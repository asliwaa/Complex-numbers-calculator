package com.example.lab1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pola tekstowe
        val reA = findViewById<EditText>(R.id.reA)
        val imA = findViewById<EditText>(R.id.imA)
        val reB = findViewById<EditText>(R.id.reB)
        val imB = findViewById<EditText>(R.id.imB)

        val operations = resources.getStringArray(R.array.Operations)
        val operationsSpinner = findViewById<Spinner>(R.id.operationsSpinner)

        if (operationsSpinner != null) {

            // Tworzymy adapter z logiką ukrywania pierwszego elementu
            val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operations) {

                // Ta metoda odpowiada za wygląd ROZWINIĘTEJ listy
                override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                    if (position == 0) {
                        // Jeśli to pierwsza pozycja (indeks 0), zwracamy pusty View o wymiarach 0
                        val emptyView = View(context)
                        // Ustawiamy wysokość na 0 pikseli
                        emptyView.layoutParams = android.widget.AbsListView.LayoutParams(0, 0)
                        emptyView.visibility = View.GONE
                        return emptyView
                    } else {
                        // Dla pozostałych pozycji (1, 2...) pobieramy standardowy wygląd.
                        // Przekazujemy 'null' jako convertView, aby nie dostać z recyklingu naszego emptyView
                        return super.getDropDownView(position, null, parent)
                    }
                }

                // Ta metoda odpowiada za wygląd ZWINIĘTEGO spinnera (to co widać przed kliknięciem)
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    // Tutaj chcemy normalnie widzieć "I choose..." jeśli jest wybrane
                    return super.getView(position, convertView, parent)
                }

                // Blokujemy możliwość kliknięcia w (teoretycznie ukrytą) pierwszą opcję
                override fun isEnabled(position: Int): Boolean {
                    return position != 0
                }
            }

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            operationsSpinner.adapter = adapter

            operationsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                    // Ignorujemy wybór pozycji 0 ("I choose...")
                    if (position == 0) return

                    val rA: Double = reA.text.toString().toDoubleOrNull() ?: 0.0
                    val iA: Double = imA.text.toString().toDoubleOrNull() ?: 0.0
                    val rB: Double = reB.text.toString().toDoubleOrNull() ?: 0.0
                    val iB: Double = imB.text.toString().toDoubleOrNull() ?: 0.0

                    if (operations[position] == "Addition") {
                        val sumRe = rA + rB
                        val sumIm = iA + iB
                        val operator = if (sumIm < 0) "-" else "+"
                        val imAbs = kotlin.math.abs(sumIm)
                        Toast.makeText(applicationContext, "Addition: $sumRe $operator ${imAbs}i", Toast.LENGTH_LONG).show()
                    } else {
                        val diffRe = rA - rB
                        val diffIm = iA - iB
                        val operator = if (diffIm < 0) "-" else "+"
                        val imAbs = kotlin.math.abs(diffIm)
                        Toast.makeText(applicationContext, "Subtraction: $diffRe $operator ${imAbs}i", Toast.LENGTH_LONG).show()
                    }

                    // RESETOWANIE SPINNERA
                    // To sprawi, że na ekranie znów pojawi się "I choose...",
                    // a po kliknięciu lista rozwinie się od razu pokazując "Addition".
                    operationsSpinner.setSelection(0)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }
}