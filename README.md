### How to run

1) `docker run --publish=7474:7474 --publish=7687:7687 --env NEO4J_AUTH=neo4j/secret neo4j:3.1.2`

2) Clone this project from GitHub

3) `cd neo4j-tree-example && mvn spring-boot:run`


This project is based on: https://github.com/neo4j/neo4j-ogm/blob/master/neo4j-ogm-tests/neo4j-ogm-integration-tests/src/test/java/org/neo4j/ogm/persistence/examples/tree/TreeIntegrationTest.java