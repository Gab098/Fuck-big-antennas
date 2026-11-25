# Contributing

Thanks for your interest in FBA.

## Before opening a change

1. Read the [architecture](docs/architecture.md), [platform constraints](docs/android-platform.md), and [security model](docs/security.md).
2. Keep changes small and explain the user-visible behavior.
3. Do not add features that bypass authentication, interfere with radio services, or inspect other people's traffic.
4. Avoid collecting identifiers or location data unless a feature demonstrably needs them and has explicit consent.

## Android development

- Kotlin, Jetpack Compose, JDK 17.
- Keep Android platform calls behind small, testable classes.
- Prefer immutable state models.
- Handle missing networks and permission/platform limitations without crashing.
- Document API-level requirements.

## Pull requests

Include:
- What changed and why.
- Android version/device tested.
- Build and test results.
- Permissions added or changed.
- Privacy impact, if any.

Do not include real subscriber identifiers, credentials, packet captures, or personal network logs in issues or pull requests.
