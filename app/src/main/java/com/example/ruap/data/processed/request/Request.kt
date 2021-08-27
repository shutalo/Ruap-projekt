package com.example.ruap.data.processed.request

data class Request(
    var Inputs: Inputs,
    var GlobalParameters: HashMap<String,String>
)