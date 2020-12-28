package com.appslima.app.data.repository

import com.appslima.app.data.model.ActionState
import com.appslima.app.data.model.Artikel
import com.appslima.app.data.remote.ArticleService
import com.appslima.app.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class ArticleRepository {
    private val articleService: ArticleService by lazy { RetrofitApi.articleService() }

    suspend fun listArticle(): ActionState<List<Artikel>> {
        return try {
            val list = articleService.listArticle().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailArticle (url: String): ActionState<Artikel> {
        return try {
            val list = articleService.detailArticle(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchArticle(query: String): ActionState<List<Artikel>> {
        return try {
            val list = articleService.searchArticle(query).await()
            ActionState(list.data)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}