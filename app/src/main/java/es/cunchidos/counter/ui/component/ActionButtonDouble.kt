package es.cunchidos.counter.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActionDoubleButton(
    text: String,
    heightButton: Dp,
    icon: ImageVector?,
    containerColor: Color,
    contentColor: Color,
    fontSizeText: Int,
    insulto: String,
    showInsulto: Boolean,
    setShowInsulto: (Boolean) -> Unit,
    containerColorInsulto: Color,
    contentColorInsulto: Color,
    fontSizeTextInsulto: Int,
    delay: Long,
    onDoubleClick: () -> Unit,
    onOnlyClick: () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(heightButton)
            .background(containerColor , shape=RectangleShape)
            .fillMaxSize()
            .combinedClickable(
                onClick = {
                    onOnlyClick()
                },
                onDoubleClick = {
                    onDoubleClick()
                },
                onLongClick = {
                    onDoubleClick()
                }
            ), // Elimina los márgenes,
    ) {
        if (icon != null) {
            Icon(
                icon,
                text,
                modifier = Modifier.size(fontSizeText.dp),

                )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
        if(text != "") {
            Text(
                text = text,
                color = contentColor,
                fontSize = fontSizeText.sp
            )

        }
        if (showInsulto) {
            // Tu mensaje en el centro
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
                    .background(containerColorInsulto)
            ) {

                Text(
                    text = insulto,
                    color = contentColorInsulto,
                    fontSize = fontSizeTextInsulto.sp
                )
            }
            LaunchedEffect(true) {
                delay(delay) // Duración del mensaje en pantalla
                setShowInsulto(false)
            }
        }
    }

}