package com.food.app.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.food.app.R
import com.food.app.baseClass.BaseAdapter
import com.food.app.databinding.DateadapterBinding
import com.food.app.databinding.FilteradapterBinding
import com.food.app.view.responsemodel.Datemodel
import com.food.app.view.responsemodel.FilterMOdel
import com.kotlintest.app.utility.interFace.CommonInterface

class FilterAdapter (
    private val filterlist: ArrayList<FilterMOdel>,
    var commonInterface: CommonInterface
) : BaseAdapter<Any>(filterlist) {
    lateinit var context: Context
    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return adapterviewholder(
            LayoutInflater
                .from(parent.context)
                .inflate( R.layout.filteradapter, parent, false)
        )
    }

    class adapterviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var databding: FilteradapterBinding? = null

        init {
            databding = DataBindingUtil.bind<ViewDataBinding>(itemView) as FilteradapterBinding
        }

        fun getBinding(): FilteradapterBinding {
            return databding!!
        }
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        var binding = (holder as FilterAdapter.adapterviewholder).getBinding()

        binding.filtertxt.text=filterlist[position].process

        holder.itemView.setOnClickListener {
            commonInterface.commonCallback(filterlist[position])
        }

    }

    override fun getItemCount(): Int {
        return filterlist.size
    }
}