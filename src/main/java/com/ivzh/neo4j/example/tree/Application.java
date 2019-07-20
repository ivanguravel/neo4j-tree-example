package com.ivzh.neo4j.example.tree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author ivzh
 */
@SpringBootApplication
@EnableNeo4jRepositories("com.ivzh.neo4j.example.tree.repositories")
public class Application {
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}