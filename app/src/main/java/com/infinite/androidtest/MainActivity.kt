package com.infinite.androidtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_test_a -> {
                text_menu_a_click.visibility= View.VISIBLE
            }
            R.id.menu_test_b -> {

            }
            R.id.menu_test_c -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}