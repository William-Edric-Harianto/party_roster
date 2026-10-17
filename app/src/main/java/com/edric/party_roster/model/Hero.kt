package com.edric.party_roster.model

data class Hero(
    val name: String,
    val HP: Int,
    val MP: Int,
    val maxHP: Int,
    val maxMP: Int,
    val ATK: Int,
    val DEF: Int,
    val CRIT: Int,
    val SPD: Int,
    val CP: Int,
    val level: Int,
    val isInSquad: Boolean =  false,
    val skillName: String,
    val skillDescription: String,
    val rarity: Rarity,
    val title: Title,
    val category: Category
)
