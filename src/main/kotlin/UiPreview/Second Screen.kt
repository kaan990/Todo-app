package UiPreview

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment




@Composable
fun secondscren(nameuser:String) {

    var  heading by remember { mutableStateOf("") }
    var  description by remember { mutableStateOf("") }
    var nameuser by remember { mutableStateOf(nameuser) }


    Box() {
        Column {
            Text(
                "Welcome to To-do App $nameuser", modifier = Modifier.fillMaxWidth()
                    .padding(10.dp), style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )

//            Your To do app
            Text(text = "Your Task", textAlign = TextAlign.Center, fontSize = 15.sp, modifier = Modifier.fillMaxWidth()
                .padding(2.dp))

//            Calling Adding function


        }
        Box(modifier = Modifier
            .fillMaxSize().padding(50.dp),
            contentAlignment = Alignment.BottomEnd,
        ){
           Icon(imageVector = Icons.Default.Add,
               contentDescription = "Adding task",
               modifier = Modifier.size(48.dp)
                   .border(2.dp, color = Color.Black, shape = CircleShape)
                   .clickable {
//                       Calling function to add my task into my ArrayList
                       var getvalue = inputtask{function:("krishna")-> Unit}
                   }
               )

        }
    }
}

data class Taskadder(var head:String,var desc:String )

@Composable
fun inputtask(function: (username:String)->String{
    var Headtag by remember { mutableStateOf("") }
    var Destag by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Text("Enter your Task Heading")
        TextField(
            value = Headtag,
            onValueChange = {
                Headtag = it
            },
            label = { Text("Task heading") }
        )
        Text("Enter your task description")
        TextField(
            value = Destag,
            onValueChange = {
                Destag = it
            },
            label = { Text("Task description") }
        )

        Button(onClick = {
            secondscren("sai")
        }){
            Text("Enter your Task")
        }
    }
}


//    Box(modifier = Modifier.padding(5.dp)
//        .fillMaxSize()
//    ){
//        Row {
////            left Side Section
//            Surface(modifier = Modifier
//                .fillMaxWidth(0.3f)
//                .fillMaxHeight(),
//                elevation = 12.dp,
//                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 150.dp)
//
//            ){
//            Column {
//                Text(text = "Welcome, $nameuser")
//            } }
//        }
//    }