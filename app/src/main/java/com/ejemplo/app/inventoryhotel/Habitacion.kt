package com.ejemplo.app.inventoryhotel

data class Habitacion(
    val id: String?,
    val Hab: String,
    val Tel: String,
    val MAC: String,
    val AccessPoint: String,
    val Ubicacion: String,
    val MesaOrificio: String,
    val ExtTV: String,
    val ExtMesa: String,
    val ExtBano: String,
    val Observaciones: String
) {
    constructor() : this ("","","","","","","","","","","")
}