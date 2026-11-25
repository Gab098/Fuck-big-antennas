# Telecom security research methodology

## Mission

FBA studies how cellular and IP connectivity systems are designed, where trust boundaries exist, and how operators and device vendors can make deployments safer. The work should produce reproducible notes, defensive tests, and clear explanations.

## Research tracks

### A. Architecture and trust boundaries
- Map device, SIM/eSIM, radio access, transport, core, subscriber database, and Internet boundaries.
- Identify which party operates each component.
- Distinguish identity, authentication, authorization, policy, and routing.
- Record what is documented versus what is an implementation-specific assumption.

### B. Configuration and exposure review
For systems owned by the project or explicitly provided for testing:
- Review default credentials and administrative access policy.
- Check whether management interfaces are isolated.
- Review TLS and certificate configuration.
- Check software versions and vendor security advisories.
- Review logging for accidental exposure of identifiers or secrets.
- Verify that test services are not exposed to the public Internet unintentionally.

### C. Protocol understanding
- Read standards and vendor documentation.
- Draw message-flow diagrams from public specifications.
- Build small parsers for synthetic or lab-generated traces.
- Use sanitized example data.
- Explain security properties and limitations without turning the notes into instructions for attacking live networks.

### D. Defensive validation
- Unit-test FBA's own parsing and policy code.
- Test access controls on services FBA owns.
- Validate that diagnostics do not collect payloads or credentials.
- Test failure handling, timeouts, and rate limits.
- Keep a written scope and record of authorization for any external assessment.

## Rules of engagement

Every practical test must have:
1. a named system owner;
2. explicit permission and a written scope;
3. a lab or test environment isolated from public carrier infrastructure;
4. a defined time window and test accounts/data;
5. a stop condition and a contact for incidents;
6. a report that avoids publishing secrets or personal data.

Out of scope: unauthorized network access, bypassing carrier authentication or billing, impersonating live base stations, intercepting private communications, disrupting radio service, or collecting other subscribers' identifiers.

## Finding template

For each finding, record:
- **ID and title**
- **System and version**
- **Authorization / scope**
- **Observation**
- **Expected secure behavior**
- **Impact**
- **Evidence** (sanitized)
- **Reproduction in the owned lab**
- **Mitigation**
- **Retest result**
- **Disclosure status**

## Quality bar

A claim is not a vulnerability merely because a protocol has complexity or a component is reachable. Findings need evidence, a clear threat model, and a realistic impact assessment. Prefer vendor advisories, standards, and reproducible lab results over speculation.
