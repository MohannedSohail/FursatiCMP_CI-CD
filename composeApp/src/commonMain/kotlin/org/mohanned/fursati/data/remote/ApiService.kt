package org.mohanned.fursati.data.remote

import ApiResponse
import Company
import FAQ
import Job
import Terms

interface ApiService {

    suspend fun getAllCompaniesForFilter(): ApiResponse<List<Company>>

    suspend fun getAllFaqs(): ApiResponse<List<FAQ>>

    suspend fun getAllTerms(): ApiResponse<Terms>

    suspend fun getAllJobs(): ApiResponse<List<Job>>

    suspend fun getJobDetails(jobId: Int): ApiResponse<Job>
}

object ApiRoutes {
    const val BASE_URL = "https://fursaty.kicklance.com/en/api/"
    const val COMPANIES_FOR_FILTER = "all-companies"
    const val FAQS = "faqs"
    const val TERMS = "policies"
    const val ALL_JOBS = "job-seeker/all-jobs"
    const val JOB_DETAILS = "job-seeker/job-details/"
}