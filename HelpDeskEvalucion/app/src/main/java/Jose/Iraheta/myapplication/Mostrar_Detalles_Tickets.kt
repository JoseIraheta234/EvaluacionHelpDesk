package Jose.Iraheta.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Mostrar_Detalles_Tickets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mostrar_detalles_tickets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         val txtUUID = findViewById<TextView>(R.id.txtUUIDdetallesT)
         val txtTitulo = findViewById<TextView>(R.id.txtTitulodetallesT)
         val txtDescripcion =findViewById<TextView>(R.id.txtDescripciondetallesT)
        val txtEmail = findViewById<TextView>(R.id.txtEmailContactodetallesT)
        val txtFechaCreacion = findViewById<TextView>(R.id.txtFechaCdetallesT)
        val txtAutor = findViewById<TextView>(R.id.txtAutordetallesT)
        val txtEstado = findViewById<TextView>(R.id.txtEstadodetallesT)
        val txtfechaFinalizacion = findViewById<TextView>(R.id.txtFechaFdetallesT)
        val imagen = findViewById<ImageView>(R.id.imgVolverdetallesTickets)


        val uuid = intent.getStringExtra("uuid")
        val titulo = intent.getStringExtra("titulo")
        val descripcion = intent.getStringExtra("Descripcion")
        val autor = intent.getStringExtra("Autor")
        val email = intent.getStringExtra("email")
        val fechaCreacion = intent.getStringExtra("fechaCreacion")
        val estado = intent.getStringExtra("estado")
        val fechaFinalizacion = intent.getStringExtra("fechaFinalizacion")


        txtUUID.text = uuid
        txtTitulo.text = titulo
        txtDescripcion.text = descripcion
        txtAutor.text = autor
        txtEmail.text = email
        txtFechaCreacion.text = fechaCreacion
        txtEstado.text = estado
        txtfechaFinalizacion.text = fechaFinalizacion


        imagen.setOnClickListener {
            val RegresarPantalla = Intent(this, Pantalla_Inicio::class.java)
            startActivity(RegresarPantalla)
        }
    }
}