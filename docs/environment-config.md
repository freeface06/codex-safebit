# Environment Configuration

The application reads sensitive configuration from environment variables:

- `DB_URL`: JDBC connection string (default `jdbc:h2:mem:safebit`).
- `DB_USERNAME`: Database user (default `sa`).
- `DB_PASSWORD`: Database password (default empty).

Provide these variables in your runtime environment rather than committing
credentials to the repository.
