package com.google.mediapipe.examples.llminference

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun SelectionRoute(
    onModelSelected: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // MAANDISHI YA JUU: Umiliki wako (Madogo ya kijivu)
        Text(
            text = "Developed by staphordcodes | © 2026 Staphordcodes. Based on Google MediaPipe (Apache License 2.0)",
            fontSize = 7.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
        )

        // LIST YA MODELS: Inaanza hapa chini ya saini yako
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.weight(1f)
        ) {
            items(Model.entries) { model ->
                Button(
                    onClick = {
                        InferenceModel.model = model
                        onModelSelected()
                    },
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(model.toString())
                }
            }
        }

        // MAANDISHI YA CHINI: Tahadhari (Madogo ya kijivu)
        Text(
            text = "Urya AI can make mistakes. Please double check.",
            fontSize = 7.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
    }
}
