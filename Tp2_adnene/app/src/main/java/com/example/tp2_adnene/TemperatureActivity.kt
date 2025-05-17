package com.example.tp2_adnene

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2_adnene.databinding.ActivityCurrencyBinding
import com.example.tp2_adnene.databinding.ActivityTemperatureBinding
import kotlin.math.floor

class TemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_temperature)

        val binding = ActivityTemperatureBinding.inflate(layoutInflater)

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, checked ->
           val inp = binding.temp.text.toString().toDouble()
           when (checked) {
               R.id.c_f ->{
                    var tf = (9/5)*inp +32

                   if (binding.arr.isChecked){
                       tf = floor(tf)
                   }

                   binding.Resultat.text = tf.toString()
               }

               R.id.f_c ->{
                   var tc = (5/9)*inp +32
                   if (binding.arr.isChecked){
                       tc = floor(tc)
                   }

                   binding.Resultat.text = tc.toString()
               }
               
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}