package com.alexfrias.examenneto.MapView

import android.content.Context
import android.util.Log
import com.alexfrias.examenneto.api.ApiClient
import com.alexfrias.examenneto.api.LocationAPI
import com.alexfrias.examenneto.model.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapPresenter(var context: Context, var view: MapContract.View): MapContract.Presenter {

    override fun getLocation(usuarioid: String) {
        view.showProgress()
        val client = ApiClient.getClient(LocationAPI::class, context) as LocationAPI
        val call = client.getLocation(usuarioid)
        call.enqueue(object : Callback<LocationModel>{
            override fun onResponse(call: Call<LocationModel>, response: Response<LocationModel>) {
                view.hideProgress()
                if (response.isSuccessful) {
                    Log.e("Response", response.body().toString())
                    view.returnData(response.body()!!)
                } else {
                    Log.e("Response", response.body().toString())
                }
            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {
                view.hideProgress()
                Log.e("On Failiure", t.message!!)
            }
        })
    }

}