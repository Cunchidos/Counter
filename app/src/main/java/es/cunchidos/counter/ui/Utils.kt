package es.cunchidos.counter.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Utils {


    val resetButtonHeight=80.dp;

    val insultoArray = listOf(
        "CACHOLÁN",
        "PAILÁN",
        "MILLASOIA",
        "PAILAROCO",
        "VERME",
        "FUROFOLLAS",
        "LANGRÁN",
        "BARALLOCAS",
        "BALDREU",
        "MOINANTE"
    )

    val colorArray = listOf(
        Color(0xFFE57373),
        Color(0xFFF06292),
        Color(0xFFBA68C8),
        Color(0xFF64B5F6),
        Color(0xFF4DD0E1),
        Color(0xFF81C784),
        Color(0xFFFFD54F),
        Color(0xFFFFB74D),
        Color(0xFFA1887F),
        Color(0xFF90A4AE)
    )
    val colorInsultoAlerta = listOf(
        Color(0xFFFF0000), // Rojo brillante
        Color(0xFFFF00FF), // Magenta brillante
        Color(0xFFFFFF00), // Amarillo brillante
        Color(0xFF00FF00), // Verde lima brillante
        Color(0xFFFF0000), // Rojo brillante (repetido)
        Color(0xFFFF00FF), // Magenta brillante (repetido)
        Color(0xFFFFFF00), // Amarillo brillante (repetido)
        Color(0xFF00FF00), // Verde lima brillante (repetido)
        Color(0xFFFF0000), // Rojo brillante (repetido)
        Color(0xFFFF00FF)  // Magenta brillante (repetido)
    )
}