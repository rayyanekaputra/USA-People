package com.rayyan.USA_PEOPLE_DATA.retrofit

import com.rayyan.USA_PEOPLE_DATA.model.PeopleModel
import retrofit2.Call
import retrofit2.http.GET

interface PeopleEndPoint {

    @GET("api/data?drilldowns=Nation&measures=Population")
    fun getDataPeople(): Call<PeopleModel>

}