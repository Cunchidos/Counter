package es.cunchidos.counter.ui.component

import android.content.Intent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import es.cunchidos.counter.CounterActivity

@Composable
fun MenuButton(
    text:String,
    onClick: ()->Unit


){
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow
        ),
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .height(60.dp) // Altura específica para el botón
    ) {
        Text(text)
    }
    Spacer(modifier = Modifier.height(16.dp)) // Espacio entre botones
}