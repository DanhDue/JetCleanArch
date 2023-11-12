package com.danhdue.jetcleanarch.data.remote.service

import com.danhdue.jetcleanarch.model.remote.base.BaseResponse
import com.danhdue.jetcleanarch.model.remote.user.UserInfoResponse
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AuthenticationService {

    @POST(AUTHENTICATION)
    suspend fun login(
        @QueryMap options: Map<String, String>? = null
    ): UserInfoResponse

    @POST(AUTHENTICATION)
    suspend fun logout(
        @Query("id") userId: String
    ): BaseResponse<Boolean>

    companion object {
        const val AUTHENTICATION = "auth"
    }

}
