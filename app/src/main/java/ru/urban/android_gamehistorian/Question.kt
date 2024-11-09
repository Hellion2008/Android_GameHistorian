package ru.urban.android_gamehistorian

data class Question(
    val textQuestion: String,
    val answer: String,
    val versions: List<String>) {
}