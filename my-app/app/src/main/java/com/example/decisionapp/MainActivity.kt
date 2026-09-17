package com.example.decisionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf // prompted
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.ui.unit.sp

// ChatGPT prompt: How do I record the amount of clicks, and have it increase every time I click the buttons?
// Every line added/suggested by it is labeled as "prompted" 


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DecisionApp()
        }
    }
}

@Composable
fun DecisionApp() {
    var answer by remember { mutableStateOf("Should we go?") }

    Text(
        text = answer,
        fontSize = 30.sp,
        modifier = Modifier.padding(
            horizontal = 110.dp,
            vertical = 300.dp
        )
    )

    var clicks by remember {mutableIntStateOf(0)} // prompted

    fun choice (probabilityOfYes: Int) { // prompted
        clicks++

        val randomNumber = Random.nextInt(100)

        if (randomNumber < probabilityOfYes) {
            answer = "Yes"
        }
        else {
            answer = "No"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = 350.dp,
                horizontal = 100.dp
            )
    ) {

        Row{
            Button(
                onClick = {
                    choice(50)
                }
            ) {
                Text("Ok!")
            }

            Button(
                onClick = {
                    choice(25)
                }
            ) {
                Text("Meh")
            }

            Button(
                onClick = {
                    choice(10)
                }
            ) {
                Text("No")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Clicks: $clicks", fontSize = 20.sp,
            modifier = Modifier.padding (
                horizontal = 67.dp
            )
        )
    }


}
