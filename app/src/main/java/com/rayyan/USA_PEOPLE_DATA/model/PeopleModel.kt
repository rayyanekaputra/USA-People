package com.rayyan.USA_PEOPLE_DATA.model
import com.google.gson.annotations.SerializedName

data class PeopleModel(
    @SerializedName("data"   ) var peopleData   : List<Result>   = arrayListOf()
)

data class Result(
    @SerializedName("ID Nation" )   var        id_nation  : String? = null,
    @SerializedName("Nation")       var nation     :    String? = null,
    @SerializedName("ID Year")   var        id_year    : String?    = null,
    @SerializedName("Year")       var year       :    String? = null,
    @SerializedName("Population")       var population :    String?    = null,
    @SerializedName("Slug Nation")   var        slug_monitor  : String? = null
)