package com.example.pizzaorderapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.CardColor
import com.example.pizzaorderapp.ui.theme.Primary

@Composable
fun IconBack(modifier: Modifier = Modifier) {
    IconButton(
        modifier = modifier
            .size(32.dp),
        onClick = {}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left2),
            contentDescription = null, tint = Primary
        )
    }
}