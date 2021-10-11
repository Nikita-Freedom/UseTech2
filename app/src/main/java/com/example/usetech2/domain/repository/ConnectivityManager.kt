package com.example.usetech2.domain.repository

interface ConnectivityManager {
    fun hasNetwork(): Boolean?
}