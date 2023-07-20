package com.example.pizzaorderapp.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.screen.PizzaSize
import com.example.pizzaorderapp.screen.PizzaUiState


@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun Pizza(
    pizzaSize: PizzaUiState,
    images: List<Int>,
    modifier: Modifier = Modifier,
) {

    val pagerState = rememberPagerState(
        initialPage = 1,
    )

    val sizePizza =
        if (pizzaSize.size == PizzaSize.L) 238f else if (pizzaSize.size == PizzaSize.M) 215f else 200f
    val imageSize by animateFloatAsState(targetValue = sizePizza)
    HorizontalPager(
        state = pagerState,
        modifier = Modifier,
        contentPadding = PaddingValues(horizontal = 32.dp),
        pageSpacing = 16.dp,
        pageCount = images.size
    ) {
        Image(
            painter = painterResource(images[it]),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(imageSize.dp)
        )

        AnimatedVisibility(
           visible = false,
            enter = scaleIn(initialScale = 5F) + fadeIn(),
            exit = fadeOut()
        ) {
            Image(
                painter = painterResource(id = R.drawable.frame_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp)
            )
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    Pizza(
        images = listOf(
            R.drawable.bread_1,
            R.drawable.bread_2,
            R.drawable.bread_3,
            R.drawable.bread_4,
            R.drawable.bread_5
        ),
        pizzaSize = PizzaUiState()
    )
}