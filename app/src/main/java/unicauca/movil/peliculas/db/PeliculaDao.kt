package unicauca.movil.peliculas.db

import android.arch.persistence.room.*
import unicauca.movil.peliculas.models.Pelicula


@Dao
        interface PeliculaDao {

    @Insert
    fun insert (pelicula:Pelicula)

    @Update
    fun  update (pelicula:Pelicula)

    @Delete
    fun delete (pelicula: Pelicula)

    @Query("SELECT * FROM pelicula WHERE id = :id")
    fun peliculaById(id:Long):Pelicula
}