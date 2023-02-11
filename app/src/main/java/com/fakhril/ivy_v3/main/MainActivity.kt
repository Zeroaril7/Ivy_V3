package com.fakhril.ivy_v3.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fakhril.ivy_v3.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}