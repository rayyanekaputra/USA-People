package com.rayyan.USA_PEOPLE_DATA.fragment.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rayyan.USA_PEOPLE_DATA.R
import com.rayyan.USA_PEOPLE_DATA.utilities.PeopleData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_people_detail.*

class PeopleDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvYear.text = PeopleData.year
        tvIdNation.text = PeopleData.id_nation.toString()
        tvNation.text = PeopleData.nation.toString()
        tvIdYear.text = PeopleData.id_year.toString()
        tvPopulation.text = PeopleData.population.toString()
        tvSlugMonitor.text = PeopleData.slug_monitor.toString()

//SHARE BUTTON
        btnShare.setOnClickListener{
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Pada TAHUN _${PeopleData.year}_ dgn ID TAHUN *${PeopleData.id_year}* sebuah ID NEGARA *${PeopleData.id_nation}* yaitu NEGARA *${PeopleData.nation}* mengalami POPULASI *${PeopleData.population}* sepadat  *${PeopleData.slug_monitor}* ")
                type = "text/plain"
            }
            val i = Intent.createChooser(intent, null)
            startActivity(i)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            PeopleDetailFragment()
    }
}