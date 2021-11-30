package org.sopt.daangnmarketandroid.api

import org.sopt.daangnmarketandroid.ui.writing.data.RequestWriteData
import org.sopt.daangnmarketandroid.ui.writing.data.ResponseWriteData
import org.sopt.daangnmarketandroid.ui.home.data.ResponseProductData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/post")
    fun getProductInfo(): Call<ResponseProductData>

    @POST("/post/upload")
    fun postUpload(
        @Body body: RequestWriteData
    ): Call<ResponseWriteData>
}