package es.cunchidos.counter.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import es.cunchidos.counter.ui.Utils

@Composable
fun ResetButton(

    onClick: ()->Unit
){
    ActionButton(
        text = "POÑER A 0",
        heightButton = Utils.resetButtonHeight,
        icon = Icons.Filled.Refresh,
        containerColor = Color.Black,
        contentColor = Color.White,
        fontSizeText = 30
    ) {
        onClick()
    }
}