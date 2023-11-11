package com.danhdue.jetcleanarch.repository

import kotlinx.coroutines.flow.Flow

interface WelcomeRepository {
    fun readOnBoardingState(): Flow<Boolean>
    suspend fun saveOnBoardingState(completed: Boolean)
}
