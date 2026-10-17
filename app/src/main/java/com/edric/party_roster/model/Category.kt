package com.edric.party_roster.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.edric.party_roster.R

enum class Category(
    @DrawableRes val imgRes: Int,
    val bgColor: Color,
    val textColor: Color
) {
    BERSERKER(
        imgRes = R.drawable.berserker,
        bgColor = Color(0x33FF5252),
        textColor = Color(0xFFFF5252),
    ),
    ARCHMAGE(
        imgRes = R.drawable.archmage,
        bgColor = Color(0x3300E5FF),
        textColor = Color(0xFF00E5FF),
    ),
    PALADIN(
        imgRes = R.drawable.paladin,
        bgColor = Color(0x33FF9800),
        textColor = Color(0xFFFF9800),
    ),
    ROGUE(
        imgRes = R.drawable.rogue,
        bgColor = Color(0x33E040FB),
        textColor = Color(0xFFE040FB),
    ),
    CLERIC(
        imgRes = R.drawable.cleric,
        bgColor = Color(0x3300E676),
        textColor = Color(0xFF00E676),
    )
}