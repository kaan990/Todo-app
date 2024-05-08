import UiPreview.firstscreen
import UiPreview.secondscren
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview()
fun App() {
//    var nameuser by remember { mutableStateOf("") }
//if (nameuser.isEmpty()){
//    firstscreen{name ->
//        nameuser = name
//    }
//}
//    else{
//        secondscren(nameuser)
//    }
    secondscren("krishna")
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
