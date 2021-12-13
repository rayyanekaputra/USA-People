package com.rayyan.USA_PEOPLE_DATA.utilities

import com.rayyan.USA_PEOPLE_DATA.model.Result
import com.google.gson.annotations.SerializedName

class PeopleData {

    companion object{
//        var dificulty: String = ""
//        var key: String = ""
//        var portion: String = ""
//        var thumb: String = ""
//        var times: String = ""
//        var title: String = ""

        var id_nation: String? = null
        var nation: String? = null
        var id_year: String? = null
        var year: String? = null
        var population: String? = null
        var slug_monitor: String? = null

        fun fill(item: Result){
            id_nation = item.id_nation
            nation = item.nation
            id_year = item.id_year
            year = item.year
            population = item.population
            slug_monitor = item.slug_monitor
        }
    }
}