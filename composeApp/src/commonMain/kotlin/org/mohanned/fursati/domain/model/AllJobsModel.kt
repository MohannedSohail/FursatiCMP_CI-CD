import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val status: Boolean,
    val message: Message,
    val data: T
)

@Serializable
data class Message(
    val message: String
)

// Company Models
@Serializable
data class Company(
    val id: Int,
    val name: String
)

// FAQ Models
@Serializable
data class FAQ(
    val id: Int,
    val title: String,
    val description: String
)

// Terms Models
@Serializable
data class Terms(
    val title: String,
    val description: String
)

// Job Models
@Serializable
data class Job(
    val id: Int,
    val title: String,
    @SerialName("employment_type")
    val employmentType: String,
    @SerialName("work_field_id")
    val workFieldId: Int,
    @SerialName("work_place")
    val workPlace: String,
    @SerialName("country_of_employment")
    val countryOfEmployment: Country,
    val salary: String?,
    @SerialName("salary_show")
    val salaryShow: Int,
    @SerialName("work_experience")
    val workExperience: Int,
    @SerialName("job_valid_unite")
    val jobValidUnite: String,
    val summary: String,
    @SerialName("nationality_prefrence")
    val nationalityPreference: Country?,
    @SerialName("country_of_residence")
    val countryOfResidence: Country?,
    @SerialName("gender_perfrence")
    val genderPreference: String?,
    @SerialName("request_vedio")
    val requestVideo: Int,
    val question: String?,
    val status: Int,
    @SerialName("business_man_id")
    val businessManId: Int,
    @SerialName("currency_id")
    val currencyId: Int?,
    @SerialName("pay_status")
    val payStatus: Int,
    @SerialName("education_level_id")
    val educationLevelId: Int,
    @SerialName("education_feild_id")
    val educationFieldId: Int,
    @SerialName("certification_id")
    val certificationId: Int,
    @SerialName("file_description")
    val fileDescription: String?,
    @SerialName("country_of_graduation")
    val countryOfGraduation: String?,
    @SerialName("create_time")
    val createTime: String,
    @SerialName("expire_date")
    val expireDate: Int,
    val applicants: Int,
    val invited: List<String>,
    @SerialName("watches_count")
    val watchesCount: Int,
    @SerialName("is_favorite")
    val isFavorite: Boolean,
    @SerialName("is_applied")
    val isApplied: Boolean,
    val watches: List<Watch>,
    @SerialName("education_level")
    val educationLevel: EducationLevel,
    @SerialName("education_feild")
    val educationField: EducationField,
    val certification: Certification,
    @SerialName("experience_year")
    val experienceYear: ExperienceYear,
    @SerialName("business_man")
    val businessMan: BusinessMan,
    val currency: Currency?,
    val skills: List<Skill>,
    @SerialName("work_field")
    val workField: WorkField
)

@Serializable
data class Country(
    val id: Int,
    val code: String,
    @SerialName("prefix_number")
    val prefixNumber: String,
    @SerialName("country_image")
    val countryImage: String,
    val name: String
)

@Serializable
data class Watch(
    val id: Int,
    @SerialName("device_id")
    val deviceId: String?,
    @SerialName("job_id")
    val jobId: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)

@Serializable
data class EducationLevel(
    val id: Int,
    val name: String
)

@Serializable
data class EducationField(
    val id: Int,
    val name: String
)

@Serializable
data class Certification(
    val id: Int,
    val abbreviation: String,
    val name: String
)

@Serializable
data class ExperienceYear(
    val id: Int,
    val name: String
)

@Serializable
data class BusinessMan(
    val id: Int,
    val name: String?,
    @SerialName("job_title")
    val jobTitle: String?,
    @SerialName("work_field_id")
    val workFieldId: Int?,
    @SerialName("date_of_birth")
    val dateOfBirth: String?,
    val gender: String?,
    @SerialName("country_id")
    val countryId: Int?,
    val nationality: String?,
    @SerialName("business_name")
    val businessName: String?,
    @SerialName("type_business")
    val typeBusiness: Int?,
    @SerialName("employee_no")
    val employeeNo: String?,
    @SerialName("user_name")
    val userName: String?,
    val email: String,
    val phone: String,
    @SerialName("intro_phone")
    val introPhone: String,
    val telephone: String?,
    @SerialName("intro_telephone")
    val introTelephone: String?,
    @SerialName("email_verified_at")
    val emailVerifiedAt: String?,
    @SerialName("role_id")
    val roleId: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("active_status")
    val activeStatus: Int,
    @SerialName("verify_code")
    val verifyCode: String?,
    @SerialName("complete_status")
    val completeStatus: Int,
    val website: String?,
    @SerialName("contact_privacy")
    val contactPrivacy: Int,
    val bio: String?,
    @SerialName("is_from_socialite")
    val isFromSocialite: Int,
    @SerialName("active_socialite")
    val activeSocialite: Int,
    @SerialName("fcm_token")
    val fcmToken: String?,
    @SerialName("stripe_id")
    val stripeId: String?,
    @SerialName("pm_type")
    val pmType: String?,
    @SerialName("pm_last_four")
    val pmLastFour: String?,
    @SerialName("trial_ends_at")
    val trialEndsAt: String?,
    @SerialName("business_entity")
    val businessEntity: String?,
    @SerialName("incorporation_year")
    val incorporationYear: String?,
    @SerialName("registration_certificate")
    val registrationCertificate: String?,
    val instagram: String?,
    val media: String?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("cover_url")
    val coverUrl: String?,
    @SerialName("cv_file_url")
    val cvFileUrl: String?,
    @SerialName("experience_years")
    val experienceYears: String,
    @SerialName("number_experience_years")
    val numberExperienceYears: Int,
    @SerialName("name_with_certifications")
    val nameWithCertifications: String?,
    @SerialName("is_complete")
    val isComplete: Int
)

@Serializable
data class Currency(
    val id: Int,
    val name: String,
    val shape: String
)

@Serializable
data class Skill(
    val id: Int,
    val name: String,
    val status: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val pivot: SkillPivot? = null
)

@Serializable
data class SkillPivot(
    @SerialName("job_id")
    val jobId: Int,
    @SerialName("skill_id")
    val skillId: Int
)

@Serializable
data class WorkField(
    val id: Int,
    val name: String
)