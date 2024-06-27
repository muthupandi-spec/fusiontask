package com.food.app.network

import android.app.Application
import android.widget.Toast
import androidx.databinding.library.BuildConfig
import androidx.lifecycle.MutableLiveData
import com.food.app.utility.SharedHelper
import com.food.app.utility.rx.SchedulersFacade
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.disposables.CompositeDisposable
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.net.UnknownHostException

class  CommonApi constructor(
    var application: Application,
    val sharedHelper: SharedHelper,
    val api: ApiInterface,
    val schedulersFacade: SchedulersFacade
) {

 /*   fun homepage1(
        response: MutableLiveData<Response>,
        disable: CompositeDisposable,
        model: HashMap<String,String>

    ) {


        disable.add(api.homepage(model)
            .doOnSubscribe{ response.postValue(Response.loading()) }
            .compose(schedulersFacade.applyAsync())
            .doFinally { response.value = Response.dismiss() }
            .subscribe({
                response.value = Response.success(it)
            }, {
                response.value = Response.error(it)
                response.value = Response.dismiss()
                onError(it)
            })
        )
    }*/


    protected fun onError(throwable: Throwable) {
        Toast.makeText(application, getErrorBody(throwable), Toast.LENGTH_LONG).show()
        Timber.i("errorss===>%s", getErrorBody(throwable))
        if(getErrorBody(throwable).equals("access_denied")){
            sharedHelper.clearUser()
        }
    }
    fun getErrorBody(throwable: Throwable): String {
        try {
            when (throwable) {
                is HttpException -> {
                    if (BuildConfig.DEBUG && throwable.response().errorBody() == null) {
                        error("Assertion failed")
                    }
                    val errorBody = throwable.response().errorBody()!!.string()
                    val jsonObject = JSONObject(errorBody)
                    jsonObject.optString("message")
                    Timber.e("errorBody: %s", errorBody)
                    return if (jsonObject.has("result")) {
                        jsonObject.optString("result")
                    } else if (jsonObject.has("message")) {
                        jsonObject.optString("message")
                    } else {
                        "Something went wrong!!"
                    }
                }
                is UnknownHostException -> {
                    return "No internet connection"
                }
                else -> return if (throwable.message == null) {
                    "Something went Wrong!"
                } else {
                    throwable.message.toString()
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            return "Something went wrong"
        } catch (e: Exception) {
            e.printStackTrace()
            return "Something went wrong"
        }
    }


}