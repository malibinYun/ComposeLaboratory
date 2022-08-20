package com.malibin.codelab.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.malibin.codelab.compose.basic.ui.theme.ComposeBasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicCodelabTheme {
                ComposeLaboratoryBasicApp()
            }
        }
    }
}

@Composable
private fun ComposeLaboratoryBasicApp() {
    var shouldShowOnboarding: Boolean by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Welcome to Basics Codelab!")
            Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked,
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
private fun Greetings(names: List<String> = listOf("Android", "Malibin")) {
    Column(
            modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
            )
    ) {
        names.forEach { Greeting(name = it) }
    }
}

@Composable
fun Greeting(name: String) {
    val expandedState = remember { mutableStateOf(false) }
    val expandedPadding = if (expandedState.value) 48.dp else 0.dp

    Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Row(
                modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
        ) {
            Column(
                    modifier = Modifier
                            .weight(1f)
                            .padding(bottom = expandedPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                    onClick = { expandedState.value = !expandedState.value }
            ) {
                Text(text = if (expandedState.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicCodelabTheme {
        ComposeLaboratoryBasicApp()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeBasicCodelabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}
