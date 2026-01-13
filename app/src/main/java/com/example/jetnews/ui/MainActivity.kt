package com.example.jetnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetnews.PathIndex.HOME
import com.example.jetnews.PathIndex.MAIN_COMPOSE
import com.therouter.TheRouter
import com.therouter.compose.compose
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