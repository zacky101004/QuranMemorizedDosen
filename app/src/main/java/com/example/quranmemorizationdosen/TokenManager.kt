package com.example.quranmemorizationdosen

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveTokens(accessToken: String, refreshToken: String, idToken: String?) {
        prefs.edit().apply {
            putString("access_token", accessToken)
            putString("refresh_token", refreshToken)
            idToken?.let { putString("id_token", it) }
            apply()
        }
    }

    fun getAccessToken(): String? = prefs.getString("access_token", null)

    fun getRefreshToken(): String? = prefs.getString("refresh_token", null)

    fun getIdToken(): String? = prefs.getString("id_token", null)

    fun clearTokens() {
        prefs.edit().clear().apply()
    }
}