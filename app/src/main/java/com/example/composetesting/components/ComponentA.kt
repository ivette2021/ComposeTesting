package com.example.composetesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag


@Composable
fun ComponentA() {
    Column(Modifier.fillMaxSize()){
        Text(text = "Ivette",Modifier.testTag("component1"))
        Text(text = "Ivi", Modifier.testTag("component2"))
        Text(text = "Ihiviko", Modifier.testTag("component3"))
        Text(text = "Ita", Modifier.testTag("component4"))
        
        Image(Icons.Default.Add, contentDescription = "sImage")
        Image(Icons.Default.Add, contentDescription = "xsImage")
        Image(Icons.Default.Add, contentDescription = "xsImage")
        Image(Icons.Default.Add, contentDescription = "xsImage")
    }
}