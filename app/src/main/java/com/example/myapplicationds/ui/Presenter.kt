package com.example.myapplicationds.ui

import android.util.Log
import com.example.myapplicationds.domain.DataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Presenter constructor(private val itemsDataUseCase: DataUseCase) : IContract.IPresenter {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var view: IContract.IView

    override fun getData() {
        compositeDisposable.add(
            itemsDataUseCase.getItemsData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showData(it)
                }, {
                    Log.getStackTraceString(it)
                })
        )
    }

    override fun onDestroy() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}

