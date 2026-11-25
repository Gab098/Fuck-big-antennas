# Cellular network architecture — research guide

## Purpose

This document is the conceptual map for understanding how a mobile device obtains Internet connectivity through a cellular operator. It is an architecture and protocol study guide, not a procedure for accessing third-party networks.

## The end-to-end path

A simplified user-data path looks like this:

```text
Phone / UE
   |
   | radio access (licensed spectrum, managed by the operator)
   v
Cell site / gNB (5G) or eNB (4G)
   |
   | operator transport / backhaul
   v
Mobile core
   |
   | subscriber policy, session management, user-plane forwarding
   v
Operator IP network
   |
   v
Internet / private services
```

The exact layout varies by generation and operator. Real deployments include redundancy, routing, security boundaries, monitoring, and interconnection systems omitted from this simplified diagram.

## Main components

| Component | Role |
|---|---|
| UE | The user equipment: phone, modem, or test device. |
| USIM / eSIM profile | Holds subscriber credentials and identity material used by the subscription. |
| RAN | Radio Access Network; connects devices over the air to the operator network. |
| eNB / gNB | 4G / 5G radio access node. |
| Backhaul / transport | Carries traffic between radio sites and the core. |
| MME (4G) | Mobility and control-plane management in LTE/EPC. |
| AMF (5G) | Access and mobility management in 5G Core. |
| SMF (5G) | PDU session management and control of user-plane resources. |
| UPF (5G) | User-plane forwarding between the mobile network and data networks. |
| HSS (4G) / UDM (5G) | Subscriber data functions. |
| AUSF (5G) | Authentication support function. |
| PCF (5G) | Policy control function. |
| IMS | Service architecture commonly used for voice and messaging services. |

## Four separate questions

Do not collapse these into one concept:

1. **Discovery:** which networks and cells are visible to a device?
2. **Authentication:** can the subscription prove its identity using the operator's authentication system?
3. **Authorization:** what services, data networks, and policies is that subscription allowed to use?
4. **Routing:** once a session is authorized, where can its traffic go?

Knowing a frequency, cell identifier, APN/DNN, or network name does not grant authorization. A radio connection is not automatically an Internet session.

## 4G and 5G study map

- LTE/EPC: UE, eNB, MME, HSS, SGW, PGW, PCRF.
- 5G Core: UE, gNB, AMF, SMF, UPF, UDM, AUSF, PCF, NRF, NSSF.
- Study control plane separately from user plane.
- Compare attach/registration, authentication, session establishment, mobility, and release at the level of official architecture documents.

## Questions FBA should investigate

- Which parts of connectivity are visible to an ordinary Android application?
- Which decisions are made by Android, the modem, and the operator?
- What is the difference between radio coverage and usable Internet service?
- How do roaming, handover, and network slicing fit into the architecture?
- Which diagnostics can be collected without subscriber secrets or private traffic?

## Safe lab boundary

Use simulator documentation, virtual network functions, and isolated lab instances. Do not transmit on public mobile spectrum, impersonate a commercial cell, collect other people's device identifiers, or attempt registration against an operator network without explicit authorization.
