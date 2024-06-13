package Modelo

data class dataClassTickets(
    val uuid: String,
    var titulo : String,
    var descripcion : String,
    var autor : String,
    var email : String,
    var fechaCreacion: String,
    var estado: String,
    var fechaFinalizacion: String
)
