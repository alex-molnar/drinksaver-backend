package com.drinksaver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "repository")
public record RepositoryConfiguration(String alcohol, String beer, String drink, String recommendation) {}
