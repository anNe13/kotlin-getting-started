package com.example

import com.example.ws.EventWs
import spark.Spark



        fun main(args: Array<String>) {
            val process = ProcessBuilder()
            val port: Int?
            if (process.environment()["PORT"] != null) {
                port = Integer.parseInt(process.environment()["PORT"])
            } else {
                port = 8080
            }




            Spark.port(port)
            //  ipAddress("92.254.184.174")
            // staticFileLocation("/public")
            Spark.webSocket("/event", EventWs::class.java)
            Spark.init()
        }
