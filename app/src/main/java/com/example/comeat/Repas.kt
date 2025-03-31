package com.example.comeat

import java.time.LocalDate

data class Repas(
    val id: Int,
    val date: LocalDate,
    val nbCouverts: Int,
    val specialite: SpecialiteCulinaire,
    val hote: Utilisateur,
    val convives: MutableList<Utilisateur> = mutableListOf()
)