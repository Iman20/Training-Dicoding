package com.example.submission1_aplikasimoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.submission1_aplikasimoviecatalogue.adapter.MovieAdapter
import com.example.submission1_aplikasimoviecatalogue.adapter.MyVPagerAdapter
import com.example.submission1_aplikasimoviecatalogue.fragment.MovieFragment
import com.example.submission1_aplikasimoviecatalogue.fragment.TvFragment
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        bottomNav.setOnNavigationItemSelectedListener(navigateListener)
        val movieFragment = MovieFragment()
        addFragment(movieFragment)

    }

    private val navigateListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.movie -> {
                val fragment = MovieFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.tv -> {
                val fragment = TvFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

}
