package com.example.post

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("posts")
    fun post(
        @Field("userId") userId : Int,
        @Field("id") id : Int,
        @Field("title") title : String,
        @Field("body") body: String
    ) : Call<Response>
}