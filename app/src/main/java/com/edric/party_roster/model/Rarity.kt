package com.edric.party_roster.model

import androidx.compose.ui.graphics.Color

enum class Rarity(
    val bgColor: Color,
    val textColor: Color
) {
    MYTHIC(
        bgColor = Color(0x33E91E63),
        textColor = Color(0xFFE91E63)
    ),
    LEGENDARY(
        bgColor = Color(0x33FFC107),
        textColor = Color(0xFFFFC107)
    ),
    EPIC(
        bgColor = Color(0x339C27B0),
        textColor = Color(0xFF9C27B0)
    )
}