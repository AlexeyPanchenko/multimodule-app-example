package ru.alexeypanchenko.mobuisdonor.detail

import java.io.Serializable

data class DetailItem(
    val id: Int,
    val title: String,
    val description: String
) : Serializable