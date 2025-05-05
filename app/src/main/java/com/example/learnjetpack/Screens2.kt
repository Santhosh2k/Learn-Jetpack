package com.example.learnjetpack

sealed class Screens2(val screens: String){
    data object Home:Screens2("home")
    data object Search:Screens2("search")
    data object Profile:Screens2("profile")
    data object Notification:Screens2("notification")
}