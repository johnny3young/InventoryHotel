package com.ejemplo.app.inventoryhotel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {

    lateinit var habitacionList: MutableList<Habitacion>
    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        //Si agrego "Habitacion" adentro de "MutableListOf" aparece una vista adicional cuando muestro los datos
        habitacionList = mutableListOf()

         ref = FirebaseDatabase.getInstance().getReference("Hotel/Milla")

        //Leyendo desde la DB
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //Validando que exista la DB
                if (dataSnapshot.exists()){

                    habitacionList.clear()

                    for (datos in dataSnapshot.children){

                       var infoHabitaciones = datos.getValue(Habitacion::class.java)
                        Log.e("infoHabitaciones", "infoHabitaciones: $infoHabitaciones")
                       habitacionList.add(infoHabitaciones!!)

                        Log.e("HabitacionList", "HabitacionList: $habitacionList")
                        Log.e("dataSnapshot","lo que almacena dataSnapshot" + dataSnapshot.value)
                    }

                    var adapter = HabitacionAdapter(this@ConsultarActivity,R.layout.habitaciones, habitacionList)
                    listView_Consultar.adapter = adapter
                }

            }

        })
    }
}
