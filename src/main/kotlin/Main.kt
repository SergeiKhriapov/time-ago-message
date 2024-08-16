package ru.netology

fun main() {
    val timeAgoSeconds = 330
    print(agoToText(timeAgoSeconds))

}

fun agoToText(timeAgoSeconds: Int): String {
    if (timeAgoSeconds < 0) return "Время не может быть отрицательным"
    return when (timeAgoSeconds) {
        in 0..59 -> "был(а) только что"
        in 60..3_600 -> {
            val minutes = timeAgoSeconds / 60
            "был(а) ${minutes} ${getMinuteWordForm(minutes)} назад"
        }

        in 3_601..86_400 -> {
            val hours = timeAgoSeconds / 3_600
            "был(а) $hours ${getHourWordForm(hours)} назад"
        }

        in 86_401..172_800 -> "был(а) вчера"
        in 172_801..259_200 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun getMinuteWordForm(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "минуту"
        minutes % 10 in 2..4 && (minutes % 100 !in 12..14) -> "минуты"
        else -> "минут"
    }
}

fun getHourWordForm(hours: Int): String {
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "час"
        hours % 10 in 2..4 && (hours % 100 !in 12..14) -> "часа"
        else -> "часов"
    }
}

