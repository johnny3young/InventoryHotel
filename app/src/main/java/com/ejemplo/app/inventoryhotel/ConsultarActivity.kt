package com.ejemplo.app.inventoryhotel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_consultar.*

class ConsultarActivity : AppCompatActivity() {

    lateinit var habitacionList: MutableList<Habitacion>
    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        habitacionList = mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Pendientes")


        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    for (h in p0.children){
                        val habitacion = h.getValue(Habitacion::class.java)
                        habitacionList.add(habitacion!!)
                    }

                    val adapter = HabitacionAdapter(applicationContext,R.layout.habitaciones, habitacionList)
                    listView_Consultar.adapter = adapter
                }

            }

        })
    }
}
