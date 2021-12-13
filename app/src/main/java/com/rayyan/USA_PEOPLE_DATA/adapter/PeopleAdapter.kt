package com.rayyan.USA_PEOPLE_DATA.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rayyan.USA_PEOPLE_DATA.R
import com.rayyan.USA_PEOPLE_DATA.model.Result
import kotlinx.android.synthetic.main.people_adapter.view.*

class PeopleAdapter(
    private val listPeople: ArrayList<Result>,
    val listener: OnAdapterListener
) :
    RecyclerView.Adapter<PeopleAdapter.Peopleholder>() {

    interface OnAdapterListener {
        fun onClick(item: Result)
    }

    class Peopleholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Result, listener: OnAdapterListener) {
            with(itemView) {
                tvTahun.text = item.year
                tvPopulasi.text = item.population.toString()
                itemView.setOnClickListener {
//
                    listener.onClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Peopleholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.people_adapter, parent, false)
        return Peopleholder(view)
    }

    override fun getItemCount(): Int {
        return listPeople.size
    }

    override fun onBindViewHolder(holder: Peopleholder, position: Int) {
        holder.bind(listPeople[position], listener)
    }
}