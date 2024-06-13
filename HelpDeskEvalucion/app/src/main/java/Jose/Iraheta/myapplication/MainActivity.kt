package Jose.Iraheta.myapplication

import Modelo.ClaseConexion
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtCorreoDeLogin = findViewById<EditText>(R.id.txtCorreoLogin)
        val txtContrasenaLogin = findViewById<EditText>(R.id.txtContrasenaLogin)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)



        btnIngresar.setOnClickListener {
            val pantallaInicio = Intent(this, Pantalla_Inicio::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                val objConexion = ClaseConexion().cadenaConexion()

                val comprobarUser = objConexion?.prepareStatement("select * from tbUsuarioo where correoElectronico = ? and clave = ?")!!
                comprobarUser.setString(1,txtCorreoDeLogin.text.toString())
                comprobarUser.setString(2,txtContrasenaLogin.text.toString())
                val resultado = comprobarUser.executeQuery()

                if(resultado.next()){
                    startActivity(pantallaInicio)
                } else{
                    println("El usuario ingresado no fue encontrado revise sus credenciales")
                }
            }


        }

        btnRegistrar.setOnClickListener {
            val pantallaRegistrar = Intent(this, Registrarse::class.java)
            startActivity(pantallaRegistrar)

        }


        }


    }
