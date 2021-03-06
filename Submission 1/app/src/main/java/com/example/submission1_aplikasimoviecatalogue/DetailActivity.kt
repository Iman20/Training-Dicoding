package com.example.submission1_aplikasimoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "bundle_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
    }

    private fun initView() {
        val data = intent.getParcelableExtra(DATA) as Movie
        textTitle.text = data.title
        textDescription.text = data.description
        textDirector.text = data.director
        textWriter.text = data.writer
        textScreenPlay.text = data.screenPlay
        imageView.setImageResource(data.image)
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
        }

    }
}
