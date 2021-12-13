package com.rayyan.USA_PEOPLE_DATA.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.rayyan.USA_PEOPLE_DATA.adapter.PeopleAdapter
import com.rayyan.USA_PEOPLE_DATA.model.PeopleModel
import com.rayyan.USA_PEOPLE_DATA.model.Result
import com.rayyan.USA_PEOPLE_DATA.retrofit.PeopleClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleViewModel : ViewModel(){

    interface OnAdapterListener {
        fun onClick(item: Result)
    }

    fun getDataFromApi(recyclerView: RecyclerView, listener: OnAdapterListener){
        PeopleClient.INSTANCE.getDataPeople()
            .enqueue(object : Callback<PeopleModel> {
                override fun onFailure(call: Call<PeopleModel>, t: Throwable) {
                    Log.d("PeopleViewModel", "onFailure")
                }

                override fun onResponse(call: Call<PeopleModel>, response: Response<PeopleModel>) {
                    val data = response.body()?.peopleData
                    recyclerView.adapter = PeopleAdapter(data as ArrayList<Result>, object : PeopleAdapter.OnAdapterListener {
                        override fun onClick(item: Result) {
                            listener.onClick(item)
                        }

                    })
                }
            })
    }
}