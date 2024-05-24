package meza.jonathan.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var etTitulo:EditText
    lateinit var etDescripcion:EditText
    lateinit var btnGuardar:Button
    lateinit var listaTareas:RecyclerView
    lateinit var adapter:TareasAdapter

    private val tareasViewModel:TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etNombre)
        etDescripcion = findViewById(R.id.etApellido)
        btnGuardar = findViewById(R.id.btnGuardar)
        listaTareas = findViewById(R.id.rvTareas)

        /*tareasViewModel.elementos.add(
            Tarea("Jonathan Daniel", "Meza Casas", false)
        )*/

        adapter = TareasAdapter(tareasViewModel.elementos)

        listaTareas.adapter = adapter
        listaTareas.layoutManager = GridLayoutManager(this, 1)

        btnGuardar.setOnClickListener {

            val titulo = etTitulo.text.toString()
            val descripcion = etDescripcion.text.toString()
            tareasViewModel.elementos.add(Tarea(titulo, descripcion,false))

            adapter.notifyDataSetChanged()
            Toast.makeText(this,"${tareasViewModel.elementos.size}",Toast.LENGTH_SHORT).show()
        }
    }
}