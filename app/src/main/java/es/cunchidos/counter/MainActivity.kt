    @file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

    package es.cunchidos.counter

    import android.content.Intent
    import android.os.Bundle
    import android.os.PowerManager
    import android.view.WindowManager
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.ExperimentalFoundationApi
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import es.cunchidos.counter.ui.component.MenuButton
    import es.cunchidos.counter.ui.theme.CounterTheme

    class MainActivity : ComponentActivity() {

        private var wakeLock: PowerManager.WakeLock? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Mantener la pantalla encendida
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

            // Obtener el PowerManager
            val powerManager = getSystemService(POWER_SERVICE) as PowerManager

            // Crear un WakeLock de pantalla completa
            wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "MyApp:MyWakeLockTag").apply {
                acquire(10*60*1000L /*10 minutos*/)
            }
            setContent {
                CounterTheme {

                    // Utiliza un Box para centrar la columna
                    Box(
                        modifier = Modifier
                            .fillMaxSize() // Ocupa todo el tamaño
                            .background(Color.Black)
                            .padding(top=150.dp)
                        ,
                    ) {
                        // Establece la imagen de fondo
                        Image(
                            painter = painterResource(id = R.drawable.fondo),
                            contentDescription = "Fondo de pantalla",
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.TopCenter

                        )
                        // Columna para los botones
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally, // Alinea horizontalmente en el centro
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth() // Ocupa todo el ancho disponible
                                .padding(16.dp, top=200.dp) // Añade padding alrededor de la columna

                        ) {


                            MenuButton(
                                text="TRANQUILIDADE",
                                onClick = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            CounterActivity::class.java
                                        )
                                    )
                                }
                            )

                            MenuButton(
                                text="PARA TONTOS",
                                onClick = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            CounterTontosActivity::class.java
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }

        }

        override fun onDestroy() {
            super.onDestroy()
            // Liberar el WakeLock
            if (wakeLock?.isHeld == true) {
                wakeLock?.release()
            }
            wakeLock = null

            // Remover el flag para mantener la pantalla encendida
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun PreviewMainScreen() {
        CounterTheme {
        }
    }
