package com.example.library.data.model

import com.google.gson.annotations.SerializedName

data class Library(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)
