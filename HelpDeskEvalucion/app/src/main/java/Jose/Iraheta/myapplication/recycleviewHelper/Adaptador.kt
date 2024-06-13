package Jose.Iraheta.myapplication.recycleviewHelper


import Jose.Iraheta.myapplication.Mostrar_Detalles_Tickets
import Jose.Iraheta.myapplication.R
import Modelo.ClaseConexion
import Modelo.dataClassTickets
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Adaptador(var Datos: List<dataClassTickets>) : RecyclerView.Adapter<ViewHolder>() {

    fun actualizarTickets(nuevaLista:List<dataClassTickets>){
        Datos = nuevaLista
        notifyDataSetChanged()
    }

    fun ActualizarTicketsLuegoDeActualizarDatos(uuid:String,nuevoTitulo:String){
        val index = Datos.indexOfFirst { it.uuid == uuid }
        Datos[index].titulo = nuevoTitulo
        notifyItemChanged(index)
    }


    fun EliminarTickets(Titulo : String, posicion:Int) {
        val listaTickets = Datos.toMutableList()
        listaTickets.removeAt(posicion)

        GlobalScope.launch(Dispatchers.IO){
            val objConexion = ClaseConexion().cadenaConexion()
            val elimTickets = objConexion?.prepareStatement("delete tbTicket where titulo_Ticket = ? ")!!
            elimTickets.setString(1,Titulo)
            elimTickets.executeUpdate()

            val commit = objConexion.prepareStatement("commit")
            commit.executeUpdate()
        }

        Datos = listaTickets.toList()
        notifyItemRemoved(posicion)
        notifyDataSetChanged()
    }


    fun actualizarTickets(Titulo: String,uuid: String){
        GlobalScope.launch(Dispatchers.IO){
            val objConexion = ClaseConexion().cadenaConexion()
            val updateTicket = objConexion?.prepareStatement("update tbTicket set titulo_Ticket = ? where uuid_Tiket = ?")!!
            updateTicket.setString(1,Titulo)
            updateTicket.setString(2, uuid)
            updateTicket.executeUpdate()

            val commit = objConexion?.prepareStatement("commit")!!
            commit.executeUpdate()

            withContext(Dispatchers.Main){
                ActualizarTicketsLuegoDeActualizarDatos(uuid,Titulo)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_card, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount() = Datos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket = Datos[position]
        holder.txtView.text = ticket.titulo

        val item = Datos[position]


        holder.imgEliminar.setOnClickListener {
            val context = holder.itemView.context

            val builder = AlertDialog.Builder(context)

            builder.setTitle("Estas seguro de esto?")

            builder.setMessage("Desea eleminar el ticket")

            builder.setNegativeButton("no") {dialog,wich ->


            }

            builder.setPositiveButton("Si") {dialog,wich ->
                EliminarTickets(item.titulo,position)
            }

            val alertDialog = builder.create()

            alertDialog.show()
        }


        holder.imgEditar.setOnClickListener {
            val context = holder.itemView.context
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Editar")

            val nuevoTitulo = EditText(context)
            nuevoTitulo.setHint(item.titulo)
            builder.setView(nuevoTitulo)

           builder.setPositiveButton("Aceptar") {dialog,wich ->

               actualizarTickets(nuevoTitulo.text.toString(), item.uuid)
           }

            builder.setNegativeButton("Cancelar") { dialog,wich ->
             actualizarTickets(nuevoTitulo.text.toString(), item.uuid)
            }
            val dialog = builder.create()
            dialog.show()


            }

        holder.txtView.setOnClickListener {
            val context = holder.itemView.context

            val pantallaDetalles = Intent(context, Mostrar_Detalles_Tickets::class.java)
            pantallaDetalles.putExtra("uuid", item.uuid)
            pantallaDetalles.putExtra("titulo", item.titulo)
            pantallaDetalles.putExtra("Descripcion",item.descripcion)
            pantallaDetalles.putExtra("Autor",item.autor)
            pantallaDetalles.putExtra("email", item.email)
            pantallaDetalles.putExtra("fechaCreacion", item.fechaCreacion)
            pantallaDetalles.putExtra("estado", item.estado)
            pantallaDetalles.putExtra("fechaFinalizacion", item.fechaFinalizacion)

            context.startActivity(pantallaDetalles)

            }
        }
    }


