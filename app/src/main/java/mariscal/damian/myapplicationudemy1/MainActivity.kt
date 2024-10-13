package mariscal.damian.myapplicationudemy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mariscal.damian.myapplicationudemy1.ui.theme.MyApplicationUdemy1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Content()
        }
    }
}
/*
Modificadores ayudan a moldear el comportamiento de los componentes
Posicionamiento = width, height, etc
Funcionalidad = Click, scroll
Apaiencia = background, padding, border
Escucha listenin= onkeyEvent
 */

val items = listOf(
    Color.Red,
    Color.Blue,
    Color.Black,
    Color.LightGray,
    Color.Yellow,
    Color.Green
)

val nombre = "Me gusta"


@Preview(showBackground = true)
@Composable // Toda funcion se va convertir en un componente visual.
fun Content() {
    var likes by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(10.dp)

    ) {
        Texto(texto = "Bienvenido")
        Space()
        Texto(texto = "Jetpack")
        Space()
        Texto(texto = "Compose")
        Space()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(items){ item ->
                Circulo(color = item)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Space()
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = {
                likes++
            }) {
                Text(text = nombre)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Resultado(likes = likes)
        }
    }
}

@Composable
fun Resultado(likes:Int){
    Text(text = likes.toString(), fontSize = 50.sp, fontWeight = FontWeight.Bold)
}


@Composable // Toda funcion se va convertir en un componente visual.
fun Texto(texto: String) {
    Text(
        text = texto,
        color = Color.Blue,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Yellow)
            .padding(30.dp)
            .fillMaxWidth()
            .clickable {
                println("Hola Damian")
            }
    )
}


@Composable
fun Circulo(color: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(color, CircleShape)
    )
}


@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}