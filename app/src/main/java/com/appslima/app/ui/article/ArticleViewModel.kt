package com.appslima.app.ui.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appslima.app.data.model.ActionState
import com.appslima.app.data.model.Artikel
import com.appslima.app.data.repository.ArticleRepository
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    private val repo: ArticleRepository by lazy { ArticleRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Artikel>>()
    val detailResp = MutableLiveData<Artikel>()
    val searchResp = MutableLiveData<List<Artikel>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listArticle() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listArticle()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailArticle(url: String? = this.url.value){
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp =repo.detailArticle(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun seacrhArticle(query: String? = this.query.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchArticle(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}