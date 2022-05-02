package com.clase2503.formapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clase2503.formapp.databinding.ActivityMain2Binding
import com.clase2503.formapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val dato1 = intent.getStringExtra("Resultado")

        binding.textView.text = "El resultado es:" + dato1
    }
}