# Description

A [Spring Boot](https://spring.io/) application with [GraphQL](https://graphql.org/) interface.

It models simple Order system allowing to fetch data via GraphQL.

## Prerequsites

* Java 17

## Build

```bash
./mvnw clean install
```

### Examples

The example queries can be executed using the following endpoint: http://localhost:8080/graphiql

```graphql
query {
  orders {
    id,
    items {
      id,
      product {
        id,
        name
      }
    }
  }
}
```