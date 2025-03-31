package com.example.comeat

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

object Modele {

    private val specialites: MutableList<SpecialiteCulinaire> = mutableListOf(
        SpecialiteCulinaire( 1 , "Libanais" ) ,
        SpecialiteCulinaire( 2 , "Marocain" ) ,
        SpecialiteCulinaire( 3 , "Grec" ) ,
        SpecialiteCulinaire( 4 , "Espagnol" ) ,
        SpecialiteCulinaire( 5 , "Italien" ) ,
        SpecialiteCulinaire( 6 , "Sénégalais" ) ,
        SpecialiteCulinaire( 7 , "Inuit" ) ,
    )

    private val utilisateurs: MutableList<Utilisateur> = mutableListOf(
        Utilisateur( 1 , "LOTHBROK" , "Ragnar" , "ragnar.lothbrok@gmail.com" , "Odin@Thor" ) ,
        Utilisateur( 2 , "LOTHBROK" , "Lagertha" , "lagertha.lothbrock@gmail.com" , "Loki&Freyja" ) ,
        Utilisateur( 3 , "GRIMES" , "Rick" , "rick.grimes@gmail.com" , "azerty" ) ,
        Utilisateur( 4 , "DIXON" , "Daryl" , "daryl.dixon@gmail.com" , "azerty" ) ,
        Utilisateur( 5 , "DIXON" , "Michonne" , "michonne.dixon@gmail.com" , "azerty" ) ,
        Utilisateur( 6 , "RHEE" , "Glenn" , "glenn.rhee@gmail.com" , "azerty" ) ,
        Utilisateur( 7 , "GREENE" , "Maggie" , "maggie.greene@gmail.com" , "azerty" ) ,
        Utilisateur( 8 , "GREENE" , "Carl" , "carl.greene@gmail.com" , "azerty" ) ,
        Utilisateur( 9 , "SMITH" , "Andrea" , "andrea.smith@gmail.com" , "azerty" ) ,
        Utilisateur( 10 , "SMITH" , "Negan" , "hegan.smith@gmail.com" , "azerty" ) ,
        Utilisateur( 11 , "PORTER" , "Eugène" , "eugene.porter@gmail.com" , "azerty" ) ,
        Utilisateur( 12 , "PELETIER" , "Carole" , "carole.peletier@gmail.com" , "azerty" ) ,
        Utilisateur( 13 , "GREENE" , "Beth" , "beth.greene@gmail.com" , "azerty" )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private val repas: MutableList<Repas> = mutableListOf(
        Repas( 1 , LocalDate.of( 2025 , 3 , 17 ) , 4 , specialites.get( 3 ) , utilisateurs.get( 1 )  ) ,
        Repas( 2 , LocalDate.of( 2025 , 3 , 18 ) , 2 , specialites.get( 0 ) , utilisateurs.get( 0 )  ) ,
        Repas( 3 , LocalDate.of( 2025 , 3 , 19 ) , 2 , specialites.get( 3 ) , utilisateurs.get( 3 )  ) ,
        Repas( 4 , LocalDate.of( 2025 , 3 , 20 ) , 13 , specialites.get( 2 ) , utilisateurs.get( 2 )  ) ,
        Repas( 5 , LocalDate.of( 2025 , 3 , 21 ) , 3 , specialites.get( 1 ) , utilisateurs.get( 1 )  ) ,
        Repas( 6 , LocalDate.of( 2025 , 3 , 21 ) , 4 , specialites.get( 4 ) , utilisateurs.get( 4 )  ) ,
        Repas( 7 , LocalDate.of( 2025 , 3 , 21 ) , 4 , specialites.get( 5 ) , utilisateurs.get( 1 )  )
    )



    fun findUtilisateur( email: String , mdp: String ): Utilisateur? {
        for( utilisateur in utilisateurs ){
            if( utilisateur.email == email && utilisateur.mdp == mdp ){
                return utilisateur
            }
        }

        return null
        // return utilisateurs.find { it.email == email && it.mdp == mdp }
    }

    fun getUtilisateur( id: Int ): Utilisateur? {
        for( utilisateur in utilisateurs ){
            if( utilisateur.id == id ){
                return utilisateur
            }
        }
        return null
    }

    fun getUtilisateurs(): List<Utilisateur> {
        return utilisateurs
    }

    fun getSpecialites(): List<SpecialiteCulinaire> {
        return specialites
    }

    fun inscrireRepas( repas: Repas , utilisateur: Utilisateur ) {
        // à implémenter
    }

    fun annulerInscription( repas: Repas , utilisateur: Utilisateur ): Boolean {
        // à implémenter
        return true ;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRepas(): List<Repas> {
        return repas
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRepasByDateSpecialite(specialite: String, date: LocalDate): List<Repas> {

        val repasSelect: MutableList<Repas> = mutableListOf()

        for( unRepas in repas ){
            if( unRepas.date == date && unRepas.specialite.libelle == specialite ){
                repasSelect.add( unRepas )
            }
        }

        return repasSelect
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getRepasById(id : Int ): Repas? {
        for( unRepas in repas ){
            if( unRepas.id == id ){
                return unRepas
            }
        }
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNbPlacesLibres(idRepas: Int ): Int? {
        val repas = getRepasById( idRepas )
        if( repas != null ){
            return repas.nbCouverts - repas.convives.size
        }
        return null
    }


}