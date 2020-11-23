package com.example.myapplicationds.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationds.data.remote.model.ResponseData
import com.example.myapplicationds.domain.DataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get

class ViewModel constructor(private val itemsDataUseCase: DataUseCase) : ViewModel() {

    private val liveData = MutableLiveData<List<ResponseData>>()
    val liveDataProvider : LiveData<List<ResponseData>> = liveData

    fun getData() {

        viewModelScope.launch {
            liveData.postValue(itemsDataUseCase.getItemsData())
        }
    }
}

