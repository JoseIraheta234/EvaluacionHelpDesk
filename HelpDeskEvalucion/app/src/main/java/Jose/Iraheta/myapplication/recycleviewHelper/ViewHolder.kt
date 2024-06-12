package Jose.Iraheta.myapplication.recycleviewHelper

import Jose.Iraheta.myapplication.R
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtView: TextureView = view.findViewById(R.id.txtTicketCard)
    val imgEditar : ImageView = view.findViewById(R.id.imgEditar)
    val imgEliminar : ImageView = view.findViewById(R.id.imgBorrar)
}