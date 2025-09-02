package com.example.reply.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.reply.R
import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable data object Inbox : Route
    @Serializable data object Articles : Route
    @Serializable data object DirectMessages : Route
    @Serializable data object Groups : Route
}

data class ReplyTopLevelDestination(val route: Route, val selectedIcon: Int, val unselectedIcon: Int, val iconTextId: Int)

class ReplyNavigationActions(private val navController: NavHostController) {

    fun navigateTo(destination: ReplyTopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    ReplyTopLevelDestination(
        route = Route.Inbox,
        selectedIcon = R.drawable.ic_inbox,
        unselectedIcon = R.drawable.ic_inbox,
        iconTextId = R.string.tab_inbox,
    ),
    ReplyTopLevelDestination(
        route = Route.Articles,
        selectedIcon = R.drawable.ic_article,
        unselectedIcon = R.drawable.ic_article,
        iconTextId = R.string.tab_article,
    ),
    ReplyTopLevelDestination(
        route = Route.DirectMessages,
        selectedIcon = R.drawable.ic_chat_bubble_outline,
        unselectedIcon = R.drawable.ic_chat_bubble_outline,
        iconTextId = R.string.tab_dm,
    ),
    ReplyTopLevelDestination(
        route = Route.Groups,
        selectedIcon = R.drawable.ic_group,
        unselectedIcon = R.drawable.ic_group,
        iconTextId = R.string.tab_groups,
    ),

)
