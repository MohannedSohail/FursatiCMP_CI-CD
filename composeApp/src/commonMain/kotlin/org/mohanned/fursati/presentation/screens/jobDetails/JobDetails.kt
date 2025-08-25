package org.mohanned.fursati.presentation.screens.jobDetails

import Job
import Skill
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.company_rectangle
import fursaticmp.composeapp.generated.resources.earth
import fursaticmp.composeapp.generated.resources.eye
import fursaticmp.composeapp.generated.resources.job_star
import fursaticmp.composeapp.generated.resources.job_star1
import fursaticmp.composeapp.generated.resources.job_star2
import fursaticmp.composeapp.generated.resources.pure_company
import fursaticmp.composeapp.generated.resources.save
import fursaticmp.composeapp.generated.resources.saved
import fursaticmp.composeapp.generated.resources.share
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.data.repository.FursatiRepository
import org.mohanned.fursati.domain.model.UiState
import org.mohanned.fursati.presentation.screens.companyDetails.CompanyDetailsScreen
import org.mohanned.fursati.presentation.viewmodels.FursatiViewModel
import org.mohanned.fursati.utils.theme.BtnShadowColor
import org.mohanned.fursati.utils.theme.JobButtonColor
import org.mohanned.fursati.utils.theme.JobCardColor
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.theme.ReadMoreBtnColor
import org.mohanned.fursati.utils.views.RoundedCornerTopBar
import org.mohanned.fursati.utils.views.shareBottomSheetContent


class JobDetails(private val jobId: Int) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        var showJobDescriptionSheet by remember { mutableStateOf(false) }

        val jobDescriptionSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        var showShareSheet by remember { mutableStateOf(false) }

        val shareSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        val viewModel = remember { FursatiViewModel(FursatiRepository()) }
        val jobDetailsState by viewModel.jobDetailsState.collectAsState()
        LaunchedEffect(jobId) {
            viewModel.loadJobDetails(jobId)
        }
        when (jobDetailsState) {
            is UiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = PrimaryColor)
                }
            }

            is UiState.Success<Job> -> {
                val jobDetails = (jobDetailsState as UiState.Success<Job>).data

                Box {
                    Scaffold(

                        topBar = { RoundedCornerTopBar("Back", onClick = ({})) },


                        ) {

                        Column(
                            modifier = Modifier.fillMaxSize()
                                .verticalScroll(rememberScrollState(), true)
                                .padding(
                                    top = 90.dp,
                                    bottom = 50.dp,
                                    start = 20.dp,
                                    end = 20.dp,
                                )
                        ) {

                            JobDetailsItem(
                                onShareClick = ({
                                    showShareSheet = true
                                }), onItemClick = ({ navigator.push(CompanyDetailsScreen(jobId)) }),
                                jobDetails = jobDetails
                            )
                            DetailsSection(jobDetails = jobDetails)
                            SkillsSection(jobDetails.skills)
                            JobDescriptionSection(
                                jobDetails.summary,
                                onReadMoreClick = ({
                                    showJobDescriptionSheet = true
                                })
                            )
                            CandidateRequirementsSection(jobDetails)
                            ApplyBtn(onApplyClick = ({
                                showJobDescriptionSheet = true

                            }))

                        }

                    }
                    if (showShareSheet) {
                        ModalBottomSheet(
                            onDismissRequest = { showShareSheet = false },
                            sheetState = shareSheetState,
                            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                            containerColor = Color.White,
                        ) {
                            shareBottomSheetContent()
                        }
                    }


                    if (showJobDescriptionSheet) {
                        ModalBottomSheet(
                            onDismissRequest = { showJobDescriptionSheet = false },
                            sheetState = jobDescriptionSheetState,
                            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                            containerColor = Color.White,
                        ) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Text(
                                    text = "NOT Registered",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = PrimaryColor
                                )

                                Spacer(modifier = Modifier.height(14.dp))
                                Text(
                                    text = "You Are not a member Yet, Do you have an account?",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                )

                                Spacer(modifier = Modifier.height(30.dp))

                                ElevatedButton(
                                    modifier = Modifier.fillMaxWidth().shadow(
                                        15.dp,
                                        RoundedCornerShape(12.dp),
                                        true,
                                        BtnShadowColor,
                                        BtnShadowColor
                                    ),
                                    onClick = {},
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonColors(
                                        PrimaryColor,
                                        Color.White,
                                        Color.Unspecified,
                                        Color.Unspecified
                                    ),

                                    contentPadding = PaddingValues(vertical = 15.dp)
                                ) {


                                    Text(
                                        "LOGIN", style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    )


                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                OutlinedButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    onClick = {},
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, PrimaryColor),
                                    colors = ButtonColors(
                                        Color.White,
                                        PrimaryColor,
                                        Color.Unspecified,
                                        Color.Unspecified
                                    ),

                                    contentPadding = PaddingValues(vertical = 15.dp)
                                ) {


                                    Text(
                                        "SIGNUP", style = TextStyle(
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    )


                                }


                            }
                        }
                    }

                }
            }

            is UiState.Error -> {
                println("Error: ${(jobDetailsState as UiState.Error).message}")
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Error: ${(jobDetailsState as UiState.Error).message}",
                            color = Color.Red,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { viewModel.loadJobDetails(jobId) }
                        ) {
                            Text("Retry")
                        }
                    }
                }
            }

        }
    }

}

