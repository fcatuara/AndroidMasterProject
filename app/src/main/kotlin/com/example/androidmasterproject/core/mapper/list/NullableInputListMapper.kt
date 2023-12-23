package com.example.androidmasterproject.core.mapper.list

import com.example.androidmasterproject.core.mapper.Mapper

interface NullableInputListMapper<I, O> : Mapper<List<I>?, List<O>>