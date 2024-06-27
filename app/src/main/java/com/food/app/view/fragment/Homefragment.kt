package com.food.app.view.fragment

import androidx.databinding.ViewDataBinding
import com.food.app.R
import com.food.app.baseClass.BaseFragment
import com.food.app.databinding.FragmentHomeBinding
import com.food.app.view.adapter.BookAdapter
import com.food.app.view.adapter.DateAdapter
import com.food.app.view.adapter.FilterAdapter
import com.food.app.view.responsemodel.Bookingmodel
import com.food.app.view.responsemodel.Datemodel
import com.food.app.view.responsemodel.FilterMOdel
import com.kotlintest.app.utility.interFace.CommonInterface

class Homefragment: BaseFragment<FragmentHomeBinding>(){

    override fun initView(mViewDataBinding: ViewDataBinding?) {
        adapter()
this.mViewDataBinding.apply {

}
    }
    override fun getLayoutId(): Int = R.layout.fragment_home


    fun adapter(){
        var datelist:ArrayList<Datemodel> = ArrayList()
        datelist.add(Datemodel("Today","Jun  2"))
        datelist.add(Datemodel("Tomorrow","Jun  3"))
        datelist.add(Datemodel("Monday","Jun  4"))
        datelist.add(Datemodel("Tuesday","Jun  5"))
        datelist.add(Datemodel("Wednesday","Jun  6"))
        datelist.add(Datemodel("Thursday","Jun  7"))
        datelist.add(Datemodel("Friday","Jun  8"))

        val dateadapter = DateAdapter(datelist,object: CommonInterface {
            override fun commonCallback(any: Any) {
             

            }

        })

        this. mViewDataBinding.daterv.adapter=dateadapter


        var filterlist:ArrayList<FilterMOdel> = ArrayList()
        filterlist.add(FilterMOdel("Waiting For Confirmation",R.drawable.ic_clk))
        filterlist.add(FilterMOdel("Upcoming Confirmation",R.drawable.upcoming))
        filterlist.add(FilterMOdel("Upcoming Confirmation",R.drawable.upcoming))
        filterlist.add(FilterMOdel("Upcoming Confirmation",R.drawable.upcoming))

        val filterAdapter = FilterAdapter(filterlist,object: CommonInterface {
            override fun commonCallback(any: Any) {
             

            }

        })

        this. mViewDataBinding.filterv.adapter=filterAdapter
        var bookinglist:ArrayList<Bookingmodel> = ArrayList()
        bookinglist.add(Bookingmodel("2.00Am"))
        bookinglist.add(Bookingmodel("4.00Am"))
        bookinglist.add(Bookingmodel("10.00Am"))
        bookinglist.add(Bookingmodel("1.00Am"))
        bookinglist.add(Bookingmodel("2.00Am"))
        bookinglist.add(Bookingmodel("5.00Am"))
        bookinglist.add(Bookingmodel("8.00Am"))

        val bookAdapter = BookAdapter(bookinglist,object: CommonInterface {
            override fun commonCallback(any: Any) {
             

            }

        })

        this. mViewDataBinding.bookingrv.adapter=bookAdapter




    }

}