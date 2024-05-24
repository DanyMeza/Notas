package meza.jonathan.exam

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareaViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
    val tvDescripcion = itemView.findViewById<TextView>(R.id.tvDescripcion)
}