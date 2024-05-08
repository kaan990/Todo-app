package UiPreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun todolist(addtask:(headin: String, des: String) -> String {
    Column (modifier = Modifier.padding(2.dp)
        .fillMaxWidth()
        .height(4.dp)
    ) {
        Text(text = "this is your Heading ${addtask}")
        Text(text = "this is your Description ${addtask(des)}")
    }
}