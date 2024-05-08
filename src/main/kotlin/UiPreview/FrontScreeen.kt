package UiPreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun firstscreen(function:(String)-> Unit){
    var name by remember { mutableStateOf("Text") }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Brush.radialGradient(colors = listOf(Color.Green, Color.LightGray))),
    ){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is basic To-Do App", modifier = Modifier.padding(10.dp)
            , style = MaterialTheme.typography.h3)
            TextField(
                value = name,
                onValueChange = {
                    name = it
                },
                label = { Text("Enter Your Name") },
                modifier = Modifier.padding(10.dp)
            )

            Button(onClick = {if (name.isNotEmpty()) function.invoke(name) } ){
                Text("Create your Todo app")
            }

            if (name.isEmpty()){
                Text(text = "Please Enter your Name First")
            }
        }
    }
}