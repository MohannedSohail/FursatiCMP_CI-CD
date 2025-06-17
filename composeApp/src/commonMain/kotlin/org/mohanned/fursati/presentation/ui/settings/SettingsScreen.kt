package org.mohanned.fursati.presentation.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.call
import fursaticmp.composeapp.generated.resources.faqs
import fursaticmp.composeapp.generated.resources.help_feedback
import fursaticmp.composeapp.generated.resources.job_pref
import fursaticmp.composeapp.generated.resources.language_pref
import fursaticmp.composeapp.generated.resources.notification_settings
import fursaticmp.composeapp.generated.resources.privacy
import fursaticmp.composeapp.generated.resources.pure_company
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.presentation.ui.faqs.FaqsScreen
import org.mohanned.fursati.presentation.ui.jobDetails.Section
import org.mohanned.fursati.utils.theme.JobCardColor
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.theme.SwitchEnabledColor
import org.mohanned.fursati.utils.views.ActionRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(onClick: () -> Unit)  {
    val navigator = LocalNavigator.current
    val privacySheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showPrivacySheet by remember { mutableStateOf(false) }

    var showNotificationSheet by remember { mutableStateOf(false) }

    val notificationSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showLanguageSheet by remember { mutableStateOf(false) }

    val languageSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var englishLanguageIsChecked by remember { mutableStateOf(true) }
    var arabicLanguageIsChecked by remember { mutableStateOf(false) }
    var notificationIsChecked by remember { mutableStateOf(false) }
    MaterialTheme {
        Box {
            Scaffold {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(vertical = 100.dp, horizontal = 20.dp)
                ) {
                    Section("General Settings")

                    Spacer(modifier = Modifier.height(22.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        SettingsCard(
                            onClick = ({}),
                            painterResource(Res.drawable.job_pref),
                            "Job Preference Country"
                        )
                        SettingsCard(onClick, painterResource(Res.drawable.faqs), "FAQs")

                        SettingsCard(
                            onClick = ({}),
                            painterResource(Res.drawable.help_feedback),
                            "Help & Feedback"
                        )
                        SettingsCard(
                            onClick = ({
                                showPrivacySheet = true
                            }),
                            painterResource(Res.drawable.privacy),
                            "Privacy Policy"
                        )
                        SettingsCard(
                            onClick = ({ showLanguageSheet = true }),
                            painterResource(Res.drawable.language_pref),
                            "Language Prefrence"
                        )
                        SettingsCard(
                            onClick = ({ showNotificationSheet = true }),
                            painterResource(Res.drawable.notification_settings),
                            "Notification Settings"
                        )
                    }
                }

            }

            if (showPrivacySheet) {
                ModalBottomSheet(
                    onDismissRequest = { showPrivacySheet = false },
                    sheetState = privacySheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White,
                ) {
                    privacySheetContent()

                }
            }

            if (showLanguageSheet) {

                ModalBottomSheet(
                    onDismissRequest = { showLanguageSheet = false },
                    sheetState = languageSheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White,
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Language Prefrence",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = PrimaryColor
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth().shadow(0.dp, RoundedCornerShape(12.dp), true)
                                .clickable {
                                    arabicLanguageIsChecked = true
                                    englishLanguageIsChecked = false
                                }
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.pure_company),
                                contentDescription = "label",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))
                            Text("العربية", modifier = Modifier.weight(1f), fontSize = 16.sp)
                            AnimatedVisibility(visible = arabicLanguageIsChecked) {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = "Go",
                                    tint = PrimaryColor
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().shadow(0.dp, RoundedCornerShape(12.dp), true)
                                .clickable {
                                    arabicLanguageIsChecked = false
                                    englishLanguageIsChecked = true

                                }
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.call),
                                contentDescription = "label",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))
                            Text("English", modifier = Modifier.weight(1f), fontSize = 16.sp)
                            AnimatedVisibility(visible = englishLanguageIsChecked) {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = "Go",
                                    tint = PrimaryColor
                                )
                            }
                        }


                        Spacer(modifier = Modifier.height(16.dp))


                    }
                }

            }
            if (showNotificationSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showNotificationSheet = false },
                    sheetState = notificationSheetState,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    containerColor = Color.White,
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "Notification Settings",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            color = PrimaryColor
                        )

                        Spacer(modifier = Modifier.height(22.dp))

                        Card(
                            modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(JobCardColor).padding(horizontal = 16.dp, vertical = 16.dp),
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().background(JobCardColor),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    "General Push Notifications",
                                    modifier = Modifier.weight(1f),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Switch(
                                    notificationIsChecked,
                                    onCheckedChange = {
                                        notificationIsChecked = !notificationIsChecked
                                    },
                                    modifier = Modifier,
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = PrimaryColor,
                                        checkedTrackColor = SwitchEnabledColor,
                                        checkedBorderColor = SwitchEnabledColor,
                                        uncheckedThumbColor = Color.Gray,
                                        uncheckedTrackColor = Color.LightGray,
                                        uncheckedBorderColor = Color.LightGray,
                                    ),
                                )
                            }

                            Text(
                                "Recieve general updates and notifications",
                                modifier = Modifier.fillMaxWidth().background(JobCardColor),
                                fontSize = 14.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))


                    }
                }
            }

        }
    }

}

@Composable
private fun privacySheetContent() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Privacy Policy",
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

@Composable
fun SettingsCard(onClick: () -> Unit, icon: Any = {}, label: String) {
    Card(
        modifier = Modifier.background(JobCardColor),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (icon is Painter) {
                Icon(
                    icon,
                    contentDescription = label,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            } else if (icon is ImageVector) {
                Icon(
                    icon,
                    contentDescription = label,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))
            Text(label, modifier = Modifier.weight(1f), fontSize = 14.sp)
            Icon(Icons.Default.ChevronRight, contentDescription = "Go")
        }
    }
}
