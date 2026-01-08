/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.brick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetnews.PathIndex.BRICK
import com.example.jetnews.PathIndex.HOME_COMPOSE
import com.example.jetnews.PathIndex.MAIN_COMPOSE
import com.example.jetnews.R
import com.therouter.router.Route

@Route(path = BRICK)
class BrickActivity : FragmentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val demoData = ArrayList<String>()
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)
        demoData.add(MAIN_COMPOSE)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(this, demoData)
    }
}
