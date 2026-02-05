
## API Automation Framework
## Project Name : reqres-api-tests

### 1. Project Structure
Project build with Spring, Cucumber and JUnit5 frameworks

Test data and run configuration depends on environment to run

- **BaseApiLibrary** – general REST client configuration (base URL, headers)
- **UsersApiLibrary** – specific implementation for `users` endpoint
- **Step Definitions** – Cucumber steps, using Spring for dependency injection
- **ConfigProperties** – environment-specific configurations and API keys (dev, uat, prod)
- **Feature Files** – BDD-style test scenarios
- **Resources** – environment properties and test data

---

### 2. Scalability

- Easily add new **services** → create new API libraries (`<Service>ApiLibrary`) with base REST client setup.
- Scale to **hundreds of API tests** using Cucumber feature files and reusable step definitions.
- Spring DI allows **shared context and objects** across tests without code duplication.

---

### 3. CI/CD Integration (Jenkins)

- Test execution via Maven:
- Run all tests from "sanity" suite from command line:

```clean compile test -Dcucumber.filter.tags=@sanity -Denv=dev```

By default run at env=dev if -Denv not specified as run parameter (See above)



