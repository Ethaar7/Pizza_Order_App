package com.example.pizzaorderapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.composable.ChipSize
import com.example.pizzaorderapp.composable.IconBack
import com.example.pizzaorderapp.composable.IconFavorite
import com.example.pizzaorderapp.composable.Ingredients
import com.example.pizzaorderapp.composable.Pizza
import com.example.pizzaorderapp.ui.theme.Black38
import com.example.pizzaorderapp.ui.theme.Primary
import com.example.pizzaorderapp.ui.theme.Sora

@Composable
fun PizzaOrderScreen(
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    PizzaOrderContent(
        onClick = viewModel::onClick,
        state = state,
        onClickIsSelectedB = viewModel::onClickIsSelectedB,
        onClickIsSelectedA = viewModel::onClickIsSelectedA,
        onClickIsSelectedD = viewModel::onClickIsSelectedD,
        onClickIsSelectedS = viewModel::onClickIsSelectedS,
        onClickIsSelectedN = viewModel::onClickIsSelectedN
    )
}


@Composable
fun PizzaOrderContent(
    state: PizzaUiState,
    onClick: (PizzaSize) -> Unit,
    onClickIsSelectedB: () -> Unit,
    onClickIsSelectedA: () -> Unit,
    onClickIsSelectedD: () -> Unit,
    onClickIsSelectedN: () -> Unit,
    onClickIsSelectedS: () -> Unit,
) {
    Column {

        Box(
            modifier = Modifier
                .padding(bottom = 40.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconBack(modifier = Modifier.padding(top = 16.dp, start = 16.dp))
                    Text(
                        text = "Pizza",
                        modifier = Modifier.padding(top = 16.dp),
                        fontFamily = Sora,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    IconFavorite(modifier = Modifier.padding(top = 16.dp, end = 16.dp))
                }

                Box(modifier = Modifier.padding(top = 16.dp), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.plate_1),
                        contentDescription = null,
                        modifier = Modifier.size(250.dp),
                    )
                    Pizza(
                        images = listOf(
                            R.drawable.bread_1,
                            R.drawable.bread_2,
                            R.drawable.bread_3,
                            R.drawable.bread_4,
                            R.drawable.bread_5
                        ),
                        pizzaSize = state
                    )

                }
            }
        }
        Text(
            text = "$17",
            fontSize = 22.sp,
            fontFamily = Sora,
            fontWeight = FontWeight.Bold,
            color = Primary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        ChipSize(onClick = onClick)


        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            fontSize = 12.sp,
            fontFamily = Sora,
            fontWeight = FontWeight.Normal,
            color = Black38,
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp)
        )
        LazyRow() {
            item {
                Ingredients(
                    state = state,
                    onClickIsSelectedB = onClickIsSelectedB,
                    onClickIsSelectedA = onClickIsSelectedA,
                    onClickIsSelectedD = onClickIsSelectedD,
                    onClickIsSelectedN = onClickIsSelectedN,
                    onClickIsSelectedS = onClickIsSelectedS
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(24.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(Primary),
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cart_large_2),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    text = "Add to cart",
                    fontFamily = Sora,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }

}


//@Preview(showSystemUi = true)
//@Composable
//fun Preview() {
//    PizzaOrderContent(state = PizzaUiState(), onClick = {})
//}
