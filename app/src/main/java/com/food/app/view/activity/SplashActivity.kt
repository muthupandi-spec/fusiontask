package com.food.app.view.activity

import androidx.databinding.ViewDataBinding
import com.food.app.R
import com.food.app.baseClass.BaseActivity.BaseActivity
import com.food.app.databinding.ActivitySplashBinding
import com.food.app.view.fragment.Homefragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit


class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun getLayoutId(): Int =R.layout.activity_splash
    override fun initView(mViewDataBinding: ViewDataBinding?) {
        disposable.add(Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {  t->
                run {
                    Timber.d(t)
                }
            }
            .subscribe { aLong ->
                callIntent()
            })
    }



    protected fun callIntent(){
//        setIntent(MainActivity::class.java,0)
        movoToFragment(android.R.id.content,Homefragment(),null,false)
    }

}
