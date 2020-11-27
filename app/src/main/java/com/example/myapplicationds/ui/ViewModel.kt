package com.example.myapplicationds.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.domain.DataUseCase
import kotlinx.coroutines.launch

class ViewModel(private val itemsDataUseCase: DataUseCase, private val navigation: Navigation) :
    ViewModel() {

    private val liveDataRemote = MutableLiveData<List<LocalData>>()
    val liveDataRemoteProvider: LiveData<List<LocalData>> = liveDataRemote

    fun navigateToFragmentDetail() = navigation.navigateToFragmentDetail()

    fun getData() {
        viewModelScope.launch {
            liveDataRemote.postValue(itemsDataUseCase.getData())
        }
    }

//    fun passDataToFragmentDetail(item: LocalData) {
//        liveDataRemote.value = listOf(item)
//    }
}

