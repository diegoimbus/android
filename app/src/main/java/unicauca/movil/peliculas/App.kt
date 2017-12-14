package unicauca.movil.peliculas

import android.app.Application
import unicauca.movil.peliculas.db.AppDB


class App:Application(){
    override fun onCreate() {
        super.onCreate()
        AppDB.init(this)
    }
}
