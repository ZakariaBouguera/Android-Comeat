package com.example.comeat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val saisieEmail : TextView = findViewById((R.id.email))
        val saisieMdp : TextView = findViewById(R.id.mdp)

        val buttonConnecter = findViewById<Button>(R.id.connecter)
        buttonConnecter.setOnClickListener {
            val email : String = saisieEmail.text.toString()
            val mdp : String = saisieMdp.text.toString()
            Log.d("ACT_CONN", "Connexion : $email/$mdp")
            val r : Utilisateur? = Modele.findUtilisateur(email, mdp)
            if( r != null ){
                Session.ouvrir(utilisateur =r)
                startActivity(Intent(this, MenuRepasActivity::class.java))
            }
            else {
                println( "Pas trouvé" )
            }
        }

        val buttonAnnuler : Button = findViewById(R.id.annuler)
        buttonAnnuler.setOnClickListener{
            saisieEmail.text = ""
            saisieMdp.text = ""

            Log.d("ACT_CONN", "Annulation")
        }

    }
}