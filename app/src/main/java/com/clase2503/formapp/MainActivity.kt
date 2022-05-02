package com.clase2503.formapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.clase2503.formapp.databinding.ActivityMainBinding

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
                val resultado = 0;
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

            when (opcion){
                0 -> {}
                1 -> {}
                2 -> {}
            }

            if (!dato1.isNullOrEmpty() && !dato2.isNullOrEmpty() && !dato3.isNullOrEmpty()){
                val intent = Intent(this, MainActivity2::class.java).apply {
                    putExtra("Dato1", dato1)
                    putExtra("Dato2", dato2)
                    putExtra("Dato3", dato3)
                }
                startActivity(intent)
            }else{
                Toast.makeText(
                    this,
                    "Te faltan parámetros", Toast.LENGTH_LONG
                ).show()
            }
        }
    }


}