# Project architecture

## Mission

FBA is a telecom research repository with four connected work areas:

1. Cellular architecture research.
2. Defensive security methodology.
3. An isolated virtual mobile-network lab.
4. Supporting tools for observing connectivity and alternative networks.

## Research layers

### Cellular system map

Study the path from user equipment through radio access, transport/backhaul, mobile core, and external data networks. Keep control-plane functions distinct from user-plane forwarding.

### Security and trust model

Map ownership, trust boundaries, identities, authentication, authorization, policy, management interfaces, and data flows. Security work must be scoped to FBA-owned or explicitly authorized systems.

### Virtual lab

Use virtual network functions and simulators with synthetic identities and lab-generated traffic. The initial lab has no radio transmission and no connection to commercial carrier infrastructure.

### Alternative connectivity

Study community networks, mesh routing, shared gateways, multi-WAN failover, load balancing, and multipath transports. A mesh or multiple interfaces do not independently create an Internet uplink or carrier entitlement.

## Android observer

The existing Android app is a supporting field instrument. It reads the default network and capabilities exposed by Android's public APIs. It cannot inspect the operator's core network, read SIM secrets, or control all modem behavior.

## Data and privacy

Research artifacts should use synthetic or sanitized data. Do not store subscriber identifiers, SIM secrets, private packet payloads, personal browsing history, or precise location.

## Repository structure

```text
android/       Supporting Android connectivity observer
docs/          Architecture, methodology, lab plan, references
```

## Research output

A completed research item should include:
- the question being investigated;
- authoritative references;
- a diagram or concise explanation;
- assumptions and limitations;
- a reproducible lab method where relevant;
- a defensive conclusion.
