package com.google.mediapipe.examples.llminference

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
        // Hapa ndipo tunaongeza "Maboresho niliyoweka"
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0x1A808080)), // Rangi ya kijivu iliyofifia
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = "Maboresho niliyoweka (Improvements):",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 6.dp)
                )

                // List ya maboresho kama Bullet Points
                val improvements = listOf(
                    "* Google Gemma 1B, 2B (Optimized CPU/GPU)",
                    "* Meta Llama 3.2 1B, 3B (Instruct)",
                    "* Microsoft Phi 4 Mini Instruct",
                    "* Alibaba Qwen 2.0, 2.1, 2.5 (0.5B, 1.5B, 3B)",
                    "* Smollm 135M, TinyLlama 1.1B",
                    "* DeepSeek R1 Distill Qwen 1.5B",
                    "* Fixed chat labels & Thinking animation"
                )

                improvements.forEach { improvement ->
                    Row(
                        modifier = Modifier.padding(vertical = 1.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "  $improvement",
                            fontSize = 7.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
        }

        // List ya Model (zilizopo)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
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

        // Maandishi ya kisheria na umiliki chini kabisa
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Urya AI can make mistakes. Please double check.",
                fontSize = 7.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Developed by staphordcodes | © 2026 Staphordcodes. Based on Google MediaPipe (Apache License 2.0)",
                fontSize = 7.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
