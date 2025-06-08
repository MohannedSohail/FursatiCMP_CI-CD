package org.mohanned.fursati.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.mohanned.fursati.utils.theme.PrimaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScreen() {

    Scaffold(

       // topBar = { TopBar() },
//        bottomBar = { BottomAppBar(contentColor = Color.White, containerColor = PrimaryColor) {
//
//        } }

    ) {

        Column(modifier = Modifier.fillMaxSize().padding(vertical = 100.dp, horizontal = 20.dp)) {

            Header()

            LazyColumn(modifier = Modifier.padding(bottom = 30.dp)) { items(20){
                JobItem()

            } }

        }

    }
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