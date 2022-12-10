package com.davidson.compose15.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.davidson.compose15.ui.screens.task_screen.TaskScreen
import com.davidson.compose15.ui.shared_vm.SharedViewModel
import com.davidson.compose15.util.Action
import com.davidson.compose15.util.Constants.TASK_ARGUMENT_KEY
import com.davidson.compose15.util.Constants.TASK_SCREEN
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(
                    durationMillis = 300
                )
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId = taskId)
        }

        val selectedTask by sharedViewModel.selectedTask.collectAsState()
        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}