package com.appslima.app.data.remote

import com.appslima.app.data.model.ArtikelList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("/")
    fun listArticle() : Call<ArtikelList>

    @GET("detail/")
    fun detailArticle(@Query("url") url: String) : Call<ArtikelList>

    @GET("search/")
    fun searchArticle(@Query("q") query: String) : Call<ArtikelList>
}