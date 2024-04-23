package com.mrshashankbisht.learnworkmanager.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Shashank on 22-04-2024
 */


@Composable
fun ClickableTextButton(modifier: Modifier = Modifier, text: String = "Ok", onClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier
            .background(Color.LightGray)
            .clickable {
                onClick()
            }
            .padding(10f.dp, 5f.dp),
        fontSize = 16f.sp,
        color = Color.DarkGray,

    )
}