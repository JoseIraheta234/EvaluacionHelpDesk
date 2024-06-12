package Jose.Iraheta.myapplication

import Jose.Iraheta.myapplication.recycleviewHelper.Adaptador
import Modelo.ClaseConexion
import Modelo.dataClassTickets
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        val txtTituloTicket = findViewById<EditText>(R.id.txtTituloTicket)
        val txtDescripcionTicket = findViewById<EditText>(R.id.txtDescripcionTicket)
        val txtAutorTicket = findViewById<EditText>(R.id.txtAutorTicket)
        val txtEmailTicket = findViewById<EditText>(R.id.txtEmailContacto)
        val txtFechaCreacionTicket = findViewById<EditText>(R.id.txtFechaCreacionTic)
        val txtEstadoTicket = findViewById<EditText>(R.id.txtEstadoTicket)
        val txtFechaCierreTicket = findViewById<EditText>(R.id.txtFechaFinalizacion)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val rcvTickets = findViewById<RecyclerView>(R.id.rcvTicket)





        rcvTickets.layoutManager = LinearLayoutManager(this)

        fun obtenerDatosTickets(): List<dataClassTickets>{
            val objConexion = ClaseConexion().cadenaConexion()

            val statement = objConexion?.createStatement()
            val resultset = statement?.executeQuery("SELECT * FROM tbTicket")

            val tickets = mutableListOf<dataClassTickets>()
            while(resultset?.next() == true){

                val uuid = resultset.getString("uuid_Tiket")
                val titulo = resultset.getString("titulo_Ticket")
                val descripcion = resultset.getString("descripcion_Ticket")
                val autor = resultset.getString("autor_Ticket")
                val email = resultset.getString("email_Contacto_Autor")
                val fechaCreacion = resultset.getString("fecha_Creacion_Ticket")
                val estado = resultset.getString("estado_Ticket")
                val fechaFinalizacion = resultset.getString("feche_Finalizacion_Ticket")

                //val TodosLosValores = dataClassTickets(uuid, titulo, descripcion, autor, email, fechaCreacion, estado, fechaFinalizacion)
                //tickets.add(TodosLosValores)



            }

            return tickets
        }


        CoroutineScope(Dispatchers.IO).launch {

            //val ticketsDB = obtenerDatosTickets()
           // withContext(Dispatchers.Main){
             //   val adapter = Adaptador(//)
                //rcvTickets.adapter = //

          //  }

        }

    }
}