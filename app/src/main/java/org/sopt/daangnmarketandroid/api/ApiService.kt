package org.sopt.daangnmarketandroid.api

import org.sopt.daangnmarketandroid.ui.home.data.ResponseProductData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("post")
    fun getProductInfo(): Call<ResponseProductData>
}