package com.example.ruap.data.processed.response

data class Value(
    val ColumnNames: List<String>,
    val ColumnTypes: List<String>,
    val Values: List<List<String>>
)