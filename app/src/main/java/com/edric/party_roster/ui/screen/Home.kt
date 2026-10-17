package com.edric.party_roster.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.edric.party_roster.viewmodel.HomeViewModel

@Composable
fun homeView(viewModel: HomeViewModel = viewModel()) {

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun homePreview() {
    homeView()
}