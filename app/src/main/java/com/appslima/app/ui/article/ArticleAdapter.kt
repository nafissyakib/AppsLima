package com.appslima.app.ui.article

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appslima.app.R
import com.appslima.app.data.model.Artikel
import com.appslima.app.databinding.ItemArticleBinding
import com.appslima.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class ArticleAdapter(val context: Context) : BaseAdapter<Artikel>(R.layout.item_article) {
    override fun onBind(binding: ViewDataBinding?, data: Artikel) {
        val mBinding = binding as ItemArticleBinding
        Glide.with(context).load(data.poster).into(mBinding.itemPoster)
    }
    override fun onClick(binding: ViewDataBinding?, data: Artikel) {
        val intent = Intent(context, ArticleActivity::class.java)
        intent.putExtra(ArticleActivity.OPEN_ARTICLE,data)

    }
}