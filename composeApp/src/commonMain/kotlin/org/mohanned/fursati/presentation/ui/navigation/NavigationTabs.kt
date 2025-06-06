package org.mohanned.fursati.presentation.ui.navigation


import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.mohanned.fursati.presentation.ui.bookmark.BookmarkScreen
import org.mohanned.fursati.presentation.ui.home.HomeScreen
import org.mohanned.fursati.presentation.ui.profile.ProfileScreen
import org.mohanned.fursati.presentation.ui.settings.SettingsScreen
import org.mohanned.fursati.utils.NavigationTabIndex.BOOKMARK_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.HOME_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.PROFILE_TAB_INDEX
import org.mohanned.fursati.utils.NavigationTabIndex.SETTINGS_TAB_INDEX
import org.mohanned.fursati.utils.theme.PrimaryColor
import org.mohanned.fursati.utils.views.TopBar


// Home Tab
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
        BookmarkScreen()
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
        ProfileScreen()
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
        SettingsScreen()
    }
}

@Composable
fun MainScreen() {
    TabNavigator(HomeTab) { tabNavigator ->
        Scaffold(

            topBar = {
                TopBar(
                    if (tabNavigator.current.options.title == "Jobs") "Fursati"
                    else if (tabNavigator.current.options.title == "Bookmark") "Bookmark"
                    else if (tabNavigator.current.options.title == "Settings") "Settings"
                    else "Profile"
                )
            },

            bottomBar = {
                NavigationBar(containerColor = PrimaryColor) {
                    TabNavigationItem(HomeTab, tabNavigator)
                    TabNavigationItem(BookmarkTab, tabNavigator)
                    TabNavigationItem(SettingsTab, tabNavigator)
                    TabNavigationItem(ProfileTab, tabNavigator)

                }

            }
        ) {
            Crossfade(
                animationSpec = tween(500, delayMillis = 100),
                targetState = LocalTabNavigator.current.current
            ) { tab ->
                tab.Content()
                tab.options
            }
        }
    }
}

// 3. مكون Tab Navigation Item
@Composable
private fun RowScope.TabNavigationItem(
    tab: Tab,
    tabNavigator: TabNavigator
) {
    val isSelected = tabNavigator.current.key == tab.key

    NavigationBarItem(
        selected = isSelected,
        onClick = { tabNavigator.current = tab },
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


class HomeDetailScreen(private val itemId: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = { navigator.pop() }
            ) {
                Text("Back to Home")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Detail Screen",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Item ID: $itemId",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

object HomeTabWithNavigation : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(HomeScreenWithNavigation()) { navigator ->
            navigator.lastItem.Content()
        }
    }
}

class HomeScreenWithNavigation : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Home Screen with Navigation",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navigator.push(HomeDetailScreen("123"))
                }
            ) {
                Text("Go to Detail")
            }
        }
    }
}
