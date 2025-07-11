package org.mohanned.fursati.presentation.ui.jobDetails

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import fursaticmp.composeapp.generated.resources.earth
import fursaticmp.composeapp.generated.resources.eye
import fursaticmp.composeapp.generated.resources.job_star
import fursaticmp.composeapp.generated.resources.job_star1
import fursaticmp.composeapp.generated.resources.job_star2
import fursaticmp.composeapp.generated.resources.pure_company
import fursaticmp.composeapp.generated.resources.save
import fursaticmp.composeapp.generated.resources.saved
import fursaticmp.composeapp.generated.resources.share
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.presentation.ui.companyDetails.CompanyDetailsScreen
import org.mohanned.fursati.utils.theme.BtnShadowColor
import org.mohanned.fursati.utils.theme.JobButtonColor
import org.mohanned.fursati.utils.theme.JobCardColor
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.theme.ReadMoreBtnColor
import org.mohanned.fursati.utils.views.RoundedCornerTopBar
import org.mohanned.fursati.utils.views.shareBottomSheetContent


class JobDetails() : Screen {

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



        Box {
            Scaffold(

                topBar = { RoundedCornerTopBar("Back", onClick = ({})) },


                ) {

                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState(), true)
                        .padding(
                            top = 90.dp,
                            bottom = 50.dp,
                            start = 20.dp,
                            end = 20.dp,
                        )
                ) {

                    JobDetailsItem(onShareClick = ({
                        showShareSheet=true
                    }), onItemClick = ({navigator.push(CompanyDetailsScreen())}))
                    DetailsSection()
                    SkillsSection()
                    JobDescriptionSection(onReadMoreClick = ({
                        showJobDescriptionSheet=true
                    }))
                    CandidateRequirementsSection()
                    ApplyBtn(onApplyClick = ({
                        showJobDescriptionSheet=true

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
                                RoundedCornerShape(12.dp), true, BtnShadowColor, BtnShadowColor
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
                            border = BorderStroke(1.dp,PrimaryColor),
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
fun CandidateRequirementsSection() {
    Section("Candidate Requirements")

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        DetailsSectionCardItem("Nationality", "Kuwait, Palestinian, Indian")
        DetailsSectionCardItem("Country Residence", "Egypt , Jordan, Indian")
        DetailsSectionCardItem("Gender", "All")
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
fun JobDescriptionSection(onReadMoreClick:() -> Unit) {

    Section("Job Description")
    Card(
        modifier = Modifier.background(JobCardColor),
        shape = RoundedCornerShape(8.dp)
    ) {

        Text(
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur",
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
fun SkillsSection() {
    Section("Skills")
    Card(
        modifier = Modifier.background(JobCardColor),
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Button(
                modifier = Modifier.weight(1f),
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
                    "Java Script", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Button(
                modifier = Modifier,
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
                    "Java", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
            Button(
                modifier = Modifier.weight(1f),
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
                    "Bootstrap", style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

        }
    }

}


@Composable
fun DetailsSection() {
    Section("Details")

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        DetailsSectionCardItem("Job Type", "100\$ - 250\$")
        DetailsSectionCardItem("Work Field", "Information Technology")
        DetailsSectionCardItem("Country of Employment", "Kuwait")
        DetailsSectionCardItem("Salary / Wage", "2.5K - 5k KWD / Month")
        DetailsSectionCardItem("Required Experience", "2 - 5 Years")
    }


}

@Composable
fun DetailsSectionCardItem(cardTitle: String, cardInfo: String) {
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
                    Image(
                        painter = painterResource(Res.drawable.pure_company),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier.size(30.dp).shadow(0.dp, CircleShape, true)
                    )

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
fun JobDetailsItem(onShareClick: () -> Unit,onItemClick: () -> Unit) {
    var visibile by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 25.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Card(modifier = Modifier.background(JobCardColor), onClick = onItemClick ,shape = RoundedCornerShape(20.dp)) {
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
                        "30 min",
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }
                Text(
                    "Web and Mobile Development",
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
                    Image(
                        painter = painterResource(Res.drawable.pure_company),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.shadow(0.dp, RoundedCornerShape(8.dp))
                    )

                    Column(
                        modifier = Modifier.padding(start = 5.dp),

                        ) {
                        Text(
                            "PURE for IT Solutions", style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(modifier = Modifier) {
                            Text(
                                "(1012416)",
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
                                "21 K", style = TextStyle(
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