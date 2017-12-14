package unicauca.movil.peliculas


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import unicauca.movil.peliculas.adapters.PeliculaAdapter
import unicauca.movil.peliculas.databinding.ActivityMainBinding
import unicauca.movil.peliculas.db.AppDB
import unicauca.movil.peliculas.db.PeliculaDao
import unicauca.movil.peliculas.fragments.MainFragment


class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener {

    val toggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawer,
                R.string.open_menu, R.string.close_menu)
    }

    private lateinit var binding: ActivityMainBinding
    private val adapter: PeliculaAdapter =  PeliculaAdapter {  }
    val dao: PeliculaDao = AppDB.db.peliculaDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)

        nav.setNavigationItemSelectedListener { setContent(it) }

        putFragment(R.id.container, MainFragment.instance())


    }

    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit()
    }

    fun setContent(item: MenuItem?): Boolean {
        drawer.closeDrawers()
        when(item?.itemId){
            R.id.nav_home -> putFragment(R.id.container, MainFragment.instance())
            R.id.nav_logut -> startActivity<LoginActivity>()
            R.id.nav_action -> startActivity<MapsActivity>()
        }
        return true
    }
    fun goToAdd(){
        startActivity<AddActivity>()
    }

    //region Toggle
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerStateChanged(newState: Int) {
        toggle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        toggle.onDrawerSlide(drawerView, slideOffset)
    }

    override fun onDrawerClosed(drawerView: View) {
        toggle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View) {
        toggle.onDrawerOpened(drawerView)
    }
    //endregion

}
