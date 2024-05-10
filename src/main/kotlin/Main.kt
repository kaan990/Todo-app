import UiPreview.firstscreen
//import UiPreview.inputtask
import UiPreview.learner
//import UiPreview.learnerlam
import UiPreview.secondscren
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
@Preview()
fun App(

) {
    var nameuser by remember { mutableStateOf("") }
//    Get current backstack entry
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){

//            firstscreen{
//                navController.navigate(route "Second/${it}")
//            }

        composable(route = "Home" ){
            firstscreen { navController.navigate(route = "Second/${it}") }
        }
        composable(route = "Second/{username}", arguments = listOf(NavType.StringType)){
            var username = it.arguments?.getString(key = nameuser)
            secondscren(username)
        }

        }


    }
//    get the name





//if (nameuser.isEmpty()){
//    firstscreen{name ->
//        nameuser = name
//    }
//}
//    else{
//           secondscren(nameuser)
//    }


}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
