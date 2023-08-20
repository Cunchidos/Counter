    @file:OptIn(ExperimentalMaterial3Api::class)

    package es.cunchidos.counter

    import android.annotation.SuppressLint
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.layout.*
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.PlayArrow
    import androidx.compose.material.icons.filled.Refresh
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalConfiguration
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import es.cunchidos.counter.ui.component.ActionButton
    import es.cunchidos.counter.ui.theme.CounterTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                CounterTheme {
                    CounterScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun CounterScreen() {
        var count by remember { mutableStateOf(0) }
        var hundred by remember { mutableStateOf(false) }
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val resetButtonHeight=80.dp;
        
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

        Scaffold(

            content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                ) {

                    ActionButton(
                        text = "POÑER A 0",
                        heightButton = resetButtonHeight,
                        icon = Icons.Filled.Refresh,
                        containerColor = Color.Black ,
                        contentColor = Color.White,
                        fontSizeText = 30
                    ) {
                        count = 0
                    }
                    ActionButton(
                        text = if ( isOtherElement(count, hundred)) "$count" else "",
                        heightButton = screenHeight - resetButtonHeight,
                        icon = if (isOtherElement(count, hundred)) null else Icons.Filled.PlayArrow,
                        containerColor = if (isOtherElement(count, hundred))colorArray[count % 10] else Color.DarkGray ,//el colo cambia con el contador
                        contentColor = Color.White,
                        fontSizeText = 250
                    ) {
                        if(count<99){
                            count ++
                            hundred=false
                        } else{
                            count=0
                            hundred = true
                        }
                    }
                }
            }
        )
    }

    private fun isOtherElement(count:Number, hundred:Boolean): Boolean{
        return count!=0 || hundred
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCounterScreen() {
        CounterTheme {
            CounterScreen()
        }
    }
