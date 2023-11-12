package com.danhdue.jetcleanarch.data.remote.service

import com.danhdue.jetcleanarch.model.remote.user.UserInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInfoService {
    @GET("$USER/{id}")
    suspend fun getUserInfo(
        @Query("id") userId: String
    ): UserInfoResponse

    companion object {
        const val USER = "user"
    }
}
