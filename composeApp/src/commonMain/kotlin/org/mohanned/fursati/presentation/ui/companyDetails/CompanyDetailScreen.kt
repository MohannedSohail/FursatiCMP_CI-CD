package org.mohanned.fursati.presentation.ui.companyDetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.call
import fursaticmp.composeapp.generated.resources.company_rectangle
import fursaticmp.composeapp.generated.resources.pure_company
import fursaticmp.composeapp.generated.resources.sms
import fursaticmp.composeapp.generated.resources.whatsapp_square
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.presentation.ui.home.JobItem
import org.mohanned.fursati.presentation.ui.jobDetails.DetailsSectionCardItem
import org.mohanned.fursati.presentation.ui.jobDetails.JobDetails
import org.mohanned.fursati.presentation.ui.jobDetails.Section
import org.mohanned.fursati.utils.theme.BtnShadowColor
import org.mohanned.fursati.utils.theme.JobCardColor
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.theme.ReadMoreBtnColor
import org.mohanned.fursati.utils.views.ActionRow
import org.mohanned.fursati.utils.views.RoundedCornerTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CompanyDetailsScreen() {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val bioSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val LoginSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showLoginSheet by remember { mutableStateOf(false) }

    var showSheet by remember { mutableStateOf(false) }
    var showBioSheet by remember { mutableStateOf(false) }

    MaterialTheme {
        Box() {
            Scaffold(
                topBar = {
                    RoundedCornerTopBar("Back", true, onClick = ({
                        showSheet = true
                    }))
                },
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(
                        top = 90.dp,
                        bottom = 30.dp,
                        start = 20.dp,
                        end = 20.dp,
                    )
                ) {

                    CompanyInfoSection()
                    DetailsSection()
                    BioDescriptionSection(readMoreClick = ({
                       // showBioSheet = true
                        showLoginSheet=true

                    }))
                    RecentJobsSection()


                }

            }

            if (showSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Take Action",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = PrimaryColor
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        ActionRow(painterResource(Res.drawable.call), "Call")
                        Spacer(modifier = Modifier.height(8.dp))
                        ActionRow(painterResource(Res.drawable.sms), "Send SMS")
                        Spacer(modifier = Modifier.height(8.dp))
                        ActionRow(painterResource(Res.drawable.whatsapp_square), "WhatsApp")

                      //  Spacer(modifier = Modifier.height(16.dp))





//                        ElevatedButton(
//                            modifier = Modifier.align(Alignment.CenterHorizontally),
//                            onClick = { showSheet = false },
//                            shape = RoundedCornerShape(30.dp),
//                            colors = ButtonColors(
//                                PrimaryColor.copy(0.5f),
//                                Color.White,
//                                Color.Unspecified,
//                                Color.Unspecified
//                            ),
//
//                            contentPadding = PaddingValues(vertical = 10.dp, horizontal = 40.dp)
//                        ) {
//
//
//                            Text(
//                                "Close", style = TextStyle(
//                                    fontSize = 16.sp,
//                                    fontWeight = FontWeight.SemiBold
//                                )
//                            )
//
//
//                        }

//                        Button(
//                            onClick = { showSheet = false },
//                            modifier = Modifier.align(Alignment.CenterHorizontally)
//                        ) {
//                            Text("Close")
//                        }
                    }
                }
            }
            if (showLoginSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showLoginSheet = false },
                    sheetState = LoginSheetState,
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

            if (showBioSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBioSheet = false },
                    sheetState = bioSheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "BIO",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = PrimaryColor
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        Text(
                            "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n" +
                                    "\n" +
                                    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n" +
                                    "\n" +
                                    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n" +
                                    "\n" +
                                    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n"+
                                    "\n"+
                                    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n",
                            style = TextStyle(fontSize = 16.sp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(16.dp))


                    }
                }
            }

        }

    }
}


@Composable
fun DetailsSection() {
    Section("Details")

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        DetailsSectionCardItem("Type of Business", "Web Development")
        DetailsSectionCardItem("No. of Employees", "1500+")
        DetailsSectionCardItem("Country", "Kuwait")


    }


}

@Composable
fun BioDescriptionSection(readMoreClick: () -> Unit) {

    Section("BIO")
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
            onClick = readMoreClick,
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
fun RecentJobsSection() {
    val navigator = LocalNavigator.currentOrThrow
    Section("Recent Jobs")
    LazyColumn(
        modifier = Modifier.height(500.dp).padding(bottom = 20.dp)
    ) {
        items(20) {
            JobItem(
                onClick = ({ navigator.push(JobDetails()) }),
                onShareIconClick = ({}),
            )


        }
    }


}


@Composable
fun CompanyInfoSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = painterResource(Res.drawable.company_rectangle),
                contentDescription = "Company Rectangle",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(150.dp)
                    .shadow(0.dp, RoundedCornerShape(20.dp), true)

            )


            Image(
                painter = painterResource(Res.drawable.pure_company),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                alignment = Alignment.BottomCenter,
                modifier = Modifier.size(60.dp)
                    .offset(x = 0.dp, y = 30.dp)
                    .shadow(1.dp, CircleShape, true, Color.Black, Color.Black)
            )

        }

        Text(
            "PURE for IT Solutions",
            modifier = Modifier.padding(top = 40.dp, bottom = 5.dp),
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            "(1012416)",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        )

    }
}


