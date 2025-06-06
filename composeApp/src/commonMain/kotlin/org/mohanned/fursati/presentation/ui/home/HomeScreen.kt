package org.mohanned.fursati.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.utils.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScreen() {

    Scaffold(

        topBar = { TopBar() },
        bottomBar = { BottomAppBar(contentColor = Color.White, containerColor = PrimaryColor) {

        } }

    ) {

        Column(modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)) {

            Header()

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                "Fursati", style = TextStyle(
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
    )
}

@Composable
fun Header() {
    Text(
        "Welcome", style = TextStyle(
            color = Color(0xffA0B6B4),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
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