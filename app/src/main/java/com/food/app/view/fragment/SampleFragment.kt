package com.food.app.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.food.app.R
import com.food.app.baseClass.BaseActivity.BaseActivity
import com.food.app.baseClass.BaseFragment
import com.food.app.databinding.FragmentSampleBinding

class SampleFragment : BaseFragment<FragmentSampleBinding>(){

    override fun initView(mViewDataBinding: ViewDataBinding?) {

    }
    override fun getLayoutId(): Int =R.layout.fragment_sample



}
