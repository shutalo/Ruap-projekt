package com.example.ruap.data.unprocessed

import com.example.ruap.data.Article

data class Response(val status: String, val totalResults: Int, val articles: MutableList<Article>)
