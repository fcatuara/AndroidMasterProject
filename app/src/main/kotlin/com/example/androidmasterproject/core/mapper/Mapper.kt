package com.example.androidmasterproject.core.mapper


interface Mapper<I, O> {

    fun map(input: I): O
}