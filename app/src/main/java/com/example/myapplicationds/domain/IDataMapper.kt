package com.example.myapplicationds.domain

interface IDataMapper<ResponseData, LocalData> {
    fun map(input: ResponseData): LocalData
}

interface IListMapper<ResponseData, LocalData> : IDataMapper<List<ResponseData>, List<LocalData>>

class ListMapperImp<ResponseData, LocalData>(
    private val mapper: IDataMapper<ResponseData, LocalData>
) : IListMapper<ResponseData, LocalData> {

    override fun map(input: List<ResponseData>): List<LocalData> {
        return input.map { mapper.map(it) }
    }
}