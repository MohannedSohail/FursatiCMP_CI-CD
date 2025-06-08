package org.mohanned.fursati.utils.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.back_arrow
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.utils.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedCornerTopBar(screenTitle: String) {
    TopAppBar(
        title = {
            Text(
                screenTitle, style = TextStyle(
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                ),
            )
        },

        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                )
            ),
        colors = TopAppBarDefaults.topAppBarColors(PrimaryColor),

        navigationIcon = {
            IconButton(onClick = ({})) {
                Icon(
                    painter = painterResource(Res.drawable.back_arrow),
                    contentDescription = "back_arrow",
                    tint = Color.Unspecified
                )
            }

        }
    )
}
