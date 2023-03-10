package uz.digital.jetpackwallpaper.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.digital.jetpackwallpaper.ui.view.bottom.FavoriteScreen
import uz.digital.jetpackwallpaper.ui.view.bottom.HomeScreen
import uz.digital.jetpackwallpaper.ui.view.bottom.ProfileScreen
import uz.digital.jetpackwallpaper.ui.view.bottom.SearchScreen
import uz.digital.jetpackwallpaper.ui.view.home.DetailScreen
import uz.digital.jetpackwallpaper.ui.view.splash.SplashScreen
import uz.digital.jetpackwallpaper.util.Graph

fun NavGraphBuilder.splashNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = "SPLASH"
    ) {
        composable(
            route = "SPLASH"
        ) {
            SplashScreen(navHostController)
        }
    }
}

@Composable
fun MainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navHostController)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navHostController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navHostController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navHostController)
        }
        detailsNavGraph(navHostController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navHostController: NavHostController) {
    navigation(
        route = "${Graph.DETAILS}/{title}",
        startDestination = "DETAILS"
    ) {
        composable(
            route = "DETAILS",
            arguments = listOf(
                navArgument(
                    name = "title"
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            val title = it.arguments?.getString("title") ?: "No data"
            DetailScreen(navHostController = navHostController, title)
        }
    }
}