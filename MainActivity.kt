package com.example.assignment

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.R.string
import com.example.assignment.crime.CrimeListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  setSupportActionBar(bind)
        val currentFragment = CrimeListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main, currentFragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(string.title_2)
        menu?.add(string.title_1)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.second_item -> {
                Log.d("TAG", "SECOND")}
            R.id.first_item -> {
                Log.d("TAG", "FIRST")}
        }
        return super.onOptionsItemSelected(item)
    }

}