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
import com.example.jetnews.R
import com.therouter.TheRouter
import com.therouter.compose.compose

class MyAdapter(private val activity: Activity, private val data: ArrayList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder?>() {
    class MyViewHolder(itemView: View) : ViewHolder(itemView)

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(View.inflate(activity, R.layout.item_recyclerview, null))
    }

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onBindViewHolder(@NonNull holder: MyViewHolder, position: Int) {
        val view = makeView(activity) {
            val appContainer = (activity.application as JetnewsApplication).container
            val widthSizeClass = calculateWindowSizeClass(activity).widthSizeClass
            TheRouter.build(data.get(position))
                .withObject("appContainer", appContainer)
                .withObject("widthSizeClass", widthSizeClass)
                .compose()
        }
        (holder.itemView as ViewGroup).addView(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}