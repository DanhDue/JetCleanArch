package com.danhdue.jetcleanarch.model.remote.base

import com.squareup.moshi.Json

class BaseResponse<T> (
    @Json(name = "code") val code: String?,
    @Json(name = "message") val message: String?,
    @Json(name = "date") val data: T?,
)
