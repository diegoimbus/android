package unicauca.movil.peliculas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.ma) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val strenghtFit = LatLng(2.444026, -76.598368)
        val fitness = LatLng(2.457971, -76.598222)
        val corpus = LatLng(2.454350, -76.603064)
        val tnt = LatLng(2.482668, -76.577378)
        val complejo = LatLng(2.489776, -76.592997)

        mMap.addMarker(MarkerOptions().position(strenghtFit).title("STRENGHT FIT - calle 1BN #2AE-06"))
        mMap.addMarker(MarkerOptions().position(fitness).title("Fitness Gym - Cl. 18N #12-2"))
        mMap.addMarker(MarkerOptions().position(corpus).title("Corpus Gym - Cra. 11 Nte #33 11"))
        mMap.addMarker(MarkerOptions().position(tnt).title("TNT Athlete's Performance - Tv 9A Norte #61100"))
        mMap.addMarker(MarkerOptions().position(complejo).title("Complejo Deportivo de Popayán"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(strenghtFit))
    }
}
