package com.example.ruap.data

import com.example.ruap.data.unprocessed.Source
import java.io.Serializable

data class Article(val source: Source, val title: String, val description: String, val url: String, val urlToImage: String, val publishedAt: String, val content: String) : Serializable
