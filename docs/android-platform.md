# Android platform constraints

## What the app can observe

With the normal `ACCESS_NETWORK_STATE` permission, an Android app can query connectivity state and register callbacks. `ConnectivityManager` and `NetworkCapabilities` expose useful metadata such as transport type, Internet capability, validation, and metering.

The current prototype observes the **default network**, which is the network Android currently uses by default for the app.

## What this does not mean

- It does not grant access to every nearby Wi-Fi network.
- It does not reveal another carrier's private network or grant roaming rights.
- It does not expose SIM authentication secrets.
- It does not let an ordinary app freely reconfigure cellular radio behavior.
- It does not guarantee that an existing TCP/QUIC connection survives a network change.

## Future network requests

Android offers APIs such as `requestNetwork` and `bindProcessToNetwork`, but their behavior depends on permissions, OS version, network capabilities, and user/system policy. They must be tested on real devices. FBA should prefer explicit user consent and avoid claiming that it can force the system to use an unavailable or unauthorized network.

## Android version

The initial project targets API 35 and supports API 26+ for a practical baseline. Platform behavior must be verified on current Android releases and OEM builds.