@Composable
fun ApplyBtn(onApplyClick: () -> Unit) {
    ElevatedButton(
        modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp).shadow(
            15.dp,
            RoundedCornerShape(12.dp), true, BtnShadowColor, BtnShadowColor
        ),
        onClick = onApplyClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonColors(
            PrimaryColor,
            Color.White,
            Color.Unspecified,
            Color.Unspecified
        ),

        contentPadding = PaddingValues(vertical = 15.dp)
    ) {


        Text(
            "Apply", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        )


    }
}

@Composable
fun CandidateRequirementsSection(jobDetails: Job) {
    Section("Candidate Requirements")

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        DetailsSectionCardItem(
            "Nationality",
            (jobDetails.nationalityPreference?.name ?: "Kuwait, Palestinian, Indian").toString()
        )
        DetailsSectionCardItem(
            "Country Residence",
            (jobDetails.countryOfResidence?.name ?: "Egypt , Jordan, Indian").toString()
        )
        DetailsSectionCardItem("Gender", jobDetails.genderPreference ?: "All")
    }

}

@Composable
fun Section(secTitle: String) {
    Text(
        secTitle,
        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.Black),
        modifier = Modifier.padding(bottom = 16.dp, top = 25.dp)
    )
}

@Composable
fun JobDescriptionSection(description: String, onReadMoreClick: () -> Unit) {

    Section("Job Description")
    Card(
        modifier = Modifier.background(JobCardColor),
        shape = RoundedCornerShape(8.dp)
    ) {

        Text(
            text = if (description.length > 200)
                "${description.take(200)}..."
            else
                description
                    ?: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            ),
            modifier = Modifier.fillMaxWidth().padding(12.dp)
        )

        TextButton(
            onClick = onReadMoreClick,
            colors = ButtonColors(
                containerColor = Color.Unspecified,
                contentColor = ReadMoreBtnColor,
                disabledContainerColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified
            )
        ) {
            Text("Read More")
        }
    }


}

