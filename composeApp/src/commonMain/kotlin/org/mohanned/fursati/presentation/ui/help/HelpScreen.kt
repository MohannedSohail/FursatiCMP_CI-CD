package org.mohanned.fursati.presentation.ui.help

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.addimages
import io.kamel.core.utils.URI
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.presentation.ui.settings.SettingsCard
import org.mohanned.fursati.utils.theme.BtnShadowColor
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.RoundedCornerTopBar

class HelpScreen(): Screen {
    @Composable
    override fun Content() {

        var fullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var subject by remember { mutableStateOf("") }
        var details by remember { mutableStateOf("") }

        var selectedMultiImages by remember {
            mutableStateOf<List<URI>>(emptyList())
        }
        val context = LocalGraphicsContext.current


//    val multiplePhotosPickerLuncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
//            selectedMultiImages = it
//        }
        Scaffold(
            topBar = { RoundedCornerTopBar("Help & Feedback", false) }
        ) {
            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState(), true)
                    .padding(vertical = 100.dp, horizontal = 20.dp)
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system",
                    style = TextStyle(
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xff444444)
                    )
                )



                OutlinedTextField(
                    value = fullName,
                    onValueChange = {
                        fullName = it
                    },
                    label = { Text("Full Name") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    shape = RoundedCornerShape(16.dp),
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                )
                OutlinedTextField(
                    value = subject,
                    onValueChange = {
                        subject = it
                    },
                    label = { Text("Subject") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    shape = RoundedCornerShape(16.dp),
                )

                OutlinedTextField(
                    value = details,
                    onValueChange = {
                        details = it
                    },
                    label = { Text("Details") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = false,
                    minLines = 5,
                    shape = RoundedCornerShape(16.dp),
                )


                Card(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp).drawBehind {
                        drawRoundRect(
                            color = PrimaryColor,
                            style = Stroke(
                                width = 4f,
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(25f, 25f), 5f)
                            )
                            ,
                            cornerRadius = CornerRadius(x = 28f, y = 28f)
                        )
                    }.padding(1.dp)
                    ,
                    colors = CardDefaults.cardColors(containerColor = Color(0xffEDFAFA)),
                    onClick = ({}),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 25.dp, horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.addimages),
                            contentDescription = ""
                        )
                        Text(
                            "Upload The Offer Images/Videos up to 5 files",
                            textAlign = TextAlign.Center
                        )
                    }
                }


                ElevatedButton(
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp, bottom = 40.dp).shadow(
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
                        "Send", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )


                }


            }


        }
    }

}