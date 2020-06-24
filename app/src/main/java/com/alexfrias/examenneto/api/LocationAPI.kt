package com.alexfrias.examenneto.api

import com.alexfrias.examenneto.model.LocationModel
import retrofit2.Call
import retrofit2.http.*

interface LocationAPI {

    @FormUrlEncoded
    @POST("obtieneCoordenadasXUsuario")
    fun getLocation(@Field("usuarioid") usuarioid: String): Call<LocationModel>

}