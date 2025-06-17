package org.mohanned.fursati.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
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
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.instagram
import fursaticmp.composeapp.generated.resources.whatsapp_square
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.presentation.ui.jobDetails.JobDetails
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.shareBottomSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navigator = LocalNavigator.current
    var showShareSheet by remember { mutableStateOf(false) }

    val shareSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )


    MaterialTheme {
        Box {
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)
            ) {

                Header()

                LazyColumn(modifier = Modifier.padding(bottom = 30.dp)) {
                    items(20) {
                        JobItem(
                            onClick = ({ navigator?.push(JobDetails()) }),
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
                sheetState = shareSheetState,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                containerColor = Color.White,
            ) {
                shareBottomSheetContent()
            }
        }

    }

}



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