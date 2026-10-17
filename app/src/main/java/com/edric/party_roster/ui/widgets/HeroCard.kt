package com.edric.party_roster.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edric.party_roster.model.Hero

@Composable
fun HeroCardView(hero: Hero) {
    var expanded by remember { mutableStateOf(false) }

    val cardBorder = if (hero.isInSquad) {
        BorderStroke(1.dp, Color(0xFFFFC107))
    } else {
        BorderStroke(1.dp, Color(0xFF33384B))
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        shape = RoundedCornerShape(16.dp),
        border = cardBorder,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2232))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(containerColor = hero.rarity.bgColor)
                    ) {
                        Text(
                            text = hero.rarity.name,
                            color = hero.rarity.textColor,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(containerColor = hero.title.bgColor)
                    ) {
                        Text(
                            text = hero.title.text,
                            color = hero.title.textColor,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "⚔ ${hero.CP} CP",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                    if (hero.isInSquad) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            border = BorderStroke(1.dp, Color(0xFFFFC107)),
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                        ) {
                            Text(
                                text = "IN SQUAD",
                                color = Color(0xFFFFC107),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color.White, RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = hero.category.imgRes),
                        contentDescription = hero.name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                    Card(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.8f))
                    ) {
                        Text(
                            text = "Lvl ${hero.level}",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))


                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = hero.name,
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand",
                            tint = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    StatBarRow(title = "HP", value = hero.HP, maxValue = hero.maxHP, barColor = Color(0xFFFF5252))
                    Spacer(modifier = Modifier.height(6.dp))

                    StatBarRow(title = "MP", value = hero.MP, maxValue = hero.maxMP, barColor = Color(0xFF2196F3))
                }
            }


            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Divider(color = Color(0xFF2C2F40), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatBox(title = "ATK", value = hero.ATK.toString(), modifier = Modifier.weight(1f))
                        StatBox(title = "DEF", value = hero.DEF.toString(), modifier = Modifier.weight(1f))
                        StatBox(title = "CRIT", value = "${hero.CRIT}%", modifier = Modifier.weight(1f))
                        StatBox(title = "SPD", value = hero.SPD.toString(), modifier = Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(12.dp))


                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF232635)),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, contentDescription = "Skill", tint = Color(0xFFFFC107), modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(text = hero.skillName, color = Color(0xFFFFC107), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = hero.skillDescription, color = Color.LightGray, fontSize = 12.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { /* Dummy */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E3A2F)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Heal (+250 HP)", color = Color(0xFF00E676))
                        }
                        Button(
                            onClick = { /* Dummy */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0x33FFC107)),
                            border = BorderStroke(1.dp, Color(0xFFFFC107)),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = if(hero.isInSquad) "Remove" else "Add to Squad", color = Color(0xFFFFC107))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatBarRow(title: String, value: Int, maxValue: Int, barColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.width(24.dp))


        val fraction = (value.toFloat() / maxValue.toFloat()).coerceIn(0f, 1f)

        Box(
            modifier = Modifier
                .weight(1f)
                .height(6.dp)
                .background(Color(0xFF2C2F40), RoundedCornerShape(50))
                .clip(RoundedCornerShape(50))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
                    .background(barColor)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "$value / $maxValue", color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun StatBox(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF232635)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, color = Color.Gray, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text(text = value, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}