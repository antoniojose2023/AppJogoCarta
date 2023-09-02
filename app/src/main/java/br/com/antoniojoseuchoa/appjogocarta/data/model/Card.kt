package br.com.antoniojoseuchoa.appjogocarta.data.model

import java.io.Serializable

data class Card(
    val artist: String,
    val cardId: String,
    val cardSet: String,
    val collectible: Boolean,
    val cost: Int,
    val dbfId: Int,
    val flavor: String,
    val img: String,
    val imgGold: String,
    val locale: String,
    val name: String,
    val playerClass: String,
    val rarity: String,
    val spellSchool: String,
    val text: String,
    val type: String
): Serializable{}