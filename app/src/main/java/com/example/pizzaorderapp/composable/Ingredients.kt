package com.example.pizzaorderapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.screen.PizzaUiState
import com.example.pizzaorderapp.ui.theme.CardColor

@Composable
fun Ingredients(
    modifier: Modifier = Modifier,
    state: PizzaUiState,
    onClickIsSelectedB: () -> Unit,
    onClickIsSelectedA: () -> Unit,
    onClickIsSelectedD: () -> Unit,
    onClickIsSelectedN: () -> Unit,
    onClickIsSelectedS: () -> Unit,

    ) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.broccoli_9),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .size(68.dp)
                .background(
                    shape = CircleShape,
                    color = if (state.isSelectedB == false) Color.Transparent else CardColor
                )
                .padding(8.dp)
                .clickable { onClickIsSelectedB() }
        )

        Image(
            painter = painterResource(id = R.drawable.basil_3),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .size(68.dp)
                .background(
                    shape = CircleShape,
                    color = if (state.isSelectedA == false) Color.Transparent else CardColor
                )
                .padding(8.dp)
                .clickable { onClickIsSelectedA() }
        )

        Image(
            painter = painterResource(id = R.drawable.sausage_1),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .size(68.dp)
                .background(
                    shape = CircleShape,
                    color = if (state.isSelectedS == false) Color.Transparent else CardColor
                )
                .padding(8.dp)
                .clickable { onClickIsSelectedS() }

        )

        Image(
            painter = painterResource(id = R.drawable.mushroom_10),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .size(68.dp)
                .background(
                    shape = CircleShape,
                    color = if (state.isSelectedD == false) Color.Transparent else CardColor
                )
                .padding(8.dp)
                .clickable { onClickIsSelectedD() }

        )

        Image(
            painter = painterResource(id = R.drawable.onion_2),
            contentDescription = null,
            modifier = modifier
                .padding(16.dp)
                .size(68.dp)
                .padding(end = 8.dp)
                .background(
                    shape = CircleShape,
                    color = if (state.isSelectedN == false) Color.Transparent else CardColor
                )
                .padding(8.dp)
                .clickable { onClickIsSelectedN() }
        )

    }

}


