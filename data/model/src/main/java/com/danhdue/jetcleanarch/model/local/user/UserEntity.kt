package com.danhdue.jetcleanarch.model.local.user

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_ACCESS_TOKEN) val accessToken: String,
    @ColumnInfo(name = COLUMN_BIO) val bio: String,
    @ColumnInfo(name = COLUMN_BIOMETRIC_AUTH) val biometricAuth: Boolean,
    @ColumnInfo(name = COLUMN_BIRTHDAY) val birthday: String,
    @ColumnInfo(name = COLUMN_CCID) val ccid: String,
    @ColumnInfo(name = COLUMN_CREATED_AT) val createdAt: Date,
    @ColumnInfo(name = COLUMN_DELETED_AT) val deletedAt: Date,
    @ColumnInfo(name = COLUMN_DISABLE) val disabled: Boolean,
    @ColumnInfo(name = COLUMN_DISPLAY_NAME) val displayName: String,
    @ColumnInfo(name = COLUMN_EMAIL) val email: String,
    @ColumnInfo(name = COLUMN_EMAIL_VERIFIED) val emailVerified: Boolean,
    @ColumnInfo(name = COLUMN_EXPIRES_IN) val expiresIn: String,
    @ColumnInfo(name = COLUMN_FIREBASE_UID) val firebaseUid: String,
    @ColumnInfo(name = COLUMN_META_DATA) val metadata: String,
    @ColumnInfo(name = COLUMN_PHONE_NUMBER) val phoneNumber: String,
    @ColumnInfo(name = COLUMN_PHOTO_URL) val photoUrl: String,
    @ColumnInfo(name = COLUMN_PROVIDER_DATA) val providerData: String,
    @ColumnInfo(name = COLUMN_PROVIDER_ID) val providerId: String,
    @ColumnInfo(name = COLUMN_REFRESH_TOKEN) val refreshToken: String,
    @ColumnInfo(name = COLUMN_ROLE) val role: String,
    @ColumnInfo(name = COLUMN_SCOPE) val scope: String,
    @ColumnInfo(name = COLUMN_TITLE) val title: String,
    @ColumnInfo(name = COLUMN_TOKEN_TYPE) val tokenType: String,
    @ColumnInfo(name = COLUMN_UID) val uid: String,
    @ColumnInfo(name = COLUMN_UPDATED_AT) val updatedAt: Date,
    @ColumnInfo(name = COLUMN_USER_NAME) val username: String,
) {
    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_ACCESS_TOKEN = "access_token"
        const val COLUMN_BIO = "bio"
        const val COLUMN_BIOMETRIC_AUTH = "biometricAuth"
        const val COLUMN_BIRTHDAY = "birthday"
        const val COLUMN_CCID = "ccid"
        const val COLUMN_CREATED_AT = "created_at"
        const val COLUMN_DELETED_AT = "deleted_at"
        const val COLUMN_DISABLE = "disabled"
        const val COLUMN_DISPLAY_NAME = "display_name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_EMAIL_VERIFIED = "email_verified"
        const val COLUMN_EXPIRES_IN = "expires_in"
        const val COLUMN_FIREBASE_UID = "firebase_uid"
        const val COLUMN_META_DATA = "metadata"
        const val COLUMN_PHONE_NUMBER = "phone_number"
        const val COLUMN_PHOTO_URL = "photo_url"
        const val COLUMN_PROVIDER_DATA = "provider_data"
        const val COLUMN_PROVIDER_ID = "providerId"
        const val COLUMN_REFRESH_TOKEN = "refresh_token"
        const val COLUMN_ROLE = "role"
        const val COLUMN_SCOPE = "scope"
        const val COLUMN_TITLE = "title"
        const val COLUMN_TOKEN_TYPE = "token_type"
        const val COLUMN_UID = "uid"
        const val COLUMN_UPDATED_AT = "updated_at"
        const val COLUMN_USER_NAME = "username"
    }
}