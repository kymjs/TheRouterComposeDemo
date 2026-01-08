/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews.brick

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.example.jetnews.R

public fun makeView(
    activity: Activity,
    width: Int = activity.window.decorView.findViewById<ViewGroup>(android.R.id.content).getChildAt(0).width,
    height: Int = activity.window.decorView.findViewById<ViewGroup>(android.R.id.content).getChildAt(0).height,
    parent: CompositionContext? = null,
    content: @Composable () -> Unit,
): ViewGroup {
    val group = View.inflate(activity, R.layout.item_compose_container, null) as ViewGroup
    val composeView = ComposeView(activity).apply {
        setParentCompositionContext(parent)
        setContent(content)
        setOwners(activity)
    }
    group.addView(composeView, ViewGroup.LayoutParams(width, height))
    return group
}

/**
 * These owners are not set before AppCompat 1.3+ due to a bug, so we need to set them manually in
 * case developers are using an older version of AppCompat.
 */
private fun setOwners(activity: Activity) {
    val decorView = activity.window.decorView
    if (decorView.findViewTreeLifecycleOwner() == null && activity is LifecycleOwner) {
        decorView.setViewTreeLifecycleOwner(activity)
    }
    if (decorView.findViewTreeViewModelStoreOwner() == null && activity is ViewModelStoreOwner) {
        decorView.setViewTreeViewModelStoreOwner(activity)
    }
    if (decorView.findViewTreeSavedStateRegistryOwner() == null && activity is SavedStateRegistryOwner) {
        decorView.setViewTreeSavedStateRegistryOwner(activity)
    }
}
