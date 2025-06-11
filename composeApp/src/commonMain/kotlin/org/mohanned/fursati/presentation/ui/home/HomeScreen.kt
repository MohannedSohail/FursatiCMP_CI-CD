package org.mohanned.fursati.presentation.ui.home

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.instagram
import fursaticmp.composeapp.generated.resources.whatsapp_square
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.presentation.ui.jobDetails.JobDetails
import org.mohanned.fursati.utils.theme.BtnShadowColor
import org.mohanned.fursati.utils.theme.PrimaryColor


class HomeScreen() : Screen {
    @Composable
    @Preview
    @OptIn(ExperimentalMaterial3Api::class)

    override fun Content() {
        val navigator = LocalNavigator.current
        var showShareSheet by remember { mutableStateOf(false) }

        val ShareSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )


        MaterialTheme {
            Box {
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)
                ) {

                    Header(onClick = ({

                        navigator?.push(JobDetails())
                        println("navigator${navigator?.size}")

                    }))

                    LazyColumn(modifier = Modifier.padding(bottom = 30.dp)) {
                        items(20) {
                            JobItem(
                                onClick = ({ navigator?.replace(JobDetails()) }),
                                onShareIconClick = ({
                                    showShareSheet = true

                                }),
                            )

                        }
                    }

                }
            }

            if (showShareSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showShareSheet = false },
                    sheetState = ShareSheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White,
                ) {
                    shareBottomSheetContent()
                }
            }

        }

    }

}

@Composable
private fun shareBottomSheetContent() {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 40.dp)) {
        Text(
            text = "Share via",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = PrimaryColor
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.instagram),
                    contentDescription = "gmail",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(45.dp)
                )
                Text("Gmail", fontSize = 14.sp)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.whatsapp_square),
                    contentDescription = "Facebook",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(45.dp)
                )
                Text("Facebook", fontSize = 14.sp)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.instagram),
                    contentDescription = "Messenger",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(45.dp)
                )
                Text("Messenger", fontSize = 14.sp)
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.whatsapp_square),
                    contentDescription = "Whats app",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(45.dp)
                )
                Text("Whats app", fontSize = 14.sp)
            }
        }

    }
}


@Composable
fun Header(onClick: () -> Unit) {
    Text(
        "Welcome", style = TextStyle(
            color = Color(0xffA0B6B4),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,

            ),
        modifier = Modifier.clickable(onClick = onClick)
    )
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        "Mr/Mam Visitor",
        style = TextStyle(
            color = PrimaryColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}