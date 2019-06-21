package com.ejemplo.app.inventoryhotel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_agregar.*

class AgregarActivity : AppCompatActivity (){

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)

        ref = FirebaseDatabase.getInstance().getReference("Pendientes")

        btn_Agregar_Hab.setOnClickListener {
            guardarHabitacion()
        }
    }

    private fun guardarHabitacion() {
        val hab = editText_Habitacion.text.toString().trim()
        val tel = editText_Cantidad_Tel.text.toString().trim()
        val mac = editText_MAC_Serial.text.toString().trim()
        val ap = editText_AP.text.toString().trim()
        val ubAp = editText_Ubicacion_AP.text.toString().trim()
        val mOrificio = editText_Mesa_Con_Orificio.text.toString().trim()
        val extTv = editText_Ext_TV.text.toString().trim()
        val extMesa = editText_Ext_Mesa.text.toString().trim()
        val extBano = editText_Ext_Bano.text.toString().trim()
        val observaciones = editText_Observaciones.text.toString()

        if (hab.isEmpty()){
            editText_Habitacion.error = "Digite una habitación váilda"
            return
        }

        val habId = ref.push().key

        val habitacion = Habitacion(habId,hab,tel,mac,ap,ubAp,mOrificio,extTv,extMesa,extBano,observaciones)

        ref.child(habId!!).setValue(habitacion).addOnCompleteListener{
            Toast.makeText(applicationContext,"Habitación guardada exitosamente",Toast.LENGTH_LONG).show()
        }

    }
}