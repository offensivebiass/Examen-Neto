package com.alexfrias.examenneto.MapView

import com.alexfrias.examenneto.model.LocationModel

interface MapContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun returnData(location: LocationModel)
    }

    interface Presenter {
        fun getLocation(usuarioid: String)
    }

}