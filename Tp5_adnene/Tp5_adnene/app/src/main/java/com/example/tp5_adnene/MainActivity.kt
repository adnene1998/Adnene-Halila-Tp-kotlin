package com.example.tp5_adnene

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.tp5_adnene.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, SensorEventListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var sensorMgr: SensorManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorMgr = getSystemService(SENSOR_SERVICE) as SensorManager


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.Accelerometre -> {
                val monAccelero = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                sensorMgr.registerListener(this, monAccelero, SensorManager.SENSOR_DELAY_NORMAL)
                true
            }

            R.id.Gyroscope -> {
                val monG = sensorMgr.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
                sensorMgr.registerListener(this, monG, SensorManager.SENSOR_DELAY_NORMAL)
                true
            }

            R.id.Magnetometre -> {
                val magno = sensorMgr.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
                sensorMgr.registerListener(this, magno, SensorManager.SENSOR_DELAY_NORMAL)
                true
            }

            R.id.Photometer -> {
                val monphoto = sensorMgr.getDefaultSensor(Sensor.TYPE_LIGHT)
                sensorMgr.registerListener(this, monphoto, SensorManager.SENSOR_DELAY_NORMAL)
                true
            }

            R.id.Proximity -> {
                val monproxy = sensorMgr.getDefaultSensor(Sensor.TYPE_PROXIMITY)
                sensorMgr.registerListener(this, monproxy, SensorManager.SENSOR_DELAY_NORMAL)
                true
            }

            else -> false
        }
    }


    override fun onSensorChanged(event: SensorEvent?) {
      if(event!= null ){
          when(event.sensor.type) {
              Sensor.TYPE_ACCELEROMETER -> {
                  val x = event.values[0]
                  val y = event.values[1]
                  val z = event.values[2]
                  Log.i("accelero", "$x - $y - $z")

              }

              Sensor.TYPE_GYROSCOPE -> {
                  val x = event.values[0]
                  val y = event.values[1]
                  val z = event.values[2]
                  Log.i("gyro", "$x - $y - $z")
              }


              Sensor.TYPE_MAGNETIC_FIELD -> {
                  val x = event.values[0]
                  val y = event.values[1]
                  val z = event.values[2]
                  Log.i("magnomètre", "$x - $y - $z")
              }


              Sensor.TYPE_MAGNETIC_FIELD -> {
                  val x = event.values[0]
                  val y = event.values[1]
                  val z = event.values[2]
                  Log.i("magnomètre", "$x - $y - $z")
              }

              Sensor.TYPE_PROXIMITY -> {
                  val x = event.values[0]

                  Log.i("proximié", "$x")
              }

              Sensor.TYPE_LIGHT -> {
                  val x = event.values[0]
                  Log.i("Light", "$x")
              }



          }
      }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}