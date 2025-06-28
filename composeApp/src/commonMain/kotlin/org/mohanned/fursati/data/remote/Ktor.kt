package org.mohanned.fursati.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object Ktor {
        private const val BASE_URL="https://fursaty.kicklance.com/"

        val client: HttpClient=HttpClient{
                install(ContentNegotiation){
                        json()
                }
        }
}