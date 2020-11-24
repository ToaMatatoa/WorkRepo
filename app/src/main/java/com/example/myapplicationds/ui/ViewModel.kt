package com.example.myapplicationds.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.model.ResponseData
import com.example.myapplicationds.domain.DataUseCase
import kotlinx.coroutines.launch

class ViewModel constructor(private val itemsDataUseCase: DataUseCase) : ViewModel() {

    private val liveDataRemote = MutableLiveData<List<ResponseData>>()
    val liveDataRemoteProvider: LiveData<List<ResponseData>> = liveDataRemote
//    private val liveDataLocal = MutableLiveData<List<LocalData>>()
//    val liveDataLocalProvider: LiveData<List<LocalData>> = liveDataLocal

    fun getData() {

        viewModelScope.launch {
            liveDataRemote.postValue(itemsDataUseCase.getAllFromRemote())
//            liveDataLocal.postValue(itemsDataUseCase.getAllFromDB())
        }
    }
}

