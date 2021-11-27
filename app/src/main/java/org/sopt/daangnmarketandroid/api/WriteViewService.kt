package org.sopt.daangnmarketandroid.api

import org.sopt.daangnmarketandroid.data.RequestWriteData
import org.sopt.daangnmarketandroid.data.ResponseWriteData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WriteViewService {
    @POST("/post/upload")
    fun uploadPost(
        @Body body: RequestWriteData
    ): Call<ResponseWriteData>
}