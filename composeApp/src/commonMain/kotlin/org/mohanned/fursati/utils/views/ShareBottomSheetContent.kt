package org.mohanned.fursati.utils.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fursaticmp.composeapp.generated.resources.Res
import fursaticmp.composeapp.generated.resources.instagram
import fursaticmp.composeapp.generated.resources.whatsapp_square
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.utils.theme.PrimaryColor


@Composable
fun shareBottomSheetContent() {
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
