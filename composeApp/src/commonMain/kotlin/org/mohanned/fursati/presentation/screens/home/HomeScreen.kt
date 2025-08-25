package org.mohanned.fursati.presentation.screens.home

import Job
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.mohanned.fursati.domain.model.UiState
import org.mohanned.fursati.presentation.screens.jobDetails.JobDetails
import org.mohanned.fursati.presentation.viewmodels.FursatiViewModel
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.shareBottomSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: FursatiViewModel) {
    val navigator = LocalNavigator.current
    var showShareSheet by remember { mutableStateOf(false) }

    val shareSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    val jobsState by viewModel.jobsState.collectAsState()
    LaunchedEffect(Dispatchers.IO) {
        viewModel.loadAllJobs()
        viewModel.loadTerms()
        viewModel.loadFaqs()

    }



    MaterialTheme {
        Box {
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)
            ) {

                Header()

                when (jobsState) {
                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = PrimaryColor)
                        }
                    }

                is UiState.Success -> {

                    val jobs = (jobsState as UiState.Success<List<Job>>).data

                    LazyColumn(modifier = Modifier.padding(bottom = 30.dp)) {
                        items(jobs) {job ->
                            JobItem(
                                onClick = ({ navigator?.push(JobDetails(job.id)) }),
                                onShareIconClick = ({
                                    showShareSheet = true

                                }),
                                job = job,
                            )

                        }
                    }

            }

                    is UiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Error: ${(jobsState as UiState.Error).message}",
                                    color = Color.Red,
                                    fontSize = 16.sp
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                // You could add a retry button here
                                androidx.compose.material3.Button(
                                    onClick = { viewModel.refreshJobs() }
                                ) {
                                    Text("Retry")
                                }
                            }
                        }
                    }

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

    }

}}



@Composable
fun Header() {
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        "Welcome", style = TextStyle(
            color = Color(0xffA0B6B4),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,

            ),
        modifier = Modifier
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