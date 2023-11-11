package com.danhdue.jetcleanarch.repository.impl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.danhdue.jetcleanarch.repository.WelcomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class WelcomeRepositoryImpl @Inject constructor(context: Context): WelcomeRepository {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = WELCOME_PREF_NAME)

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_COMPLETE_KEY)
    }

    private val dataStore = context.dataStore

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    companion object {
        const val WELCOME_PREF_NAME = "WELCOME_PREF_NAME"
        const val ON_BOARDING_COMPLETE_KEY = "on_boarding_completed"
    }

}
