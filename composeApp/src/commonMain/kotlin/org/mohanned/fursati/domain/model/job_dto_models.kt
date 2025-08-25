package org.mohanned.fursati.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllJobsResponse(
    val status: Boolean,
    val message: MessageResponse,
    val data: List<JobDto>
)

@Serializable
data class MessageResponse(
    val message: String
)

@Serializable
data class JobDto(
    val id: Int,
    val title: String,
    @SerialName("employment_type") val employmentType: String? = null,
    @SerialName("work_place") val workPlace: String? = null,
    @SerialName("summary") val summary: String? = null,
    @SerialName("job_valid_unite") val jobValidUnite: String? = null,
    @SerialName("salary") val salary: String? = null,
    @SerialName("salary_show") val salaryShow: Int,
    @SerialName("work_experience") val workExperience: Int,
    @SerialName("gender_perfrence") val genderPreference: String? = null,
    @SerialName("request_vedio") val requestVedio: Int,
    @SerialName("status") val status: Int,
    @SerialName("create_time") val createTime: String,
    @SerialName("expire_date") val expireDate: Int,
    @SerialName("is_favorite") val isFavorite: Boolean,
    @SerialName("is_applied") val isApplied: Boolean,
    @SerialName("country_of_employment") val countryOfEmployment: CountryDto? = null,
    @SerialName("country_of_residence") val countryOfResidence: CountryDto? = null,
    @SerialName("nationality_prefrence") val nationalityPreference: CountryDto? = null,
    @SerialName("education_level") val educationLevel: NamedDto? = null,
    @SerialName("education_feild") val educationField: NamedDto? = null,
    @SerialName("certification") val certification: CertificationDto? = null,
    @SerialName("experience_year") val experienceYear: NamedDto? = null,
    @SerialName("currency") val currency: CurrencyDto? = null,
    @SerialName("skills") val skills: List<SkillDto> = emptyList(),
    @SerialName("work_field") val workField: NamedDto? = null,
    @SerialName("business_man") val businessMan: BusinessManDto? = null
)

@Serializable
data class CountryDto(
    val id: Int,
    val code: String,
    @SerialName("prefix_number") val prefixNumber: String,
    @SerialName("country_image") val countryImage: String,
    val name: String
)

@Serializable
data class NamedDto(
    val id: Int,
    val name: String
)

@Serializable
data class CertificationDto(
    val id: Int,
    val abbreviation: String,
    val name: String
)

@Serializable
data class CurrencyDto(
    val id: Int,
    val name: String,
    val shape: String
)

@Serializable
data class SkillDto(
    val id: Int,
    val name: String,
    val status: Int
)

@Serializable
data class BusinessManDto(
    val id: Int,
    @SerialName("business_name") val businessName: String? = null,
    val email: String,
    val phone: String,
    val website: String? = null,
    val bio: String? = null,
    @SerialName("image_url") val imageUrl: String? = null,
    @SerialName("cover_url") val coverUrl: String? = null,
    @SerialName("experience_years") val experienceYears: String? = null
)
