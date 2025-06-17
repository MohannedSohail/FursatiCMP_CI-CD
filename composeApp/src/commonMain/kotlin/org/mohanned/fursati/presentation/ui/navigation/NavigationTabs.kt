// الحل الكامل - تعديل NavigationTabs.kt
package org.mohanned.fursati.presentation.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.painterResource
import org.mohanned.fursati.presentation.ui.bookmark.BookmarkScreen
import org.mohanned.fursati.presentation.ui.companyDetails.CompanyDetailsScreen
import org.mohanned.fursati.presentation.ui.faqs.FaqsScreen
import org.mohanned.fursati.presentation.ui.help.HelpScreen
import org.mohanned.fursati.presentation.ui.home.HomeScreen
import org.mohanned.fursati.presentation.ui.profile.ProfileScreen
import org.mohanned.fursati.presentation.ui.settings.Settings
import org.mohanned.fursati.utils.NavigationTabIndex.BOOKMARK_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.HOME_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.PROFILE_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.SETTINGS_TAB_INDEX
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.TopBar

// Home Tab مع Navigator
object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Jobs"
            val icon = rememberVectorPainter(Icons.Default.Work)

            return remember {
                TabOptions(
                    index = HOME_TAB_INDEX,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        // استخدام Navigator داخل التاب للتنقل إلى JobDetails
        val navigator = LocalNavigator.currentOrThrow

        HomeScreen()
    }
}

// Bookmark Tab
object BookmarkTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Bookmark"
            val icon = rememberVectorPainter(Icons.Default.BookmarkAdd)

            return remember {
                TabOptions(
                    index = BOOKMARK_TAB_INDEX,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        BookmarkScreen()
//        Button(
//            onClick = { navigator.push(FaqsScreen()) },
//            modifier = Modifier.fillMaxWidth().padding(30.dp)
//        ) {
//            Text("Go to Detail (Hide Bottom Nav)")
//        }

//        Navigator(BookmarkScreen()) { navigator ->
//            navigator.lastItem.Content()
//        }
    }
}

// Profile Tab
object ProfileTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Default.Person)

            return remember {
                TabOptions(
                    index = PROFILE_TAB_INDEX,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        ProfileScreen()
//        CompanyDetailsScreen()
//        Navigator(ProfileScreen()) { navigator ->
//            navigator.lastItem.Content()
//        }
    }
}

// Settings Tab
object SettingsTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Settings"
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    index = SETTINGS_TAB_INDEX,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Settings(onClick = ({ navigator.push(FaqsScreen()) }))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var showBottomBar by remember { mutableStateOf(true) }
    var showTopBar by remember { mutableStateOf(true) }

    TabNavigator(HomeTab) { tabNavigator ->
        Navigator(HomeTab) { navigator ->

            val topBarTitle = when (tabNavigator.current.options.title) {
                "Jobs" -> "Fursati"
                "Bookmark" -> "Bookmark"
                "Settings" -> "Settings"
                else -> "Profile"
            }
            Scaffold(
                topBar = {
                    AnimatedVisibility(
                        visible = showTopBar,
                        enter = slideInVertically(initialOffsetY = { it }),
                    ){
                    TopBar(topBarTitle)}
                },

                content = {
                    if (navigator.lastItem is Tab) {
                        CurrentTab() // This will display the currently selected tab
                    } else {
                        CurrentScreen() // This will display the DetailScreen or any other non-tab screen
                    }
                },
                bottomBar = {
                    AnimatedVisibility(
                        visible = showBottomBar,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it })
                    ) {
                        NavigationBar(containerColor = PrimaryColor) {
                            TabNavigationItem(HomeTab, tabNavigator)
                            TabNavigationItem(BookmarkTab, tabNavigator)
                            TabNavigationItem(SettingsTab, tabNavigator)
                            TabNavigationItem(ProfileTab, tabNavigator)
                        }
                    }
                }
            )

            DisposableEffect(navigator.lastItem) {
                showBottomBar = when (navigator.lastItem) {
                    is HomeTab, is BookmarkTab, is SettingsTab, is ProfileTab -> true
                    else -> false
                }
                showTopBar = when (navigator.lastItem) {
                    is HomeTab, is BookmarkTab, is SettingsTab, is ProfileTab -> true
                    else -> false
                }
                onDispose { }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(
    tab: Tab,
    tabNavigator: TabNavigator
) {
    val isSelected = tabNavigator.current.key == tab.key

    NavigationBarItem(
        selected = isSelected,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(
                    painter = painter,
                    contentDescription = tab.options.title
                )
            }
        },
        label = {
            Text(
                text = tab.options.title,
                maxLines = 1,
                fontSize = 12.sp
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            unselectedIconColor = Color.White.copy(alpha = 0.7f),
            unselectedTextColor = Color.White.copy(alpha = 0.7f),
            indicatorColor = Color.White.copy(alpha = 0.2f)
        )
    )
}