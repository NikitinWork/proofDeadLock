package com.android.kotlin.android

import kotlinx.cinterop.CPointer
import platform.android.JNIEnvVar

fun deadlock() {
    var e = Exception()
    println("Kotlin deadlock()")
    //Any code will never be executed further, and the thread will be blocked
}

fun normalWork() {
    //var e = Exception()
    println("Kotlin normalWork()")
    //The code will be executed only if the call is from JNI_OnLoad
}