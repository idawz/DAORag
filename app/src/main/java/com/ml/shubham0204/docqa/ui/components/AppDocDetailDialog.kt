package com.ml.shubham0204.docqa.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Dialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ml.shubham0204.docqa.ui.theme.GloriaBlue

private val dialogVisible = mutableStateOf(false)
private val dialogFileName = mutableStateOf("")
private val dialogText = mutableStateOf("")

@Composable
fun AppDocDetailDialog() {
    val isVisible by remember { dialogVisible }
    if (isVisible) {
        Dialog(onDismissRequest = { /* non cancellable */ }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(24.dp),
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = dialogFileName.value)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = dialogText.value,
                        modifier =
                            Modifier.height(200.dp).verticalScroll(rememberScrollState()),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = GloriaBlue),
                            onClick = { hideDocDetailDialog() },
                        ) {
                            Text(text = "Close")
                        }
                    }
                }
            }
        }
    }
}

fun showDocDetailDialog(fileName: String, text: String) {
    dialogFileName.value = fileName
    dialogText.value = text
    dialogVisible.value = true
}

fun hideDocDetailDialog() {
    dialogVisible.value = false
}
