package com.infinite.androidtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu

/**
 * Created by kfzhangxu on 2018/1/31.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }
}