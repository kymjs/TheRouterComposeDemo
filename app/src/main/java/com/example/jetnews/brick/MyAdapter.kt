package com.example.jetnews.brick

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.jetnews.JetnewsApplication
import com.example.jetnews.ui.JetnewsApp


class MyAdapter(private val activity: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder?>() {
    class MyViewHolder(itemView: View) : ViewHolder(itemView)

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = makeView(activity) {
            JetnewsApp((activity.application as JetnewsApplication).container, calculateWindowSizeClass(activity).widthSizeClass)
        }
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 3
    }
}