package com.danhdue.jetcleanarch.model.dto.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@JsonClass(generateAdapter = true)
data class UserInfo(
    @Json(name = "access_token")
    val accessToken: String,
    @Json(name = "bio")
    val bio: String,
    @Json(name = "biometricAuth")
    val biometricAuth: Boolean,
    @Json(name = "birthday")
    val birthday: String,
    @Json(name = "ccid")
    val ccid: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "deleted_at")
    val deletedAt: String,
    @Json(name = "disabled")
    val disabled: Boolean,
    @Json(name = "display_name")
    val displayName: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "email_verified")
    val emailVerified: Boolean,
    @Json(name = "expires_in")
    val expiresIn: String,
    @Json(name = "firebase_uid")
    val firebaseUid: String,
    @Json(name = "metadata")
    val metadata: String,
    @Json(name = "phone_number")
    val phoneNumber: String,
    @Json(name = "photo_url")
    val photoUrl: String,
    @Json(name = "provider_data")
    val providerData: String,
    @Json(name = "providerId")
    val providerId: String,
    @Json(name = "refresh_token")
    val refreshToken: String,
    @Json(name = "role")
    val role: Int,
    @Json(name = "scope")
    val scope: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "token_type")
    val tokenType: String,
    @Json(name = "uid")
    val uid: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "username")
    val username: String
): Parcelable
