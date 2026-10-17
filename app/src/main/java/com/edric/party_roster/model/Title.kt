package com.edric.party_roster.model

import androidx.compose.ui.graphics.Color

enum class Title(
    val text: String,
    val bgColor: Color,
    val textColor: Color
) {
    HIGH_TEMPLAR(
        text = "High Templar",
        bgColor = Color(0x33FFC107),
        textColor = Color(0xFFFFC107)
    ),
    DIVINE_ORACLE(
        text = "Divine Oracle",
        bgColor = Color(0x3300E676),
        textColor = Color(0xFF00E676)
    ),
    SHADOWBLADE(
        text = "Shadowblade",
        bgColor = Color(0x33E040FB),
        textColor = Color(0xFFE040FB)
    ),
    ARCHMAGE(
        text = "Archmage",
        bgColor = Color(0x3300E5FF),
        textColor = Color(0xFF00E5FF)
    ),
    LUMINARY_PRIEST(
        text = "Luminary Priest",
        bgColor = Color(0x3369F0AE),
        textColor = Color(0xFF69F0AE)
    ),
    STORMCALLER(
        text = "Stormcaller",
        bgColor = Color(0x33448AFF),
        textColor = Color(0xFF448AFF)
    ),
    BERSERKER(
        text = "Berserker",
        bgColor = Color(0x33FF5252),
        textColor = Color(0xFFFF5252)
    ),
    PALADIN(
        text = "Paladin",
        bgColor = Color(0x33FF9800),
        textColor = Color(0xFFFF9800)
    ),
    DREAD_KNIGHT(
        text = "Dread Knight",
        bgColor = Color(0x33FF5722),
        textColor = Color(0xFFFF5722)
    )
}