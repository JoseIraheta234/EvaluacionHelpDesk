package Jose.Iraheta.myapplication

import Modelo.ClaseConexion
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtCorreoRegistrarse = findViewById<EditText>(R.id.txtCorreoRegistrarseR)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasenaRegistrarse)
        val btnRegistraseR = findViewById<Button>(R.id.btnRegistrarseR)
        val btnIngresarR = findViewById<Button>(R.id.btnIngresarR)
        val imgVolverR = findViewById<ImageView>(R.id.imgVolver)


        btnRegistraseR.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val objConexion = ClaseConexion().cadenaConexion()

                val crearUsuario  = objConexion?.prepareStatement("insert into tbUsuarioo(uuid_Usuario,correoElectronico,clave) values(?,?,?)")!!

                crearUsuario.setString(1, UUID.randomUUID().toString())
                crearUsuario.setString(2, txtCorreoRegistrarse.text.toString())
                crearUsuario.setString(3, txtContrasena.text.toString())
                crearUsuario.executeUpdate()

                withContext(Dispatchers.Main){
                    Toast.makeText(this@Registrarse, "Usuario Creado", Toast.LENGTH_SHORT).show()
                    txtCorreoRegistrarse.setText("")
                    txtContrasena.setText("")
                }
            }
        }

        btnIngresarR.setOnClickListener {
            val pantallaLogin = Intent(this, MainActivity::class.java)
            startActivity(pantallaLogin)

        }

        imgVolverR.setOnClickListener {
            val pantallaLogin = Intent(this, MainActivity::class.java)
            startActivity(pantallaLogin)
        }
    }
}