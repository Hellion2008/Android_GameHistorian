package ru.urban.android_gamehistorian

class DataBaseQuestion {

    private val _questions = listOf(
        Question("Годы Великой Отечественной войны?",
            "1941-1945",
            listOf("1939-1945", "1941-1945", "1941-1944")),
        Question("В каком году произошло крещение Руси?",
            "988",
            listOf("987", "988", "989")),
        Question("С кем в Куликовской битве сражалось русское войско во главе с Дмитрием Донским?",
            "Золотая Орда",
            listOf("Золотая Орда", "Половцы", "Турки")),
        Question("Какой российский император отменил крепостное право?",
            "Александр II",
            listOf("Александр I", "Николай I", "Александр II")),
        Question("В каком веке в России был период Смуты?",
            "XVII",
            listOf("XVII", "XV", "XVI"))
    )

    val questions: List<Question>
        get() = _questions
}