package com.tiagodanin.waterwearos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.tiagodanin.waterwearos.R
import com.tiagodanin.waterwearos.presentation.theme.WaterWearOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

private val count: MutableState<Float> = mutableStateOf(0f)

@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun WearApp() {
    WaterWearOSTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            timeText = {
                TimeText()
            },
        ) {
            ProgressIndicatorWater()
        }
    }
}

@Composable
fun ProgressIndicatorWater() {
    val recomedByDay = 3.0f
    val progressOfDay: Float = count.value / recomedByDay

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            startAngle = 295f,
            endAngle = 245f,
            progress = progressOfDay, // Valor do progresso
            strokeWidth = 5.dp,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp)
        )
        InfoWater()
    }
}

@Composable
fun InfoWater() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            text = "Você já bebeu ${count.value} litro de água hoje"
        )
        Button(
            modifier = Modifier.padding(top = 5.dp),
            onClick = { count.value += 0.5f },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cup_water),
                contentDescription = "airplane",
                modifier = Modifier
                    .size(ButtonDefaults.DefaultButtonSize)
                    .wrapContentSize(align = Alignment.Center),
            )
        }
    }
}


@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}