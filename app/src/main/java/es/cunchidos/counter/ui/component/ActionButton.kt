package es.cunchidos.counter.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(
    text: String,
    heightButton: Dp,
    icon: ImageVector?,
    containerColor: Color,
    contentColor: Color,
    fontSizeText: Int,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = RectangleShape,
        modifier = Modifier
            .height(heightButton)
            .fillMaxWidth(), // Elimina los márgenes,
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
                fontSize = fontSizeText.sp // Cambia el tamaño de la fuente del texto
            )
        }
    }


}