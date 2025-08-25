package org.mohanned.fursati.data.remote

import ApiResponse
import Company
import FAQ
import Job
import Terms
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient : ApiService {

    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
                prettyPrint = true
            })
        }
    }

    override suspend fun getAllCompaniesForFilter(): ApiResponse<List<Company>> {
        return client.get {
            url("${ApiRoutes.BASE_URL}${ApiRoutes.COMPANIES_FOR_FILTER}")
        }.body()
    }

    override suspend fun getAllFaqs(): ApiResponse<List<FAQ>> {
        return client.get { url("${ApiRoutes.BASE_URL}${ApiRoutes.FAQS}") }.body()
    }

    override suspend fun getAllTerms(): ApiResponse<Terms> {
        return client.get { url("${ApiRoutes.BASE_URL}${ApiRoutes.TERMS}") }.body()
    }

    override suspend fun getAllJobs(): ApiResponse<List<Job>> {
        return client.get { url("${ApiRoutes.BASE_URL}${ApiRoutes.ALL_JOBS}") }.body()
    }

    override suspend fun getJobDetails(jobId: Int): ApiResponse<Job> {
        return client.get { url("${ApiRoutes.BASE_URL}${ApiRoutes.JOB_DETAILS}${jobId}") }.body()
    }
}