package com.ejemplo.app.inventoryhotel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.habitaciones.view.*


class HabitacionAdapter (val mCtx : Context, val layoutResId : Int, val habitacionList: List<Habitacion>)
    :ArrayAdapter<Habitacion> (mCtx, layoutResId, habitacionList)
{
    //se genera este método de forma automatica con el método GETVIEW
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View  = layoutInflater.inflate(layoutResId,null)

        val hab_Consultar = view.textView_Consultar_Hab
        val tel_Consultar = view.textView_Consultar_Telefonos
        val mac_Consultar = view.textView_Consultar_MAC
        val ap_Consultar = view.textView_Consultar_Access_Point
        val ubAp_Consultar = view.textView_Consultar_Ubicacion_AP
        val mOrificio_Consultar = view.textView_Consultar_Mesa_Orificio
        val extTv_Consultar = view.textView_Consultar_Ext_Escritorio
        val extMesa_Consultar = view.textView_Consultar_Mesa_Noche
        val extBano_Consultar = view.textView_Consultar_Mesa_Bano
        val observaciones_Consultar = view.textView_Consultar_Observaciones

        val habitacion = habitacionList[position]

        hab_Consultar.text = habitacion.hab
        tel_Consultar.text = habitacion.tel
        mac_Consultar.text = habitacion.mac
        ap_Consultar.text = habitacion.ap
        ubAp_Consultar.text = habitacion.ubicacion
        mOrificio_Consultar.text = habitacion.mesaorificio
        extTv_Consultar.text = habitacion.exttv
        extMesa_Consultar.text = habitacion.extmesa
        extBano_Consultar.text = habitacion.extbano
        observaciones_Consultar.text = habitacion.observaciones

        return view
    }
}
