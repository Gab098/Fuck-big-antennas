# Architecture

## Current scope

The first Android milestone is an observability application. It reads the system's default network and presents information Android exposes through `ConnectivityManager` and `NetworkCapabilities`.

It is deliberately not a VPN, packet tunnel, carrier client, or radio access network.

## Planned components

### 1. Network observer

Responsibilities:
- Observe default-network availability and changes.
- Read transport type (Wi-Fi, cellular, Ethernet, VPN, or other).
- Read whether Android considers the network validated for Internet access.
- Read whether the network is metered.
- Publish immutable snapshots to the UI.

### 2. Diagnostics

Future responsibilities:
- Measure DNS resolution and HTTPS reachability against configurable, reputable endpoints.
- Measure latency with bounded timeouts.
- Track failures and recovery.
- Avoid collecting packet contents, browsing history, or credentials.

### 3. Policy engine

Future responsibilities:
- Rank available, authorized connections using user-defined priorities.
- Consider validation, metering, latency, stability, and user data limits.
- Explain recommendations instead of silently changing connectivity.
- Respect Android's network-selection APIs and platform restrictions.

### 4. Handoff

Future responsibilities:
- Detect when the default network changes.
- Explain likely application impact.
- Investigate supported Android APIs for requesting a particular network.
- Never promise seamless migration for sockets that are already bound to a previous network.

### 5. Optional multi-link gateway

A later, separate research track may evaluate multipath transport through an endpoint controlled by the user. Multiple access links do not automatically become one faster connection: a cooperating remote endpoint and a suitable transport protocol are generally required.

## Data flow

```text
Android ConnectivityManager
          |
          v
   NetworkMonitor
          |
          v
   StateFlow<NetworkSnapshot>
          |
          v
  Compose status screen
```

## Snapshot model

A snapshot should contain only operational metadata:
- transport label
- Internet capability
- validation state
- metered state
- observation timestamp

Do not store subscriber identifiers, SIM secrets, packet payloads, or precise location.
