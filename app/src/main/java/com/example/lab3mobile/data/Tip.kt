package com.example.lab3mobile.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Совет дня
 * @param day Номер дня (от 1 до 30)
 * @param titleRes Заголовок совета
 * @param shortDescriptionRes Краткое описание для списка
 * @param fullDescriptionRes Полное описание для экрана деталей
 * @param imageRes Иллюстрация
 */
data class Tip(
    val day: Int,
    @StringRes val titleRes: Int,
    @StringRes val shortDescriptionRes: Int,
    @StringRes val fullDescriptionRes: Int,
    @DrawableRes val imageRes: Int
)
