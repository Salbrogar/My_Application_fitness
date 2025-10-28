package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NuevoEntrene()
        }
    }
}

@Composable
fun NuevoEntrene(
    modifier: Modifier = Modifier
        .background(Color(0xFF222D3F))
) {
    var result by remember { mutableStateOf(1) }
    val entrenes = remember { mutableStateListOf<Int>() }

    val imageResource = when (result) {
        1 -> R.drawable.initial
        2 -> R.drawable.series
        3 -> R.drawable.escaleras
        4 -> R.drawable.cambiosritmo
        5 -> R.drawable.tiradalarga
        6 -> R.drawable.piernasgym
        else -> R.drawable.initial
    }

    val textResource = when (result) {
        1 -> R.string.entrene_initial
        2 -> R.string.entrene_series
        3 -> R.string.entrene_escaleras
        4 -> R.string.entrene_cambiosRitmo
        5 -> R.string.entrene_tiradaLarga
        6 -> R.string.entrene_piernasGym
        else -> R.string.entrene_descanso
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .size(150.dp),
            painter = painterResource(imageResource),
            contentDescription = stringResource(textResource)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textResource),
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick =
                {
                    result = (2..6).random()
                    entrenes.add(result)
                }) {
            Text(stringResource(R.string.roll))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Próximos entrenes:",
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            entrenes.forEach { id ->
                Text(
                    text = stringResource(
                        when (id) {
                            2 -> R.string.entrene_series
                            3 -> R.string.entrene_escaleras
                            4 -> R.string.entrene_cambiosRitmo
                            5 -> R.string.entrene_tiradaLarga
                            6 -> R.string.entrene_piernasGym
                            else -> R.string.entrene_descanso
                        }
                    ) + "\n",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

    }
}

