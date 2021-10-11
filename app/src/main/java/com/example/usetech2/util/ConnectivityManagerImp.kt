package com.example.usetech2.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkInfo
import com.example.usetech2.domain.repository.ConnectivityManager
import com.example.usetech2.di.scope.ForApplication
import javax.inject.Inject

class ConnectivityManagerImp @Inject constructor(@ForApplication val context: Context) :
    ConnectivityManager {
    @SuppressLint("ServiceCast")
    override fun hasNetwork(): Boolean? {
        var isConnected: Boolean? = false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as android.net.ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}