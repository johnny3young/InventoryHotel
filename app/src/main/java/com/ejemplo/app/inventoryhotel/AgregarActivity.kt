package com.ejemplo.app.inventoryhotel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_agregar.*

class AgregarActivity : AppCompatActivity (){

    lateinit var ref : DatabaseReference
    lateinit var myRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        ref = FirebaseDatabase.getInstance().getReference("Hotel/Milla")

        myRef = FirebaseDatabase.getInstance().getReference("Pruebajajajaaja")
        myRef.setValue("Esto es una prueba sin presionar ningún botón, SOLO abriendo la app en guardar")

        btn_Agregar_Hab.setOnClickListener {
            guardarHabitacion()
        }
    }

    private fun guardarHabitacion() {
        val hab: String = editText_Habitacion.text.toString().trim()
        val tel = editText_Cantidad_Tel.text.toString().trim()
        val mac = editText_MAC_Serial.text.toString().trim()
        val ap = editText_AP.text.toString().trim()
        val ubicacion = editText_Ubicacion_AP.text.toString().trim()
        val mesaorificio = editText_Mesa_Con_Orificio.text.toString().trim()
        val exttv = editText_Ext_TV.text.toString().trim()
        val extmesa = editText_Ext_Mesa.text.toString().trim()
        val extbano = editText_Ext_Bano.text.toString().trim()
        val observaciones = editText_Observaciones.text.toString()

        if (hab.isEmpty()){
            editText_Habitacion.error = "Digite una habitación válida"
            return
        }

        //val hab: String = ref.push().key

        val habitacion = Habitacion(hab,tel,mac,ap,ubicacion,mesaorificio,exttv,extmesa,extbano,observaciones)

        ref.child(hab!!).setValue(habitacion).addOnCompleteListener{
            Toast.makeText(applicationContext,"Habitación guardada exitosamente",Toast.LENGTH_LONG).show()
        }

    }
}