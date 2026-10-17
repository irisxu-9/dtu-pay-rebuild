# DTU Pay — Product Backlog

## Purpose

This document tracks the incremental development of DTU Pay Rebuild.

Each milestone should deliver a clearly defined and verifiable improvement. Planned features are not considered implemented until their acceptance criteria are met.

## v0.1.0 — Project Foundation

**Goal:** Establish a reproducible Java backend project with basic testing and continuous integration.

### Acceptance Checklist

- [x] Set up Java 21 and Quarkus
- [x] Add Maven Wrapper
- [x] Implement a basic REST endpoint
- [x] Add an automated REST endpoint test
- [x] Enable a health endpoint
- [x] Run Maven `clean verify` locally
- [x] Configure GitHub Actions CI
- [x] Verify CI succeeds for the foundation PR and main branch
- [x] Prepare README, ADR, and Backlog documentation
- [ ] Publish GitHub Release `v0.1.0`

### Known Limitations

- `PaymentService.pay()` is not implemented.
- `PaymentServiceTest` is disabled.
- Default Maven verification skips packaged integration tests.
- No real payment processing is available.

## v0.2.0 — Requirements and Domain Modeling

**Goal:** Understand the payment domain before implementing business workflows.

### Planned Work

- Identify Customer, Merchant, Payment, and Token concepts
- Write user stories and acceptance criteria
- Conduct Event Storming
- Define domain boundaries and responsibilities
- Document initial API contracts
- Record important architecture decisions

### Acceptance Criteria

- Main actors and payment use cases are documented.
- Core domain terminology is defined consistently.
- The proposed domain model can support the first payment MVP.

## v0.3.0 — Simple Payment MVP

### PAY-001: Execute a Basic Payment

**User Story**

As a merchant, I want to initiate a payment so that a customer's payment can be processed.

**Planned Scope**

- In-memory customer and merchant accounts
- Basic payment validation
- A FakeBank or simulated payment mechanism
- Successful and rejected payment scenarios
- Automated tests

**Acceptance Criteria**

- A valid payment updates the simulated account balances.
- Payment amounts must be positive.
- Invalid payment requests are rejected.
- Failed payments must not cause partial balance updates.
- Tests verify successful and unsuccessful scenarios.

**Example**

Given a customer balance of 1000 and a merchant balance of 200, when a valid payment of 100 succeeds, the resulting balances are 900 and 300.

Token authorization is not required in this milestone.

## v0.4.0 — SOAP Bank Integration

**Goal:** Integrate the application with a SOAP-based bank interface.

**Acceptance Criteria**

- A bank client can communicate with the required SOAP interface.
- Bank errors are handled and tested.
- Bank integration remains separate from the core payment rules.

## v0.5.0 — Token Management

### TOKEN-001: Authorize Payment Using a Token

**User Story**

As a customer, I want to authorize payments using tokens without revealing my account identifier to the merchant.

**Acceptance Criteria**

- Customers can request payment tokens.
- Tokens are associated with the correct customer.
- A valid unused token can authorize a payment.
- A consumed token cannot be reused.
- Invalid or unknown tokens are rejected.
- Token issuance limits are enforced according to the agreed requirements.
- Tests verify successful use, reuse rejection, and invalid tokens.

**Test Follow-Up**

The existing disabled `PaymentServiceTest.successfulPaymentTransfersMoneyAndConsumesToken` combines payment transfer and token consumption.

During v0.3.0, separate basic payment behavior into independently testable scenarios. Enable the token-related acceptance criteria when token functionality is implemented in v0.5.0.

## Later Milestones

| Version | Focus |
|---|---|
| v0.6.0 | Microservice decomposition and Docker |
| v0.7.0 | RabbitMQ and asynchronous communication |
| v0.8.0 | Idempotency, failure handling, persistence, reliability |
| v0.9.0 | Payment reporting and refunds |
| v0.10.0 | CI/CD improvements, Jenkins, security, observability |
| v1.0.0 | Final documentation, demonstration, interview preparation |

## Definition of Done

A feature is considered complete when:

- Its acceptance criteria are satisfied.
- Relevant automated tests pass.
- The default Maven build succeeds.
- The implementation is committed to Git.
- Required documentation is updated.
- CI passes on the relevant commit.

## Development Principles

- Implement features incrementally.
- Keep future features separate from completed functionality.
- Use automated tests to guide development.
- Document significant engineering decisions.
- Prefer simple designs until additional complexity is justified.