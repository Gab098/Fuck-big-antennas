# Fuck Big Antennas (FBA)

**A connectivity coordination project for Android and community networks.**

FBA explores how devices can make better use of connectivity that is already available and authorized: Wi-Fi, mobile data, Ethernet/tethering, and community network infrastructure.

> FBA does not bypass carrier authentication, create free mobile data, impersonate SIMs, or access networks without permission. Its goal is to improve visibility, reliability, and handoff between networks the user is allowed to use.

## Project status

Early prototype / foundation. The Android app currently monitors the system's **default network** and reports its transport and capabilities. It does not yet switch networks, combine links, or run a VPN.

## First milestone

- [x] Establish Android project structure
- [x] Read the Android default network state
- [x] Display transport, validation, metering, and connectivity status
- [ ] Add latency and reachability diagnostics
- [ ] Add a connection history
- [ ] Add user-configurable network preferences
- [ ] Design safe failover behavior
- [ ] Research multi-WAN tunneling and community-network integration

## Repository layout

```text
android/       Native Android application (Kotlin + Jetpack Compose)
docs/          Architecture, platform constraints, security, roadmap
```

## Build

1. Install Android Studio with Android SDK Platform 35.
2. Open the `android/` directory in Android Studio.
3. Allow Gradle sync to finish.
4. Run the `app` configuration on an Android 8.0+ device or emulator.

The project uses the Gradle wrapper convention, but wrapper scripts/JAR are not committed yet. Android Studio can generate them with **Gradle > Generate Gradle Wrapper** after the first successful Gradle sync, or use a locally installed compatible Gradle distribution.

## Design principles

- **Permission first:** only use networks and interfaces exposed by Android or explicitly administered by the user.
- **No hidden traffic:** no packet interception or collection of private payloads.
- **Local-first:** diagnostics and history should work without an FBA account.
- **Transparent decisions:** explain why a connection is recommended.
- **Battery-aware:** avoid aggressive continuous probing.
- **No false promises:** failover is not bonding, and neither creates additional data allowance.

## Documentation

- [Architecture](docs/architecture.md)
- [Android platform constraints](docs/android-platform.md)
- [Security and privacy](docs/security.md)
- [Roadmap](docs/roadmap.md)

## License

Not selected yet. Until a license is added, all rights are reserved by the repository owner. Do not assume this project is open-source licensed.
