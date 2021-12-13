package com.rayyan.USA_PEOPLE_DATA.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PeopleClient {
    val base_url = "https://datausa.io/"

    val INSTANCE : PeopleEndPoint by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PeopleEndPoint::class.java)
    }
}