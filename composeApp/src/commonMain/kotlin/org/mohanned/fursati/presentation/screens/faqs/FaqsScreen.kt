package org.mohanned.fursati.presentation.screens.faqs

import FAQ
import Terms
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import org.mohanned.fursati.data.repository.FursatiRepository
import org.mohanned.fursati.domain.model.UiState
import org.mohanned.fursati.presentation.screens.home.JobItem
import org.mohanned.fursati.presentation.screens.jobDetails.JobDetails
import org.mohanned.fursati.presentation.screens.settings.SettingsCard
import org.mohanned.fursati.presentation.viewmodels.FursatiViewModel
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

        val viewModel = remember { FursatiViewModel(FursatiRepository()) }
        val faqsState by viewModel.faqsState.collectAsState()


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

                        when (faqsState) {
                            is UiState.Error -> {
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

                            UiState.Loading -> Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                LinearProgressIndicator(color = PrimaryColor)
                            }

                            is UiState.Success<List<FAQ>> -> {
                                val faqs = (faqsState as UiState.Success<List<FAQ>>).data

                                LazyColumn(
                                    modifier = Modifier.fillMaxWidth().height(500.dp).padding(bottom = 20.dp)
                                ) {
                                    items(faqs) {faq->
                                        SettingsCard(
                                            onClick = ({ showAboutFursaSheet = true }),
                                            label = faq.title
                                        )
                                        Spacer(modifier = Modifier.height(15.dp))

                                    }
                                }
                            }
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