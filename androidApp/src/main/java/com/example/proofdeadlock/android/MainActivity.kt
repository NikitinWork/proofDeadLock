package com.example.proofdeadlock.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        System.loadLibrary("android")

        setContent {
            DeadLockButton()
            NormalWorkButton()
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    DeadLockButton()
    NormalWorkButton()
}

@Composable
fun DeadLockButton(){
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 1.dp),
        onClick = {
            NdkWrapper().deadlock()
            Toast.makeText(context, "Deadlock did not occur", Toast.LENGTH_LONG).show()
        }) {

        Text(text = "DeadLock")
    }
}

@Composable
fun NormalWorkButton(){
    val context = LocalContext.current
    Button(
        modifier = Modifier
        .padding(vertical = 64.dp),
        onClick = {
            NdkWrapper().normalWork()
            Toast.makeText(context, "Normal call worked", Toast.LENGTH_LONG).show()
        }) {
        Text(text = "NormalWork")
    }
}