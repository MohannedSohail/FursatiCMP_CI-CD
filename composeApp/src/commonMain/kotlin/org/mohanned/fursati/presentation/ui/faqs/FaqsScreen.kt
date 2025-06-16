package org.mohanned.fursati.presentation.ui.faqs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.faqs
import fursaticmp.composeapp.generated.resources.help_feedback
import fursaticmp.composeapp.generated.resources.job_pref
import fursaticmp.composeapp.generated.resources.language_pref
import fursaticmp.composeapp.generated.resources.notification_settings
import fursaticmp.composeapp.generated.resources.privacy
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.presentation.ui.jobDetails.Section
import org.mohanned.fursati.presentation.ui.settings.SettingsCard
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.RoundedCornerTopBar

class FaqsScreen():Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable

    override fun Content() {
        val aboutFursaSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )
        var showAboutFursaSheet by remember { mutableStateOf(false) }

        MaterialTheme {
            Box {
                Scaffold(
                    topBar = { RoundedCornerTopBar("FAQS", false) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState(), true)
                            .padding(vertical = 100.dp, horizontal = 20.dp)
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                            SettingsCard(
                                onClick = ({ showAboutFursaSheet = true }),
                                label = "What is Fursa"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "What is Benefit"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "How do post on fursa platform by using business account"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "What is Fursa"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "What is Benefit"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "How do post on fursa platform by using business account"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "What is Fursa"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "What is Benefit"
                            )
                            SettingsCard(
                                onClick = ({}),
                                label = "How do post on fursa platform by using business account"
                            )

                        }
                    }


                }

                if (showAboutFursaSheet) {
                    ModalBottomSheet(
                        onDismissRequest = { showAboutFursaSheet = false },
                        sheetState = aboutFursaSheetState,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                        containerColor = Color.White
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = "What is Fursa",
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
                                        "\n" +
                                        "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system\n" +
                                        "\n" +
                                        "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system",
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
}