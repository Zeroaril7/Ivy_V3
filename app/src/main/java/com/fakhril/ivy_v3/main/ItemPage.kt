package com.fakhril.ivy_v3.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.ivy_v3.R
import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.ui.adapter.ItemChildAdapter
import com.fakhril.ivy_v3.ui.adapter.ItemParentAdapter
import com.fakhril.ivy_v3.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemPage : AppCompatActivity() {

    private lateinit var ivyRV: RecyclerView

    private val allPlace = ArrayList<Place>()
    private val allItem = ArrayList<Item>()
    private val mainViewModel by viewModels<MainViewModel>()
    private val itemParentAdapter = ItemParentAdapter(allPlace)
    private val itemChildAdapter = ItemChildAdapter(allItem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_page)


        ivyRV = findViewById(R.id.parent_rv)

        ivyRV.setHasFixedSize(true)
        ivyRV.layoutManager = LinearLayoutManager(this)

        ivyRV.adapter = itemParentAdapter

        mainViewModel.getplaces.observe(this){
            itemParentAdapter.updateListPlace(it as List<Place>)
        }

        mainViewModel.getItems.observe(this){
            itemChildAdapter.updateListItem(it as List<Item>)
        }
    }
}