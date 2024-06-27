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
import com.food.app.databinding.BookingadapterBinding
import com.food.app.databinding.DateadapterBinding
import com.food.app.view.responsemodel.Bookingmodel
import com.food.app.view.responsemodel.Datemodel
import com.kotlintest.app.utility.interFace.CommonInterface

class BookAdapter (
    private val booklist: ArrayList<Bookingmodel>,
    var commonInterface: CommonInterface
) : BaseAdapter<Any>(booklist) {
    lateinit var context: Context
    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return adapterviewholder(
            LayoutInflater
                .from(parent.context)
                .inflate( R.layout.bookingadapter, parent, false)
        )
    }

    class adapterviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var databding: BookingadapterBinding? = null

        init {
            databding = DataBindingUtil.bind<ViewDataBinding>(itemView) as BookingadapterBinding
        }

        fun getBinding(): BookingadapterBinding {
            return databding!!
        }
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        var binding = (holder as BookAdapter.adapterviewholder).getBinding()
        binding.time.text=booklist[position].time

        holder.itemView.setOnClickListener {
            commonInterface.commonCallback(booklist[position])
        }

    }

    override fun getItemCount(): Int {
        return booklist.size
    }
}