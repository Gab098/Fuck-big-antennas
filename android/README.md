# FBA Android app

Native Android prototype built with Kotlin and Jetpack Compose.

## Current behavior

- Observes Android's default network using `ConnectivityManager.registerDefaultNetworkCallback`.
- Displays transport, Internet capability, validation, and metered state.
- Refreshes the snapshot when network callbacks arrive or when the user taps Refresh.

## Not implemented yet

- Scanning for arbitrary Wi-Fi access points.
- Switching the system's default network.
- Automatic failover.
- Link bonding or VPN tunneling.
- Cellular radio control.

## Requirements

- Android Studio with Android SDK 35
- JDK 17
- Android 8.0 (API 26) or newer

Open this directory as the Android Studio project root.
