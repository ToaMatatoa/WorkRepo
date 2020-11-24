//package com.example.myapplicationds.domain
//
//import com.example.myapplicationds.data.local.model.LocalData
//import com.example.myapplicationds.data.remote.model.ResponseData
//
//interface IDataMapper {
//    fun map(input: ResponseData): LocalData
//}
//
//class ListMapperImp : IDataMapper {
//
//    override fun map(input: ResponseData): LocalData {
//        return input.map { input.map() }
//    }
//}