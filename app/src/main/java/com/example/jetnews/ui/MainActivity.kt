package com.example.jetnews.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import com.example.jetnews.PathIndex.HOME
import com.example.jetnews.PathIndex.MAIN_COMPOSE
import com.therouter.TheRouter
import com.therouter.brick.annotation.DataProvider
import com.therouter.compose.compose
import com.therouter.router.Navigator
import com.therouter.router.Route

@Route(path = HOME)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            TheRouter.build(MAIN_COMPOSE).compose(this)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@DataProvider(path = MAIN_COMPOSE, fieldName = "widthSizeClass")
fun makeSizeClass(navigator: Navigator): WindowWidthSizeClass {
    return calculateWindowSizeClass(navigator.exContext as Activity).widthSizeClass
}