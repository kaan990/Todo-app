package UiPreview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(onClick: (Int, String) -> String){
    Column {
        val name = "Krishna"
        Box(Modifier.size(300.dp).background(Color.Red))
        Button(onClick = {
            onClick.invoke(1,name)
        }){
            Text("Start")

        }
    }
}
@Composable
fun EndScreen(onClick: () -> Unit){
    Column {
        Box(Modifier.size(300.dp).background(Color.Blue))
        Button(onClick = {
            val endReference = onClick.invoke()
            println("value of endReference is $endReference")
        }){
            Text("End")

        }
    }
}
@Composable
fun learner(){
    var screen by remember { mutableStateOf("Start") }
    if (screen == "Start"){
        StartScreen(onClick = { num, str ->
            println("value of num is $num and str is $str")
            screen = "End"
            "hello"
        })
    }else{
        EndScreen{
            screen = "Start"
        }
    }
}