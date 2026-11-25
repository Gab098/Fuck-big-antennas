# Fuck Big Antennas (FBA)

**An independent research project on cellular infrastructure, network security, and alternative connectivity.**

FBA aims to understand how mobile networks provide Internet access, how their components and trust boundaries fit together, and how connectivity can be made more resilient through legitimate, community-operated infrastructure.

The Android monitor remains a supporting tool for observing the connectivity available to a device. It is no longer the project's central goal.

## Research pillars

1. **Cellular architecture** — radio access networks, backhaul, 4G EPC, 5G Core, subscriber identity, authentication, authorization, sessions, routing, roaming, and handover.
2. **Security research** — threat models, configuration review, protocol study, defensive validation, and responsible reporting in systems we own or are explicitly authorized to test.
3. **Virtual lab** — isolated mobile-core and simulated-access experiments using synthetic identities and lab-generated traffic.
4. **Alternative connectivity** — community networks, mesh systems, shared gateways, and multi-WAN designs where access is explicitly authorized.

## Important distinction

Radio visibility is not network access. Knowing a frequency, cell identifier, network name, or protocol does not grant a subscription or permission to use an operator's service. FBA does not aim to bypass carrier authentication or billing, impersonate live cells, intercept private communications, or disrupt radio service.

## Repository map

```text
android/       Android connectivity observer (supporting tool)
docs/
  architecture.md
  cellular-network-architecture.md
  security-research-methodology.md
  virtual-lab.md
  android-platform.md
  security.md
  roadmap.md
  research-index.md
```

## Start here

- [Cellular network architecture](docs/cellular-network-architecture.md)
- [Security research methodology](docs/security-research-methodology.md)
- [Isolated virtual lab plan](docs/virtual-lab.md)
- [Project roadmap](docs/roadmap.md)
- [Research index and references](docs/research-index.md)

## Android observer

The existing Android prototype reads the system's default network and reports transport and capabilities exposed by Android. It is a diagnostic companion, not a cellular base station, modem controller, VPN, or carrier-access tool.

## Working principles

- Work only on systems we own or have explicit permission to test.
- Keep cellular experiments virtual or isolated; no public-spectrum transmission.
- Use synthetic identities and sanitized traces in lab work.
- Never collect subscriber secrets, personal identifiers, or private payloads.
- Separate verified facts from hypotheses.
- Publish defensive findings with evidence and mitigations.

## License

Not selected yet. Until a license is added, all rights are reserved by the repository owner. Do not assume this project is open-source licensed.
