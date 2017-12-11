package unicauca.movil.peliculas

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.startActivity
import unicauca.movil.peliculas.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_login)

        binding.handler = this


    }

    fun login(){
        startActivity<MainActivity>()
        finish()
    }

    fun signin() {


    }
}
