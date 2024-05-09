package UiPreview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun secondscren(nameuser:String) {

    var iconcliker by remember { mutableStateOf(false) }
    var Headtag by remember { mutableStateOf("") }
    var Destag by remember { mutableStateOf("") }
    var notedata by remember { mutableStateOf(listOf<String>()) }
    var desdata by remember { mutableStateOf(listOf<String>()) }


    Box() {

        var heading by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var nameuser by remember { mutableStateOf(nameuser) }

        Column {
            Text(
                "Welcome to To-do App $nameuser", modifier = Modifier.fillMaxWidth()
                    .padding(10.dp), style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Your Task", textAlign = TextAlign.Center, fontSize = 15.sp, modifier = Modifier.fillMaxWidth()
                    .padding(2.dp)
            )

            for (i in 0.. notedata.size-1){
            Surface(modifier = Modifier.padding(5.dp)
                .fillMaxWidth(0.9f),
                elevation = 8.dp,
                shape = RoundedCornerShape(15.dp),
//                Onclick the surface we can also add card
            ) {
                Column(modifier = Modifier.padding(start = 15.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)) {

                    Text(text = "${notedata.get(i)}", modifier = Modifier.padding(5.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "${desdata.get(i)}", modifier = Modifier.padding(5.dp), fontFamily = FontFamily.Monospace, fontSize = 12.sp)

                    Icon(imageVector = Icons.Default.Delete,
                        contentDescription = "Remove",
                        modifier = Modifier.size(25.dp)
                            .clickable { print("note remove")  })
                }
                }
            }

//            Calling Adding function


        }
        Box(
            modifier = Modifier
                .fillMaxSize().padding(50.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Adding task",
                modifier = Modifier.size(48.dp)
                    .border(2.dp, color = Color.Black, shape = CircleShape)
                    .clickable {
                        iconcliker = !iconcliker
//                       Calling function to add my task into my ArrayList
                        println("Button is click $iconcliker")
                    }
            )

        }
        fun addData(note: String, description: String) {
            // Append new elements to the lists using the plus operator
            notedata += note
            desdata += description
        }

        if (iconcliker == true) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column {
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
                    var warning = false
                    Button(onClick = {
                        if(Headtag.isNotEmpty() && Destag.isNotEmpty()) {
                            warning = false
                            addData(Headtag, Destag)
                            iconcliker = false
                        }else{
                            warning = true
                            println("red button display")
                        }
                    }) {
                        Column {
                            Text("Enter your Task")
                            if (warning !=false) {
                                Text("Enter Fill Both Input section", modifier = Modifier, color = Color.Red)
                            }
                        }
                    }
                }
            }



            Box(
                modifier = Modifier
                    .fillMaxSize().padding(50.dp),
                contentAlignment = Alignment.BottomEnd,
            ) {
                Icon(imageVector = Icons.Default.Close,
                    contentDescription = "Adding task",
                    modifier = Modifier.size(48.dp)
                        .border(2.dp, color = Color.Black, shape = CircleShape)
                        .clickable {
                            iconcliker = !iconcliker
//                       Calling function to add my task into my ArrayList
                            println("Button is click $iconcliker")
                        }
                )

            }
        }
    }

}



//data class Taskadder(var head:String,var desc:String )
//
//
//fun inputtask() {
//    var Headtag by remember { mutableStateOf("") }
//    var Destag by remember { mutableStateOf("") }
//    Box(modifier = Modifier
//        .fillMaxSize()
//    ){
//        Text("Enter your Task Heading")
//        TextField(
//            value = Headtag,
//            onValueChange = {
//                Headtag = it
//            },
//            label = { Text("Task heading") }
//        )
//        Text("Enter your task description")
//        TextField(
//            value = Destag,
//            onValueChange = {
//                Destag = it
//            },
//            label = { Text("Task description") }
//        )
//
//        Button(onClick = {
//
//        }){
//            Text("Enter your Task")
//        }
//    }
//}


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