# Research index

Start with primary documentation and standards. Pin versions when turning research notes into a reproducible lab.

## Cellular architecture and standards

- 3GPP specifications portal: https://www.3gpp.org/specifications
- ETSI standards search: https://www.etsi.org/standards
- Android connectivity architecture: https://developer.android.com/develop/connectivity

Research topics:
- LTE/EPC architecture and interfaces
- 5G System architecture and service-based architecture
- Control plane vs user plane
- Subscriber identity and authentication concepts
- Registration, session management, mobility, roaming, and policy control
- IMS and voice service architecture

## Virtual cellular lab

- Open5GS: https://open5gs.org/
- Open5GS documentation: https://open5gs.org/open5gs/docs/
- srsRAN Project: https://www.srsran.com/
- srsRAN documentation: https://docs.srsran.com/
- UERANSIM: https://github.com/aligungr/UERANSIM
- Wireshark: https://www.wireshark.org/

Use virtualized or isolated lab configurations and synthetic subscriber data. Do not transmit on public mobile spectrum or attach test systems to commercial networks without explicit authorization.

## Security research

Research topics:
- Threat modeling and trust boundaries
- Secure configuration and management-plane isolation
- Certificate and secret management
- Privacy-safe logging
- Software supply-chain review
- Responsible vulnerability disclosure

Prefer official advisories, project security policies, standards, and reproducible lab evidence.

## Alternative connectivity

- OpenWrt: https://openwrt.org/
- LibreMesh: https://libremesh.org/
- OpenWISP: https://openwisp.org/
- Meshtastic: https://meshtastic.org/

A mesh can relay traffic locally, but it does not create an Internet uplink. Any gateway or shared connection must be operated with the owner's permission and appropriate legal authorization.

## Android observer

- Read network state: https://developer.android.com/develop/connectivity/network-ops/reading-network-state
- ConnectivityManager: https://developer.android.com/reference/android/net/ConnectivityManager
- NetworkCapabilities: https://developer.android.com/reference/android/net/NetworkCapabilities

The Android app is a supporting diagnostic tool; it cannot expose all modem or operator-core internals.
