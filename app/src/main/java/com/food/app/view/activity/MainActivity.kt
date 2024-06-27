package com.food.app.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.app.washeruser.repository.Status
import com.food.app.R
import com.food.app.appControl.AppController
import com.food.app.baseClass.BaseActivity.BaseActivity
import com.food.app.databinding.ActivityMainBinding
import com.food.app.viewModel.HomeViewModel
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import java.util.Observer

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val homeViewModel by viewModel<HomeViewModel>()
    private var baseApplication : AppController?=null
    override fun getLayoutId():Int=R.layout.activity_main

    override fun initView(mViewDataBinding: ViewDataBinding?) {
 /*       val map: HashMap<String, String> = HashMap()
        map.put("name", "muthu")
        homeViewModel.gethomepage(map)*/
        baseApplication = activity?.applicationContext as AppController

        homeViewModel.response().observe(this, androidx.lifecycle.Observer {
            processResponse(it)
        })
        this.mViewDataBinding.apply {
            ttext.setSafeOnClickListener {
                println("namrrr")
            }
            text.setSafeOnClickListener {
                println("najhfiuayfi")
            }
        }

        this.mViewDataBinding.ttext.setSafeOnClickListener {
            println("namrrr")
        }
        val emitServiceLocation = JSONObject()
//        emitServiceLocation.put("latitude", currentLocation.latitude.toString())
//        emitServiceLocation.put("longitude", currentLocation.longitude.toString())
//        emitServiceLocation.put("user_id", user_id)
        baseApplication?.emitcurrentlocation("currentLocation",emitServiceLocation)


    }


    private fun processResponse(response: com.food.app.network.Response) {
        when (response.status) {
            Status.SUCCESS -> {
                when (response.data) {

                }
            }

            Status.ERROR -> {
            }
        }
    }



}
