package com.example.androidmasterproject.core.mapper.list

import com.example.androidmasterproject.core.mapper.Mapper

class NullableInputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableInputListMapper<I, O> {

    override fun map(input: List<I>?): List<O> {
        return input?.map { mapper.map(it) }.orEmpty()
    }
}