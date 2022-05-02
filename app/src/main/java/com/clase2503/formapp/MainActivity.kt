package com.clase2503.formapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View import android.widget.*
import com.clase2503.formapp.databinding.ActivityMainBinding
import java.lang.Math.sqrt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private var opcion = 0;
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initSpinner()
        listeners()
    }

    private fun initSpinner(){
        val listForm : ArrayList<String> = ArrayList()
        listForm.add("Formula General")
        listForm.add("Volumen de un Prisma")
        listForm.add("Euler Polihedro")

        // Creating adapter for spinner
        val dataAdapter = ArrayAdapter(this, R.layout.item, listForm)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // attaching data adapter to spinner
        binding.Spinner.adapter = dataAdapter
        binding.Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                opcion = position;
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(
                    parent.context,
                    "Output...$item", Toast.LENGTH_LONG
                ).show()
                val imageView = findViewById<ImageView>(R.id.imageView)
                val etiqueta_1 = findViewById<TextView>(R.id.textView1)
                val etiqueta_2 = findViewById<TextView>(R.id.textView2)
                val etiqueta_3 = findViewById<TextView>(R.id.textView3)

                when (position) {
                    0 -> {
                        imageView.setImageResource(R.drawable.imagen1);
                        etiqueta_1.text = "b: ";
                        etiqueta_2.text = "a: ";
                        etiqueta_3.text = "c: ";

                    }
                    1 -> {
                        imageView.setImageResource(R.drawable.image2);
                        etiqueta_1.text = "l: ";
                        etiqueta_2.text = "b: ";
                        etiqueta_3.text = "h: ";
                    }
                    2 -> {
                        imageView.setImageResource(R.drawable.euler2);
                        etiqueta_1.text = "F: ";
                        etiqueta_2.text = "V: ";
                        etiqueta_3.text = "E: ";
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun listeners() {

        binding.btnCalc.setOnClickListener {
            val dato1 = binding.etOptionA.text.toString()
            val dato2 = binding.etOptionB.text.toString()
            val dato3 = binding.etOptionC.text.toString()

            val parametro1 = dato1.toFloat()
            val parametro2 = dato2.toFloat()
            val parametro3 = dato3.toFloat()

            var resultado = ""


            if (!dato1.isNullOrEmpty() && !dato2.isNullOrEmpty() && !dato3.isNullOrEmpty()){

                when (opcion){
                    0 -> {
                        if(parametro1*parametro1 < 4*parametro2*parametro3){
                            Toast.makeText(
                                this,
                                "El discriminante debe ser positivo", Toast.LENGTH_LONG
                            ).show()
                        }else {

                            val intent = Intent(this, MainActivity2::class.java).apply {
                                putExtra("Resultado", ((-parametro1+sqrt(parametro1*parametro1 - 4*parametro2*parametro3))/2*parametro2).toString())
                            }
                            startActivity(intent)
                        }
                    }
                    1 -> {
                        if (parametro1 < 0  || parametro2 < 0 || parametro2 < 0){
                            Toast.makeText(
                                this,
                                "Las longitudes deben ser positivas", Toast.LENGTH_LONG
                            ).show()
                        }else{
                            val intent = Intent(this, MainActivity2::class.java).apply {
                                putExtra("Resultado", (parametro1*parametro2*parametro3).toString())
                            }
                            startActivity(intent)
                        }

                    }
                    2 -> {
                        val parametro1 = dato1.toInt()
                        val parametro2 = dato2.toInt()
                        val parametro3 = dato3.toInt()
                        if ((parametro1+parametro2-parametro3) != 2){
                            Toast.makeText(
                                this,
                                "Ese no es un poliedro", Toast.LENGTH_LONG
                            ).show()
                        }else{
                            val intent = Intent(this, MainActivity2::class.java).apply {
                                putExtra("Resultado", (parametro1+parametro2-parametro3).toString())
                            }
                            startActivity(intent)

                        }
                    }
                }

            }else{
                Toast.makeText(
                    this,
                    "Te faltan parámetros", Toast.LENGTH_LONG
                ).show()
            }
        }
    }


}