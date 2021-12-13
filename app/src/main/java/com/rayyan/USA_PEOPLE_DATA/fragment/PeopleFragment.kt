package com.rayyan.USA_PEOPLE_DATA.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rayyan.USA_PEOPLE_DATA.R
import com.rayyan.USA_PEOPLE_DATA.fragment.detail.PeopleDetailFragment
import com.rayyan.USA_PEOPLE_DATA.model.Result
import com.rayyan.USA_PEOPLE_DATA.utilities.PeopleData
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment() {

    lateinit var peopleViewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PeopleFragment", "onCreate dipanggil")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("PeopleFragment", "onCreateView dipanggil")
        peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPeople.setHasFixedSize(true)
        rvPeople.layoutManager = LinearLayoutManager(context)
        peopleViewModel.getDataFromApi(rvPeople, object : PeopleViewModel.OnAdapterListener {
            override fun onClick(item: Result) {
                PeopleData.fill(item)
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.container, PeopleDetailFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ResepFragment", "onDestroy dipanggil")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeopleFragment()
    }
}