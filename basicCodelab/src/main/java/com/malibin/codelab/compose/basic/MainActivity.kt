package com.malibin.codelab.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
private fun ComposeLaboratoryBasicApp(names: List<String> = listOf("Android", "Malibin")) {
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
                    modifier = Modifier.weight(1f)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                    onClick = {}
            ) {
                Text(text = "Show more")
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
