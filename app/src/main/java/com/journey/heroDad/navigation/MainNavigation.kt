package com.journey.heroDad.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.journey.heroDad.domain.model.recipes.Recipe
import com.journey.heroDad.ui.features.home.screens.DashboardScreen
import com.journey.heroDad.ui.features.settings.screens.SettingsScreen
import com.journey.heroDad.utils.ScaleTransitionDirection
import com.journey.heroDad.utils.scaleIntoContainer
import com.journey.heroDad.utils.scaleOutOfContainer

enum class NavRoute {
    HOME,
    DETAILS,
    SIMPLE_RECIPE_HOME,
    SETTINGS
}

@Composable
fun MainNavigation() {
    val mainNavController = rememberNavController()

    NavHost(mainNavController, startDestination = NavRoute.HOME.name) {
        composable(
            route = NavRoute.HOME.name,
        ) {
            DashboardScreen(navController = mainNavController)
        }
        composable(
            route = NavRoute.SIMPLE_RECIPE_HOME.name,
        ) {
            //SimpleRecipeHome(navController = mainNavController)
        }
        composable(
            route = NavRoute.DETAILS.name,
            enterTransition = {
                scaleIntoContainer()
            },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
            },
        ) {
            val recipe =
                mainNavController.previousBackStackEntry?.savedStateHandle?.get<Recipe>("recipe")

            if (recipe != null) {
                //DetailsScreen(navController = mainNavController, recipe = recipe)
            }
        }
        composable(route = NavRoute.SETTINGS.name) {
            SettingsScreen(navController = mainNavController)
        }
    }
}