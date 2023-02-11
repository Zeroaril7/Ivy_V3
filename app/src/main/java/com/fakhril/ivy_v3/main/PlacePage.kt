package com.fakhril.ivy_v3.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.ivy_v3.R
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.ui.adapter.PlacePageAdapter
import com.fakhril.ivy_v3.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlacePage : AppCompatActivity() {
    private lateinit var ivyRV: RecyclerView

    private val mainViewModel by viewModels<MainViewModel>()
    private val placePageAdapter = PlacePageAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_page)

        ivyRV = findViewById(R.id.card)

        ivyRV.setHasFixedSize(true)
        ivyRV.layoutManager = LinearLayoutManager(this)

        ivyRV.adapter = placePageAdapter



        mainViewModel.getplaces.observe(this){
            placePageAdapter.updateList(it as List<Place>)
        }
    }
}