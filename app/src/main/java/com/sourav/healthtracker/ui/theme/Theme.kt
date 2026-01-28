package com.sourav.healthtracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
    tertiary = Color(0xFF018786),
    primaryContainer = Color(0xFFBB86FC),
    secondaryContainer = Color(0xFFE0F7FA),
    onPrimaryContainer = Color(0xFF000000),
    onSecondaryContainer = Color(0xFF000000)
)

@Composable
fun HealthTrackerAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}