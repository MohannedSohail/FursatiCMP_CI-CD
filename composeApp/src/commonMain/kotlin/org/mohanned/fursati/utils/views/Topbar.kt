package org.mohanned.fursati.utils.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.filter
import fursaticmp.composeapp.generated.resources.notifications
import fursaticmp.composeapp.generated.resources.search
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.utils.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(screenTitle: String) {
    TopAppBar(
        title = {
            Text(
                screenTitle, style = TextStyle(
                    color = PrimaryColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )
        },

        modifier = Modifier,
//                    .clip(
//                    shape = RoundedCornerShape(
//                        bottomStart = 20.dp,
//                        bottomEnd = 20.dp
//                    )
//                ),
        // colors = TopAppBarDefaults.topAppBarColors(Color.Cyan),
        actions = {
            if (screenTitle == "Settings") {
                Icon(
                    painter = painterResource(Res.drawable.notifications),
                    contentDescription = "notifications",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)

                )

            } else {
                Row {
                    IconButton(onClick = ({})) {
                        Icon(
                            painter = painterResource(Res.drawable.search),
                            contentDescription = "search",
                            tint = Color.Unspecified

                        )
                    }
                    IconButton(onClick = ({})) {
                        Icon(
                            painter = painterResource(Res.drawable.filter),
                            contentDescription = "filter",
                            tint = Color.Unspecified

                        )
                    }
                    IconButton(onClick = ({})) {
                        Icon(
                            painter = painterResource(Res.drawable.notifications),
                            contentDescription = "notifications",
                            tint = Color.Unspecified
                        )
                    }
                }

            }
        }
    )
}
