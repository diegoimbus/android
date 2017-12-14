package unicauca.movil.peliculas

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import unicauca.movil.peliculas.databinding.ActivityAddBinding
import unicauca.movil.peliculas.db.AppDB
import unicauca.movil.peliculas.db.PeliculaDao
import unicauca.movil.peliculas.models.Pelicula


class AddActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddBinding
    val dao: PeliculaDao = AppDB.db.peliculaDao()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        binding.handler = this
    }

    fun save(){
        val nombre = nombre.text
        val duracion = duracion.text
        val estreno = estreno.text
        val imagen = imagen.text
        val sinopsis = sinopsis.text

        val pelicula = Pelicula(nombre.toString(), duracion.toString(), estreno.toString(), imagen.toString(), sinopsis.toString()
        )

        dao.insert(pelicula)

        finish()
    }
}
