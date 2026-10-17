package com.edric.party_roster.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.edric.party_roster.ui.widgets.HeroCardView
import com.edric.party_roster.ui.widgets.TopPartView
import com.edric.party_roster.viewmodel.HomeViewModel

@Composable
fun homeView(viewModel: HomeViewModel = viewModel()) {
    val heroes by viewModel.heroes.collectAsState()

    // Sesuai dengan referensi arsitektur: Box > Column > Box > Box(Elements)[cite: 1]
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF10121A)) // Latar belakang tema gelap[cite: 2]
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            // Box Top Part
            Box(
                modifier = Modifier.weight(3.5f)
            ) {
                TopPartView()
            }

            // Box Scrollable List
            Box(
                modifier = Modifier.weight(6.5f)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(heroes) { hero ->
                        HeroCardView(hero = hero)
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomePreview() {
    homeView()
}