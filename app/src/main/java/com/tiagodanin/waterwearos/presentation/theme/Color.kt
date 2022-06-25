package com.tiagodanin.waterwearos.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors

val Blue700 = Color(0xFF1976d2)
val Blue900 = Color(0xFF0d47a1)
val DeepPurple200 = Color(0xFFb39ddb)
val DeepPurple400 = Color(0xFF512da8)

internal val wearColorPalette: Colors = Colors(
    primary = Blue700,
    primaryVariant = Blue900,
    secondary = DeepPurple200,
    secondaryVariant = DeepPurple400,
    error = Color.Red,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onError = Color.Black
)