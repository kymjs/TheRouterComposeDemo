package com.example.jetnews.brick

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.example.jetnews.PathIndex.BRICK
import com.example.jetnews.PathIndex.MAIN_COMPOSE
import com.example.jetnews.PathIndex.TEXT_COMPOSE
import com.example.jetnews.R
import com.therouter.TheRouter
import com.therouter.brick.annotation.DataProvider
import com.therouter.compose.ComposeViewFactory
import com.therouter.compose.compose
import com.therouter.router.Navigator
import com.therouter.router.Route

@Route(path = BRICK)
class BrickActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val view = ComposeViewFactory.makeView(this) {
            TheRouter.build(MAIN_COMPOSE).compose(this)
        }
        setContentView(view)
    }
}

@DataProvider(path = TEXT_COMPOSE)
fun make(navigator: Navigator): String {
    return navigator.getUrlWithParams()
}

@Route(path = TEXT_COMPOSE)
@Composable
fun ui(str: String) {
    Text(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
        text = str,
        style = MaterialTheme.typography.titleMedium,
    )
}