package com.example.myapplicationds.ui

import com.example.myapplicationds.data.remote.model.ResponseData

interface IContract {

    interface IPresenter {
        var view: IView?
        fun getData()
        fun onDestroy()
    }

    interface IView {
        fun showData(list: List<ResponseData>)
    }
}