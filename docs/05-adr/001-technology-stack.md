# ADR-001: Initial Technology Stack

- **Status:** Accepted
- **Date:** 2026-10-17
- **Scope:** DTU Pay Rebuild v0.1.0

## Context

DTU Pay Rebuild is an educational Java backend project that will evolve from a small REST application into a token-based payment system.

The initial milestone requires a technology stack that supports incremental development, automated testing, reproducible builds, and continuous integration.

The project should remain simple during early milestones while providing a foundation for future service decomposition and bank integration.

## Decision

### 1. Java 21

Use Java 21 as the project's baseline language version.

Reasons:

- It is a long-term support release.
- It provides modern Java language and runtime capabilities.
- It is suitable for building and maintaining backend services.

Trade-off: Developers and CI environments must provide a compatible JDK.

### 2. Quarkus

Use Quarkus 3.40.1 as the initial application framework.

Reasons:

- It supports REST services, dependency injection, testing, and health endpoints.
- It provides a development mode that supports a fast feedback loop.
- It allows the project to start small and introduce additional integrations incrementally.
- It provides continuity with the technologies explored in the original DTU course.

Alternative considered: Spring Boot, a widely adopted Java backend framework with a large ecosystem.

Trade-off: Quarkus-specific tooling and conventions require learning, and some integrations may differ from their Spring Boot equivalents.

### 3. Maven and Maven Wrapper

Use Maven for dependency management and builds, with Maven Wrapper included in the repository.

Reasons:

- The build is described declaratively in `pom.xml`.
- Maven provides standard build and testing lifecycles.
- The wrapper reduces differences between developer environments and CI.

Alternative considered: Gradle.

Trade-off: Maven XML configuration can be verbose, but its conventions are appropriate for this project.

### 4. JUnit 5 and REST Assured

Use JUnit 5 for automated tests and REST Assured for REST endpoint verification.

Reasons:

- Tests can be executed locally and in CI.
- REST endpoints can be tested through HTTP requests.
- The project can add service-level and integration tests as features grow.

The initial payment acceptance test is disabled because the corresponding implementation is outside the scope of v0.1.0.

### 5. GitHub Actions

Use GitHub Actions as the initial continuous integration solution.

Reasons:

- It integrates directly with the GitHub repository.
- It can automatically run the Maven build and tests.
- It avoids maintaining a separate CI server during the foundation stage.

Alternative considered: Jenkins, which remains an option for a later CI/CD milestone.

Trade-off: CI execution depends on GitHub Actions infrastructure and workflow configuration.

## Consequences

### Positive

- Consistent Java and build configuration
- Automated build verification
- A simple starting point for incremental delivery
- A documented and reproducible development workflow

### Limitations

- Business payment functionality is not yet implemented.
- Integration tests are currently skipped by the default Maven configuration.
- Distributed messaging, persistence, and containerized deployment remain future work.
- The initial architecture may need to evolve as domain boundaries become clearer.

## Future Review

Revisit this decision when the project introduces microservices, external bank integration, messaging, persistence, or deployment infrastructure.

Future changes should be recorded in new ADRs rather than rewriting the original historical decision.