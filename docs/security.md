# Security and privacy model

## Allowed scope

FBA is designed for:
- networks the device owner is authorized to use;
- the user's own router, lab, or test devices;
- community networks operated with permission;
- passive observation of connectivity metadata exposed by Android;
- virtualized cellular-network learning labs that do not transmit over public spectrum.

## Explicit non-goals

FBA will not implement:
- bypasses for SIM, USIM, carrier, or Wi-Fi authentication;
- rogue base stations or subscriber impersonation;
- interception or decryption of other people's communications;
- jamming, disruption, or unauthorized radio transmission;
- credential harvesting or stealth access to networks.

## Data minimization

The app should not collect:
- packet payloads;
- browsing destinations or app usage;
- phone numbers, IMSI/SUPI, ICCID, or authentication keys;
- location data unless a future feature truly requires it and the user explicitly opts in.

Operational diagnostics should be stored locally by default. Any future export must be opt-in and clearly previewed.

## Reporting vulnerabilities

Do not test against networks or services without authorization. For a suspected issue, reproduce it in a controlled lab and follow the affected provider's coordinated disclosure process.
