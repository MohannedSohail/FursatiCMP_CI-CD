// الحل الكامل - تعديل NavigationTabs.kt
package org.mohanned.fursati.presentation.ui.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import org.mohanned.fursati.presentation.ui.bookmark.BookmarkScreen
import org.mohanned.fursati.presentation.ui.companyDetails.CompanyDetailsScreen
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
        Navigator(HomeScreen()) { navigator ->
            SlideTransition(navigator)
        }
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
        Navigator(BookmarkScreen()) { navigator ->
            navigator.lastItem.Content()
        }
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
        CompanyDetailsScreen()
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
        Navigator(Settings()) { navigator ->
            navigator.lastItem.Content()
        }
    }
}

class MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(HomeTab) { tabNavigator ->
            val currentTab = tabNavigator.current
            val navigator = LocalNavigator.current

            val topBarTitle = when (currentTab.options.title) {
                "Jobs" -> "Fursati"
                "Bookmark" -> "Bookmark"
                "Settings" -> "Settings"
                else -> "Profile"
            }

            val showBottomBar = remember(navigator?.lastItem) {
                // إخفاء Bottom Bar في الشاشات العميقة
                navigator?.size == 1 // فقط في الشاشة الرئيسية لكل تاب
            }

            println("navigator tabs ${navigator!!.lastItem.key}")
            println("navigator size ${navigator.lastItem}")
            println("navigator tabNavigator ${tabNavigator.current.key}")
            println("navigator showBottomBar ${showBottomBar}")

            Scaffold(
                topBar = {
                    TopBar(topBarTitle)
                },
                bottomBar = {
                    if (currentTab.options.index == HOME_TAB_INDEX || currentTab.options.index == BOOKMARK_TAB_INDEX || currentTab.options.index == PROFILE_TAB_INDEX || currentTab.options.index == SETTINGS_TAB_INDEX) {
                        NavigationBar(containerColor = PrimaryColor) {
                            TabNavigationItem(HomeTab, tabNavigator)
                            TabNavigationItem(BookmarkTab, tabNavigator)
                            TabNavigationItem(SettingsTab, tabNavigator)
                            TabNavigationItem(ProfileTab, tabNavigator)
                        }

                    }

                }
            ) {
                Crossfade(
                    animationSpec = tween(300, delayMillis = 100),
                    targetState = LocalTabNavigator.current.current
                ) { tab ->
                    tab.Content()
                }
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