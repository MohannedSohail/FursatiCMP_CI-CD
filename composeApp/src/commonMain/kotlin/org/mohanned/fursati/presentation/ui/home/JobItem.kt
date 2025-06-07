package org.mohanned.fursati.presentation.ui.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.earth
import fursaticmp.composeapp.generated.resources.eye
import fursaticmp.composeapp.generated.resources.job_experiance
import fursaticmp.composeapp.generated.resources.job_star
import fursaticmp.composeapp.generated.resources.job_star1
import fursaticmp.composeapp.generated.resources.job_star2
import fursaticmp.composeapp.generated.resources.job_time
import fursaticmp.composeapp.generated.resources.job_type
import fursaticmp.composeapp.generated.resources.price
import fursaticmp.composeapp.generated.resources.pure_company
import fursaticmp.composeapp.generated.resources.save
import fursaticmp.composeapp.generated.resources.share
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.utils.theme.JobButtonColor
import org.mohanned.fursati.utils.theme.JobCardColor
import org.mohanned.fursati.utils.theme.JobLineColor
import org.mohanned.fursati.utils.theme.PrimaryColor


@Composable
@Preview

fun JobItem() {
    Box(
        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Card(modifier = Modifier.background(JobCardColor), shape = RoundedCornerShape(20.dp)) {
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
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painterResource(Res.drawable.share),
                                contentDescription = "",
                                tint = Color.Unspecified,
                            )

                        }
                        IconButton(onClick = {

                        }) {
                            Icon(
                                painterResource(Res.drawable.save),
                                contentDescription = "",
                                tint = Color.Unspecified,

                                )

                        }
                    }


                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 6.dp, end = 15.dp, top = 15.dp),
                ) {

                    ElevatedButton(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {}) {
                        Row() {
                            Icon(
                                painter = painterResource(Res.drawable.job_type),
                                tint = Color.Unspecified,
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Engineering", style = TextStyle(fontSize = 12.sp))
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    ElevatedButton(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {}) {
                        Row() {
                            Icon(
                                painter = painterResource(Res.drawable.price),
                                tint = Color.Unspecified,
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("100\$ - 250\$", style = TextStyle(fontSize = 12.sp))
                        }
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(start = 6.dp, end = 15.dp)) {

                    ElevatedButton(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {}) {
                        Row() {
                            Icon(
                                painter = painterResource(Res.drawable.job_experiance),
                                tint = Color.Unspecified,
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("3 Years", style = TextStyle(fontSize = 12.sp))
                        }
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    ElevatedButton(
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {}) {
                        Row() {
                            Icon(
                                painter = painterResource(Res.drawable.job_time),
                                tint = Color.Unspecified,
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("3 days rem.", style = TextStyle(fontSize = 12.sp))
                        }
                    }
                }

                Text(
                    "Lorem ipsum dolor sit amet, consetetur sadipsg elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur",
                    style = TextStyle(fontSize = 12.sp),
                    maxLines = 3,
                    modifier = Modifier.fillMaxWidth().padding(start = 6.dp, end = 15.dp, top = 15.dp, bottom = 12.dp)
                )


                Row(modifier = Modifier.fillMaxWidth().padding(start = 6.dp, end = 15.dp, bottom = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(modifier = Modifier,
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonColors(JobButtonColor, PrimaryColor,Color.Unspecified,Color.Unspecified),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text("Java",style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                        )
                    }
                    Button(modifier = Modifier.weight(1f),
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonColors(JobButtonColor, PrimaryColor,Color.Unspecified,Color.Unspecified),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text("Java Script",style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                        )
                    }
                    Button(modifier = Modifier.weight(1f),
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonColors(JobButtonColor, PrimaryColor,Color.Unspecified,Color.Unspecified),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Text("Bootstrap",style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                        )
                    }

                }

                Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(JobLineColor))
                Text("Expire In : 14 days ", modifier = Modifier.padding(start = 6.dp, top = 8.dp),style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
                )


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