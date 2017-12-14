package unicauca.movil.peliculas.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import unicauca.movil.peliculas.models.Pelicula


@Database(entities = arrayOf(Pelicula::class), version = 1)
        abstract  class Database : RoomDatabase() {
            abstract fun peliculaDao():PeliculaDao
}