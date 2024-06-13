package Modelo


import java.sql.Connection
import java.sql.DriverManager

class ClaseConexion {

    fun cadenaConexion(): Connection? {

        try {
            val ip = "jdbc:oracle:thin:@192.168.0.5:1521:xe"
            val usuario = "JOSE_DEVELOPER"
            val contrasena = "77541977"


            val conexion = DriverManager.getConnection(ip,usuario,contrasena)
            return conexion



        }

        catch (e: Exception){
            println("Este es un error: $e")
            return null
        }

    }
}