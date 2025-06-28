package org.mohanned.fursati.domain.model

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//object ApiService {
//    suspend fun getAllJobs(): AllJobsResponse = withContext(Dispatchers.Default) {
//        NetworkClient.client.submitForm(
//            url = "/ar/api/job-seeker/all-jobs",
//            formParameters = Parameters.build {
//                append("from_date", "15-03-2023")
//                append("to_date", "30-03-2023")
//                append("country_of_graduation", "5")
//                append("country_of_residence", "5")
//                append("work_field_id", "1")
//                append("title", "test")
//                append("work_place", "test")
//                append("gender_perfrence", "all")
//                append("education_level_id", "1")
//                append("work_experience", "1")
//                append("business_man_id", "1")
//            }
//        ).body()
//    }
//}