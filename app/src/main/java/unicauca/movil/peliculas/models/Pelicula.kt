package unicauca.movil.peliculas.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class Pelicula(var nombre: String,
                    var duracion: String,
                    var estreno: String,
                    var imagen: String,
                    var sinopsis: String) {
                    @PrimaryKey(autoGenerate = true)
                    var id: Long? = null

    @Ignore
    constructor():this("","","","","")
}
