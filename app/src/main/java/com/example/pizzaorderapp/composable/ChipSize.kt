package com.example.pizzaorderapp.composable

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.screen.PizzaSize
import kotlin.math.roundToInt


@Composable
fun ChipSize(modifier: Modifier = Modifier, onClick: (PizzaSize) -> Unit) {
    var horizontalBias by remember { mutableStateOf(-1f) }
    val alignment by animateHorizontalAlignmentAsState(horizontalBias)
    Box() {
        var horizontalBias by remember { mutableStateOf(-1f) }
        val alignment by animateHorizontalAlignmentAsState(horizontalBias)

        Row(
            modifier = modifier
                .padding(top = 24.dp, start = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,

            ) {
            Text(
                text = "S",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onClick(PizzaSize.S) })
            Text(
                text = "M",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onClick(PizzaSize.M) })
            Text(
                text = "L",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onClick(PizzaSize.L) })
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun animateHorizontalAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment.Horizontal> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment.Horizontal(bias) }
}

@Preview(showSystemUi = true)
@Composable
fun Preview3() {
    ChipSize(onClick = {})
}

@Composable
fun Alignment(alignment: Alignment){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 8.dp, start = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .shadow(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .size(56.dp)
                .background(Color.White)
        )
    }
}



@Preview
@Composable
fun AnimatedChildAlignmentTest() {
    var alignment by remember {
        mutableStateOf(Alignment.Center)
    }

    var alignmentValue by remember {
        mutableStateOf(0f)
    }

    alignment = when (alignmentValue.roundToInt()) {
        0 -> Alignment.TopStart
        1 -> Alignment.TopCenter
        else -> Alignment.TopEnd
    }

    val text = when (alignmentValue.roundToInt()) {
        0 -> "S"
        1 -> "M"
        else -> "L"
    }}
