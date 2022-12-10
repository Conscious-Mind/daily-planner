package com.davidson.compose15.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.davidson.compose15.navigation.destinations.listComposable
import com.davidson.compose15.navigation.destinations.taskComposable
import com.davidson.compose15.ui.shared_vm.SharedViewModel
import com.davidson.compose15.util.Constants.LIST_SCREEN
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}