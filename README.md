# DTU Pay Rebuild

An independent educational rebuild of a token-based payment system, focused on Java backend development, software architecture, testing, and reliable payment processing.

## Background

This project is inspired by the *02267 Software Development of Web Services* course at the Technical University of Denmark (DTU).

The original DTU Pay system was developed as a team course project in 2024. This repository is an independent rebuild, started in 2026, with an emphasis on understanding engineering decisions and developing the system incrementally.

## Project Status

**Current milestone: v0.1.0 — Project Foundation**

The current implementation provides the technical foundation for future payment functionality.

### Implemented

- Java 21 and Quarkus 3.40.1 project setup
- Maven Wrapper for reproducible builds
- A basic REST endpoint: `GET /hello`
- Application health endpoint: `GET /q/health`
- Automated REST testing with JUnit 5 and REST Assured
- GitHub Actions CI for pushes and pull requests targeting `main`

### Not Yet Implemented

- Customer and merchant registration
- Payment processing
- Token management
- Integration with the external bank
- Refunds and reporting
- Database persistence
- Microservice messaging and deployment

The current `PaymentService` is a placeholder. Its payment test is intentionally disabled until the corresponding business features are implemented.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Main programming language |
| Quarkus 3.40.1 | Application framework |
| Maven / Maven Wrapper | Build and dependency management |
| JUnit 5 | Automated testing |
| REST Assured | REST endpoint testing |
| SmallRye Health | Application health checks |
| GitHub Actions | Continuous integration |

PostgreSQL, RabbitMQ, Docker, SOAP integration, and additional infrastructure are planned for later milestones; they are not part of the current implementation.

## Requirements

- JDK 21
- Git
- An internet connection for the initial Maven dependency download

A separate Maven installation is not required because the repository includes Maven Wrapper.

## Getting Started

Clone the repository or open an existing local checkout.

From the project root directory, start Quarkus development mode on Windows PowerShell:

```powershell
.\mvnw.cmd quarkus:dev
```

The application runs at `http://localhost:8080` by default.

Test the example REST endpoint:

```powershell
Invoke-RestMethod http://localhost:8080/hello
```

Expected response:

```text
Hello from Quarkus REST
```

Check the health endpoint:

```powershell
Invoke-RestMethod http://localhost:8080/q/health
```

Expected health status: `UP`.

Stop development mode with `Ctrl+C`.

## Build and Test

Run the full default Maven verification lifecycle:

```powershell
.\mvnw.cmd clean verify
```

The build compiles the application, executes enabled tests, and packages the Quarkus application.

At the v0.1.0 milestone:

- `GreetingResourceTest` passes.
- `PaymentServiceTest` is temporarily disabled because payment and token functionality are not yet implemented.
- Packaged integration tests are skipped by the current Maven configuration.

On Windows, stop Quarkus development mode before running `clean verify` to avoid possible file-locking problems.

## Packaging and Running

Build the Quarkus application:

**Windows PowerShell:**

```powershell
.\mvnw.cmd clean package
```

**Linux / macOS:**

```bash
./mvnw clean package
```

By default, Quarkus produces the application in the `target/quarkus-app/` directory.

Run the packaged application:

```powershell
java -jar target/quarkus-app/quarkus-run.jar
```

The default Quarkus packaging is not a single executable JAR containing all dependencies. The `target/quarkus-app/` directory also contains the runtime libraries required by the application.

To run the packaged application on another machine, keep the contents of `target/quarkus-app/` together.

Once the application starts, verify the endpoints:

- `http://localhost:8080/hello`
- `http://localhost:8080/q/health`

### Quarkus Developer UI

When running the application using `quarkus:dev`, the Quarkus Developer UI is available at:

`http://localhost:8080/q/dev/`

This developer interface is intended for development mode and is not exposed as part of the normal production application.

For further details, see the [Quarkus official documentation](https://quarkus.io/guides/).

## Continuous Integration

GitHub Actions runs `clean verify` using Java 21:

- When a pull request targets `main`
- When changes are pushed to `main`

Workflow configuration: `.github/workflows/ci.yml`.

## Development Roadmap

| Version | Milestone |
|---|---|
| v0.1.0 | Project foundation, tests, CI, documentation |
| v0.2.0 | Requirements, domain modeling, DDD |
| v0.3.0 | Simple payment MVP using a FakeBank |
| v0.4.0 | SOAP bank integration |
| v0.5.0 | Token management |
| v0.6.0 | Microservices and Docker |
| v0.7.0 | RabbitMQ and asynchronous communication |
| v0.8.0 | Reliability, idempotency, persistence |
| v0.9.0 | Reporting and refunds |
| v0.10.0 | CI/CD, security, observability |
| v1.0.0 | Documentation, demonstration, interview-ready release |

See [Product Backlog](docs/08-backlog/backlog.md) for detailed planned work.

## Architecture Decisions

Architecture decisions are documented using Architecture Decision Records (ADRs).

- [ADR-001: Technology Stack](docs/05-adr/001-technology-stack.md)

## Attribution

Inspired by DTU course 02267 and the original 2024 team project. The goal is to develop and document an independent implementation rather than copy the original team repository.

## Disclaimer

This project is intended for educational purposes. It uses simulated payment concepts and must not be used to process real financial transactions.
