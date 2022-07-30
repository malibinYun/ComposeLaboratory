package com.malibin.codelab.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
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
private fun ComposeLaboratoryBasicApp() {
    Surface(color = MaterialTheme.colors.background) {
        Greeting(name = "Android")
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicCodelabTheme {
        Greeting("Android")
    }
}
