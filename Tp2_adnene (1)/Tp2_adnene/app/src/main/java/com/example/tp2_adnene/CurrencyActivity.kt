package com.example.tp2_adnene

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2_adnene.databinding.ActivityCurrencyBinding

class CurrencyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dinar_Euro = binding.dinarEuro
        val euro_dinar = binding.euroDinar
        val montant = binding.montant


        var theLancher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            when (it.resultCode) {
                RESULT_OK -> binding.resulat.text = it.data?.getDoubleExtra("res",0.0).toString()
                RESULT_CANCELED -> Toast.makeText(applicationContext,"action annulée !! " , Toast.LENGTH_LONG).show()

            }



        }


        dinar_Euro.setOnClickListener {

            if (montant.toString().isEmpty()) {
                Toast.makeText(this, "champ vide ", Toast.LENGTH_SHORT).show()
            }
        else {
                val montantValue = montant.text.toString().toDouble()
                intent = Intent(this,ConversionActivity::class.java)
                intent.putExtra("sens",1)
                intent.putExtra("nombre",montantValue)

                //startActivity(intent)
                theLancher.launch(intent)
            }


        }



        euro_dinar.setOnClickListener {

            if (montant.toString().isEmpty()) {
                Toast.makeText(this, "champ vide ", Toast.LENGTH_SHORT).show()
            }
           else {
                val montantValue = montant.text.toString().toDouble()
                intent = Intent(this,ConversionActivity::class.java)
                intent.putExtra("sens",2)
                intent.putExtra("nombre",montantValue)

               // startActivity(intent)
                theLancher.launch(intent)
            }


         //   val res = montantValue*0.3 ;
        //    binding.resulat.setText(res.toString())


        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}