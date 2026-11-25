# FBA roadmap

## Phase 0 — Research foundation
- [x] Establish repository and Android observer prototype
- [x] Define cellular architecture research scope
- [x] Add 4G/5G architecture guide
- [x] Add defensive security methodology
- [x] Add isolated virtual lab plan

## Phase 1 — Understand the network
- [ ] Produce a 4G EPC component diagram
- [ ] Produce a 5G Core component diagram
- [ ] Explain control plane vs user plane
- [ ] Document discovery, authentication, authorization, session setup, and routing as separate stages
- [ ] Build a glossary of cellular and IP networking terms
- [ ] Add links to primary standards and project documentation

## Phase 2 — Build the virtual lab
- [ ] Select compatible versions of Open5GS, srsRAN, and/or UERANSIM
- [ ] Document host requirements and isolated network topology
- [ ] Deploy a core-only virtual environment
- [ ] Use synthetic subscriber data
- [ ] Add simulated access in a fully virtual lab
- [ ] Capture and annotate lab-generated traces

## Phase 3 — Defensive security research
- [ ] Create a threat model for the virtual lab
- [ ] Review management-plane isolation
- [ ] Review credentials, certificates, and secrets handling
- [ ] Review logs for sensitive data leakage
- [ ] Test failure recovery and service isolation
- [ ] Publish findings with mitigations and retest evidence

## Phase 4 — Connectivity beyond traditional carriers
- [ ] Compare community network architectures
- [ ] Study mesh routing and gateway limitations
- [ ] Study OpenWrt multi-WAN failover and load balancing
- [ ] Compare MPTCP, multipath QUIC, and VPN-based aggregation
- [ ] Prototype only with links and endpoints controlled by the project

## Phase 5 — Android observer as a field instrument
- [ ] Add privacy-preserving connection history
- [ ] Add bounded HTTPS reachability diagnostics
- [ ] Compare Android-reported transport with measured Internet reachability
- [ ] Export sanitized diagnostic reports

## Definition of done

Every practical experiment must have a documented scope, reproducible environment, synthetic or authorized data, expected result, failure behavior, and defensive conclusion. No result should be described as a vulnerability without evidence and a realistic threat model.
