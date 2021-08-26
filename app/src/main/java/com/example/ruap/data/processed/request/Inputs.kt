package com.example.ruap.data.processed.request

import com.google.gson.annotations.SerializedName

data class Inputs(
    @SerializedName("input1")
    val input1: Input1,
    @SerializedName("GlobalParameters")
    val globalParameters: GlobalParameters
    )