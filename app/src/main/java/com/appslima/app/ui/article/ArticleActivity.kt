package com.appslima.app.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appslima.app.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
    }

    companion object {
        const val OPEN_ARTICLE = "open_article"
    }
}

