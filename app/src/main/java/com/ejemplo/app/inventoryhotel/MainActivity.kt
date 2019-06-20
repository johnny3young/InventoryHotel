package com.ejemplo.app.inventoryhotel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_agregar.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Consultar.setOnClickListener(){
            Log.d("MainActivity","Presionaste el botón consultar")

            //Lanzamos la actividad consultar
            val intent = Intent (this,ConsultarActivity::class.java)
            startActivity(intent)
        }

        btn_Agregar.setOnClickListener(){
            Log.d("MainActivity","Presionaste el botón agregar")
            val intent = Intent(this,AgregarActivity::class.java)
            startActivity(intent)
        }

        btn_eliminar.setOnClickListener(){
            Log.d("MainActivity","Presionaste el botón eliminar")
            val intent = Intent (this,EliminarActivity::class.java)
            startActivity(intent)
        }

    }
}
