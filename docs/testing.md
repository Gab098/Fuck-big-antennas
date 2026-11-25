# Testing

## Automated checks

The Android GitHub Actions workflow assembles the debug APK on pushes and pull requests. Unit tests cover the status-label logic in `NetworkSnapshot`.

Run locally from the repository root:

```bash
gradle -p android testDebugUnitTest
gradle -p android assembleDebug
```

Requires JDK 17 and Gradle 8.11.1.

## Manual device checks

Test at least:
1. Wi-Fi connected and Internet available.
2. Wi-Fi connected to a captive portal.
3. Mobile data connected.
4. Airplane mode enabled.
5. Wi-Fi switched off while mobile data is available.
6. No network available.
7. VPN enabled and disabled.

Record Android version and device manufacturer. Do not attach private network credentials, subscriber identifiers, or unredacted diagnostic logs.

## Known limitation

The current observer tracks the Android default network, not every network visible to the operating system. The UI should not label it as a complete scan.