@Composable
fun SkillsSection(skills: List<Skill>) {
    Section("Skills")

    if (skills.isEmpty()) {
        Card(
            modifier = Modifier.fillMaxWidth().background(JobCardColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "No specific skills required",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    } else {
        Card(
            modifier = Modifier.fillMaxWidth().background(JobCardColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            LazyRow(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(skills) { skill ->
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonColors(
                            JobButtonColor,
                            PrimaryColor,
                            Color.Unspecified,
                            Color.Unspecified
                        ),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text(
                            skill.name,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }
        }
    }
}
//@Composable
//fun SkillsSection() {
//    Section("Skills")
//    Card(
//        modifier = Modifier.background(JobCardColor),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//
//        Row(
//            modifier = Modifier.fillMaxWidth()
//                .padding(start = 10.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//
//
//            Button(
//                modifier = Modifier.weight(1f),
//                onClick = {},
//                shape = RoundedCornerShape(8.dp),
//                colors = ButtonColors(
//                    JobButtonColor,
//                    PrimaryColor,
//                    Color.Unspecified,
//                    Color.Unspecified
//                ),
//                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
//            ) {
//                Text(
//                    "Java Script", style = TextStyle(
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium
//                    )
//                )
//            }
//
//            Button(
//                modifier = Modifier,
//                onClick = {},
//                shape = RoundedCornerShape(8.dp),
//                colors = ButtonColors(
//                    JobButtonColor,
//                    PrimaryColor,
//                    Color.Unspecified,
//                    Color.Unspecified
//                ),
//                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
//            ) {
//                Text(
//                    "Java", style = TextStyle(
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium
//                    )
//                )
//            }
//            Button(
//                modifier = Modifier.weight(1f),
//                onClick = {},
//                shape = RoundedCornerShape(8.dp),
//                colors = ButtonColors(
//                    JobButtonColor,
//                    PrimaryColor,
//                    Color.Unspecified,
//                    Color.Unspecified
//                ),
//                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
//            ) {
//                Text(
//                    "Bootstrap", style = TextStyle(
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Medium
//                    )
//                )
//            }
//
//        }
//    }
//
//}


@Composable
fun DetailsSection(jobDetails: Job) {
    Section("Details")

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        DetailsSectionCardItem("Job Type", jobDetails.employmentType ?: "100\$ - 250\$")
        DetailsSectionCardItem("Work Field", jobDetails.workField.name ?: "Information Technology")
        DetailsSectionCardItem(
            "Country of Employment",
            jobDetails.countryOfEmployment.name ?: "Kuwait", imageUrl = jobDetails.countryOfEmployment.countryImage
        )
        DetailsSectionCardItem("Salary / Wage", jobDetails.salary ?: "2.5K - 5k KWD / Month")
        DetailsSectionCardItem(
            "Required Experience",
            jobDetails.experienceYear.name ?: "2 - 5 Years"
        )
    }


}

@Composable
fun DetailsSectionCardItem(cardTitle: String, cardInfo: String, imageUrl: String? = null) {
    Card(
        modifier = Modifier.background(JobCardColor),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row() {
            Text(
                cardTitle,
                modifier = Modifier.weight(1f).padding(vertical = 15.dp, horizontal = 16.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = PrimaryColor
                )
            )
            if (cardTitle == "Country of Employment" || cardTitle == "Country") {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    KamelImage(
                        { asyncPainterResource(data = "$imageUrl") },
                        contentDescription = "CountryFlag",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(30.dp).shadow(0.dp, CircleShape, true),
                        onFailure = { exception ->
                            println(" onFailure Load Country Flag ${exception.message}")

                            Image(
                                painter = painterResource(Res.drawable.pure_company),
                                contentDescription = "CountryFlag",
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center,
                                modifier = Modifier.size(30.dp).shadow(0.dp, CircleShape, true)
                            )

                        })


                    Text(
                        cardInfo,
                        modifier = Modifier.padding(
                            top = 15.dp,
                            bottom = 15.dp,
                            start = 10.dp,
                            end = 16.dp
                        ),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black, textAlign = TextAlign.End
                        )
                    )

                }
            } else
                Text(
                    cardInfo,
                    modifier = Modifier.weight(1f).padding(vertical = 15.dp, horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black, textAlign = TextAlign.End
                    )
                )

        }
    }
}

@Composable
fun JobDetailsItem(jobDetails: Job, onShareClick: () -> Unit, onItemClick: () -> Unit) {
    var visibile by remember { mutableStateOf(true) }
//    var visibile by remember { mutableStateOf(jobDetails.isFavorite) }
    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 25.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Card(
            modifier = Modifier.background(JobCardColor),
            onClick = onItemClick,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 14.dp, top = 12.dp, bottom = 16.dp, end = 5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(Res.drawable.earth),
                        tint = Color.Unspecified,
                        contentDescription = ""
                    )
                    Text(
                        jobDetails.createTime ?: "30 min",
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }
                Text(
                    jobDetails.title,
                    modifier = Modifier.padding(start = 6.dp, top = 13.dp, bottom = 7.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    KamelImage(
                        { asyncPainterResource(data = "${jobDetails.businessMan.imageUrl}") },
                        contentDescription = "Company img",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(40.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        onFailure = { exception ->
                            println(" onFailure Load Company img ${exception.message}")

                            Image(
                                painter = painterResource(Res.drawable.pure_company),
                                contentDescription = "Company img",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.shadow(0.dp, RoundedCornerShape(8.dp))
                            )

                        })


                    Column(
                        modifier = Modifier.padding(start = 5.dp),

                        ) {
                        Text(
                            jobDetails.businessMan.businessName.toString(), style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(modifier = Modifier) {
                            Text(
                                "(${jobDetails.businessMan.id})",
                                style = TextStyle(
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Normal,
                                ),
                                modifier = Modifier.padding(end = 12.dp),
                            )

                            Icon(
                                painterResource(Res.drawable.eye),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier.padding(horizontal = 4.dp)
                            )
                            Text(
                                "${jobDetails.watchesCount} K", style = TextStyle(
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            )


                        }

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = onShareClick) {
                            Icon(
                                painterResource(Res.drawable.share),
                                contentDescription = "",
                                tint = Color.Unspecified,
                            )

                        }
                        Crossfade(
                            targetState = visibile, label = "icon_crossfade", animationSpec = tween(
                                durationMillis = 600,
                                delayMillis = 200,
                                easing = FastOutLinearInEasing
                            )
                        ) { state ->

                            IconButton(onClick = ({
                                visibile = !visibile

                            })) {
                                Icon(
                                    painter = painterResource(
                                        if (state) {
                                            Res.drawable.save

                                        } else {
                                            Res.drawable.saved

                                        }
                                    ),
                                    contentDescription = "",
                                    tint = Color.Unspecified,

                                    )

                            }

                        }
                    }


                }
            }
        }
        Row(modifier = Modifier.padding(horizontal = 19.dp)) {
            Icon(
                painter = painterResource(Res.drawable.job_star2),
                tint = Color.Unspecified,
                contentDescription = ""
            )
            Icon(
                modifier = Modifier.padding(horizontal = 5.dp),
                painter = painterResource(Res.drawable.job_star),
                tint = Color.Unspecified,
                contentDescription = ""
            )
            Icon(
                painter = painterResource(Res.drawable.job_star1),
                tint = Color.Unspecified,
                contentDescription = ""
            )
        }

    }


}