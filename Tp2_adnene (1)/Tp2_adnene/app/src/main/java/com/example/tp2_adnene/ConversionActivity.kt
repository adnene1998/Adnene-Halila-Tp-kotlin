package com.example.tp2_adnene

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2_adnene.databinding.ActivityConversionBinding
import com.example.tp2_adnene.databinding.ActivityCurrencyBinding

class ConversionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val sens = intent.getIntExtra("sens",0)
        val montant = intent.getDoubleExtra("nombre",0.0)
        var res = 0.0
        if(sens == 1) {
            res = montant*3.2 ;
            binding.textView.text=res.toString()
        }
        else{
             res = montant*0.3 ;
            binding.textView.text=res.toString()
        }



        binding.buttonEnvoyer.setOnClickListener {
            var i = Intent()
            i.putExtra("res" , res)
            setResult(RESULT_OK,i)
            finish()

        }

        binding.buttonTerminer.setOnClickListener {
            var i  = Intent()
            setResult(RESULT_CANCELED,i)
            finish()
        }


















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}