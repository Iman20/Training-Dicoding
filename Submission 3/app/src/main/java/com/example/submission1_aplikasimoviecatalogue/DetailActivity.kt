package com.example.submission1_aplikasimoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "bundle_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
    }

    private fun initView() {
        val data = intent.getParcelableExtra(DATA) as Movie
        textTitle.text = data.title
        textDescription.text = data.description
        textDirector.text = data.voteAvarage
        textWriter.text = data.voteCount
        textScreen.text = data.popularity
        Glide.with(this).load(data.posterPath).into(imageView)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when(itemId){
            android.R.id.home -> {
                onBackPressed()
            }
            R.id.backButton -> {
                onBackPressed()
            }
        }

    }
}
