package org.mohanned.fursati.presentation.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.faqs
import fursaticmp.composeapp.generated.resources.help_feedback
import fursaticmp.composeapp.generated.resources.job_pref
import fursaticmp.composeapp.generated.resources.language_pref
import fursaticmp.composeapp.generated.resources.notification_settings
import fursaticmp.composeapp.generated.resources.privacy
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.presentation.ui.jobDetails.Section
import org.mohanned.fursati.utils.views.ActionRow


class Settings() : Screen {
    @Composable
    @Preview
    override fun Content() {
        MaterialTheme {
            Scaffold {
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)
                ) {
                    Section("General Settings")

                    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                        ActionRow(painterResource(Res.drawable.job_pref), "Job Preference Country")
                        ActionRow(painterResource(Res.drawable.faqs), "FAQs")
                        ActionRow(painterResource(Res.drawable.help_feedback), "Help & Feedback")
                        ActionRow(painterResource(Res.drawable.privacy), "Privacy Policy")
                        ActionRow(painterResource(Res.drawable.language_pref), "Language Prefrence")
                        ActionRow(
                            painterResource(Res.drawable.notification_settings),
                            "Notification Settings"
                        )
                    }
                }

            }
        }
    }
}
