package com.example.profilelistcompose

data class UserProfile(
    val id: Int,
    val name: String,
    val status: Boolean,
    val drawableId: Int
)

val userProfileList = arrayListOf(
    UserProfile(1, "Batman", true, R.drawable.batman),
    UserProfile(2, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(3, "Batman", true, R.drawable.batman),
    UserProfile(4, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(5, "Batman", true, R.drawable.batman),
    UserProfile(6, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(7, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(8, "Batman", true, R.drawable.batman),
    UserProfile(9, "Batman", true, R.drawable.batman),
    UserProfile(10, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(11, "Batman", true, R.drawable.batman),
    UserProfile(12, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(13, "Batman", true, R.drawable.batman),
    UserProfile(14, "Taewoong Yang", false, R.drawable.creepy_yang),
    UserProfile(15, "Batman", true, R.drawable.batman)
)