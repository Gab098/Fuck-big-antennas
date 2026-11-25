# Research index

This index separates practical Android engineering from telecom and community-network research.

## Android connectivity

- Android Developers: [Read network state](https://developer.android.com/develop/connectivity/network-ops/reading-network-state)
- Android Developers: [ConnectivityManager](https://developer.android.com/reference/android/net/ConnectivityManager)
- Android Developers: [NetworkCapabilities](https://developer.android.com/reference/android/net/NetworkCapabilities)
- Android Developers: [VPN guide](https://developer.android.com/develop/connectivity/vpn)

## Multi-path and multi-WAN concepts

Research topics:
- Multipath TCP (MPTCP)
- Multipath QUIC
- VPN-based traffic aggregation
- OpenWrt multi-WAN failover and load balancing

Key distinction: failover chooses another path after a failure; load balancing distributes different flows; bonding/aggregation may split a single logical flow only when the transport and remote endpoint support it.

## Community connectivity

Research topics:
- Community wireless networks
- OpenWrt
- LibreMesh
- OpenWISP
- Meshtastic (low-bandwidth messaging, not broadband Internet)

A mesh can relay traffic locally, but it does not create an Internet uplink. Any gateway or shared connection must be operated with the owner's permission and appropriate legal authorization.

## Cellular lab learning

Research topics:
- Open5GS
- srsRAN
- Osmocom

Keep cellular experiments in virtualized or shielded/authorized lab environments. Do not transmit on public mobile spectrum or attempt to attach unauthorized devices to commercial networks.
