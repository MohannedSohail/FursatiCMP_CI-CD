package org.mohanned.fursati.data.repository

import Company
import FAQ
import Job
import Terms
import org.mohanned.fursati.data.remote.ApiService
import org.mohanned.fursati.data.remote.KtorClient


class FursatiRepository(
    private val apiService: ApiService = KtorClient
) {

    suspend fun getCompaniesForFilter(): Result<List<Company>> {
        return try {
            val response = apiService.getAllCompaniesForFilter()
            if (response.status) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getFaqs(): Result<List<FAQ>> {
        return try {
            val response = apiService.getAllFaqs()
            if (response.status) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTerms(): Result<Terms> {
        return try {
            val response = apiService.getAllTerms()
            if (response.status) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAllJobs(): Result<List<Job>> {
        return try {
            val response = apiService.getAllJobs()
            if (response.status) {
                Result.success(response.data)
            } else {
                Result.failure(Exception("response.message ${response.message.message}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getJobDetails(jobId: Int): Result<Job> {
        return try {
            val response = apiService.getJobDetails(jobId)
            if (response.status) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message.message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}