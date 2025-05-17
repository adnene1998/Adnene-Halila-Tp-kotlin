package com.example.tp6_adnene

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp6_adnene.adapters.CityAdapter
import com.example.tp6_adnene.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , CityAdapter.onCityclickListener {
    private val baseUrl = "https://api.openweathermap.org/data/2.5/"
    private val cities = arrayOf("Tunis", "Paris", "Londres", "Alger", "marrakech" , "berlin","madrid","lisbon" , "sousse","mahdia","monastir")

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recycler.layoutManager = LinearLayoutManager(this) //


        binding.recycler.adapter = CityAdapter(cities,this)
    }

    override fun onCityclick(city: String) {
        Toast.makeText(this, city, Toast.LENGTH_SHORT).show()
    }
}
