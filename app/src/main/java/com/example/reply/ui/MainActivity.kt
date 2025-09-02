package com.example.reply.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.reply.PathIndex
import com.google.accompanist.adaptive.calculateDisplayFeatures
import com.therouter.TheRouter
import com.therouter.compose.compose
import com.therouter.compose.withComposableObject
import com.therouter.setContext

class MainActivity : ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        TheRouter.init(this)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContext(this.applicationContext)

        setContent {
            // TheRouter 可以通过动态修改路由表，达到修改首页需要展示的内容
            TheRouter.build(PathIndex.SCREEN)
                .withComposableObject("content"){
                    val windowSize = calculateWindowSizeClass(this)
                    val displayFeatures = calculateDisplayFeatures(this)
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    ReplyApp(
                        windowSize = windowSize,
                        displayFeatures = displayFeatures,
                        replyHomeUIState = uiState,
                        closeDetailScreen = {
                            viewModel.closeDetailScreen()
                        },
                        navigateToDetail = { emailId, pane ->
                            viewModel.setOpenedEmail(emailId, pane)
                        },
                        toggleSelectedEmail = { emailId ->
                            viewModel.toggleSelectedEmail(emailId)
                        },
                    )
                }.compose()
        }
    }
}