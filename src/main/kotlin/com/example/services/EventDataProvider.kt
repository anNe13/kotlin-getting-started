package com.example.services

import com.github.kittinunf.fuel.Fuel
import org.json.JSONObject

const val APP_PARAMETER = "app=studentproject_nackademin"
const val BASE_URL = "https://brottsplatskartan.se/api"

fun getAreas() : List<String>{
    val (request, response, result) = Fuel.get("$BASE_URL/areas?$APP_PARAMETER").responseString()

    return JSONObject(result.get()).getJSONObject("data").getJSONArray("areas")
            .map { JSONObject(it.toString()).getString("administrative_area_level_1")}
}

fun getLastEvents(): List<String> {
    val (request, response, result) = Fuel.get("$BASE_URL/events?limit=20&area=&location=&type=&page=1$APP_PARAMETER").responseString()

    val theList = JSONObject(result.get()).getJSONArray("data")
            .map { ((it.toString())) }

    return (theList)
}