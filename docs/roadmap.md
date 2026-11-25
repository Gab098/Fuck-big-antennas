# Roadmap

## Phase 0 — Repository foundation
- [x] Define scope and non-goals
- [x] Create Android app skeleton
- [x] Add default-network observer
- [ ] Add build workflow and project verification

## Phase 1 — Observability
- [ ] Show default transport and validation state
- [ ] Add timestamped connection events
- [ ] Add bounded HTTPS reachability check
- [ ] Add latency sampling with battery-aware intervals
- [ ] Add a diagnostic export with sensitive data excluded

## Phase 2 — Decision support
- [ ] User preferences (metered data, preferred transport)
- [ ] Transparent connection scoring
- [ ] Recommendation explanations
- [ ] Manual refresh and pause controls

## Phase 3 — Supported handoff
- [ ] Research Android network request APIs
- [ ] Prototype user-approved network selection
- [ ] Test behavior across Android versions and OEMs
- [ ] Document limitations for existing app connections

## Phase 4 — Multi-link research
- [ ] Compare Multipath TCP, multipath QUIC, and VPN-based aggregation
- [ ] Design a user-controlled gateway
- [ ] Evaluate server costs, privacy, and failure modes
- [ ] Prototype only with links and endpoints controlled by the tester

## Phase 5 — Community connectivity
- [ ] Document community-network models
- [ ] Explore OpenWrt integration
- [ ] Explore mesh status discovery
- [ ] Keep mesh messaging, local networking, and Internet uplink clearly distinct

## Definition of done

A feature is complete only when it has:
1. documented permissions and platform requirements;
2. tests or reproducible manual test steps;
3. clear failure behavior;
4. no unsupported security or performance claims;
5. a privacy review.
