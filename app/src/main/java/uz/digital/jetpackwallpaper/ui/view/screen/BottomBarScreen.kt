package uz.digital.jetpackwallpaper.ui.view.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Home : BottomBarScreen(
        route = "HOME",
        icon = Icons.Filled.Home,
        title = "Home"
    )

    object Search : BottomBarScreen(
        route = "SEARCH",
        icon = Icons.Filled.Search,
        title = "Search"
    )

    object Favorite : BottomBarScreen(
        route = "FAVORITE",
        icon = Icons.Outlined.FavoriteBorder,
        title = "Favorite"
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        icon = Icons.Outlined.Person,
        title = "Profile"
    )
}