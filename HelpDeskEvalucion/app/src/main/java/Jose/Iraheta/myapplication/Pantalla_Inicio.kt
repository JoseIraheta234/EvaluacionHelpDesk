package Jose.Iraheta.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pantalla_Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNumeroTicket = findViewById<EditText>(R.id.txtNumeroTicket)
        val txtTituloTicket = findViewById<EditText>(R.id.txtTituloTicket)
        val txtDescripcionTicket = findViewById<EditText>(R.id.txtDescripcionTicket)
        val txtAutorTicket = findViewById<EditText>(R.id.txtAutorTicket)
        val txtEmailTicket = findViewById<EditText>(R.id.txtEmailContacto)
        val txtFechaCreacionTicket = findViewById<EditText>(R.id.txtFechaCreacionTic)
        val txtEstadoTicket = findViewById<EditText>(R.id.txtEstadoTicket)
        val txtFechaCierreTicket = findViewById<EditText>(R.id.txtFechaFinalizacion)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
    }
}