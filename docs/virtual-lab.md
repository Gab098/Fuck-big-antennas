# Isolated virtual cellular lab

## Goal

Learn the roles and interactions of mobile-network components without transmitting on public radio spectrum or interacting with commercial subscribers.

## Lab principles

- Virtualized or otherwise isolated environment only.
- No RF transmission in the initial phases.
- Use synthetic subscriber identities and test credentials generated for the lab.
- Do not connect the lab to a carrier network.
- Keep management interfaces bound to a private lab network.
- Snapshot configurations before experiments.
- Never reuse real SIM credentials, phone identifiers, or personal traffic.

## Candidate projects

| Project | What to learn |
|---|---|
| Open5GS | Mobile core architecture and service relationships. |
| srsRAN Project | RAN and 4G/5G system architecture in supported lab configurations. |
| UERANSIM | Simulated 5G UE and RAN behavior for a virtual core lab. |
| Wireshark | Inspect synthetic or lab-generated protocol traces. |
| Linux network namespaces | Understand isolated IP routing and network boundaries. |

Check each project's current documentation, supported versions, and license before choosing a deployment path.

## Staged plan

### Stage 1 — Paper lab
- Draw a 4G EPC and a 5G Core architecture.
- Label control-plane and user-plane components.
- Trace, at a conceptual level, registration, authentication, session setup, and Internet routing.
- Produce a glossary.

### Stage 2 — Core-only virtual lab
- Deploy a core network in an isolated VM or container environment.
- Use only synthetic test subscriber data.
- Verify service health and internal connectivity.
- Document each component's role and configuration boundary.

### Stage 3 — Simulated access
- Add a simulator supported by the chosen project versions.
- Keep all traffic virtual and isolated.
- Capture only lab-generated traces.
- Compare observed behavior with the architecture notes.

### Stage 4 — Defensive experiments
- Test the lab's own access controls and management-plane exposure.
- Review logs for secrets and identifiers.
- Test failure recovery and service isolation.
- Document mitigations and retest.

## Deliverables

- Architecture diagrams for 4G and 5G.
- Reproducible deployment notes with pinned versions.
- Sanitized example traces.
- A threat model and defensive test report.
- A glossary distinguishing radio visibility, authentication, authorization, session setup, and Internet reachability.

## Not in this lab

No public-spectrum transmission, commercial network attachment, rogue-cell operation, interception of third-party traffic, denial of service, or attempts to evade carrier access controls.
