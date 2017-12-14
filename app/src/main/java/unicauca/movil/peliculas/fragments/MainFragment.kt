package unicauca.movil.peliculas.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.support.v4.startActivity
import unicauca.movil.peliculas.DetailActivity

import unicauca.movil.peliculas.R
import unicauca.movil.peliculas.adapters.PeliculaAdapter
import unicauca.movil.peliculas.db.AppDB
import unicauca.movil.peliculas.db.PeliculaDao
import unicauca.movil.peliculas.util.Data
import kotlin.concurrent.thread


class MainFragment : Fragment() {

    val adapter:PeliculaAdapter = PeliculaAdapter(this::movieSelected)

    val dao:PeliculaDao = AppDB.db.peliculaDao()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)

        async(UI){
            adapter.data = bg { dao.all() }.await()
        }




    }

    fun movieSelected(pos:Int){
        startActivity<DetailActivity>("pos" to pos)
    }

    companion object {
        fun instance():MainFragment = MainFragment()
    }

}
