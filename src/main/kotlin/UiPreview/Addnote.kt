package UiPreview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun todolist(){


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