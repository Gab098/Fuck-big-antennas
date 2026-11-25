package dev.fba.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NetworkSnapshot(
    val transport: String = "Unknown",
    val hasInternetCapability: Boolean = false,
    val validated: Boolean = false,
    val metered: Boolean = true,
    val connected: Boolean = false
) {
    val statusLabel: String
        get() = when {
            !connected -> "No default network"
            validated -> "Internet validated"
            hasInternetCapability -> "Internet capability, not validated"
            else -> "Connected, no Internet capability"
        }
}

class NetworkMonitor(context: Context) {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val _snapshot = MutableStateFlow(readSnapshot())
    val snapshot: StateFlow<NetworkSnapshot> = _snapshot.asStateFlow()

    private val callback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            refresh()
        }

        override fun onLost(network: Network) {
            refresh()
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            refresh()
        }

        override fun onUnavailable() {
            refresh()
        }
    }

    fun start() {
        runCatching {
            connectivityManager.registerDefaultNetworkCallback(callback)
        }.onFailure {
            refresh()
        }
        refresh()
    }

    fun stop() {
        runCatching {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }

    fun refresh() {
        _snapshot.value = readSnapshot()
    }

    private fun readSnapshot(): NetworkSnapshot {
        val activeNetwork = connectivityManager.activeNetwork
            ?: return NetworkSnapshot()

        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            ?: return NetworkSnapshot()

        val transport = when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "Wi-Fi"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Mobile data"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "Ethernet"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> "VPN"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> "Bluetooth"
            else -> "Other"
        }

        return NetworkSnapshot(
            transport = transport,
            hasInternetCapability =
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET),
            validated =
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED),
            metered =
                !capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED),
            connected = true
        )
    }
}
