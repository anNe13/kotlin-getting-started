package com.example.services

import com.example.models.Message
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


fun getAreasMessage(): Message {
    return Message("areas", getAreas())
}

fun getLatestMessage(): Message{
    return Message("latest", getLastEvents())
}