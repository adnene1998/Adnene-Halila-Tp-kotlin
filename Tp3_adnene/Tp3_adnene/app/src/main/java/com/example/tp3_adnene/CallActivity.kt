package com.example.tp3_adnene

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp3_adnene.databinding.ActivityCallBinding
import com.example.tp3_adnene.databinding.ActivityMainBinding

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       val binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = binding.btnCall

        btn.setOnClickListener {
            val number = binding.saisiePhone.text.toString()
            intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)) ;
            startActivity(intent) ;

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets










        }
    }
}