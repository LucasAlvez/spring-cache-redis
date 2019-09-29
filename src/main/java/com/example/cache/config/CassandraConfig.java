package com.example.cache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;

/**
 * Cassandra configuration.
 */
@Configuration
@Lazy
@ConfigurationProperties(prefix = "spring.data.cassandra")
public class CassandraConfig extends AbstractCassandraConfiguration {

    /**
     * Cassandra contact points.
     */
    private String contactPoints;

    /**
     * Cassandra port.
     */
    private int port;

    /**
     * Cassandra keyspace name.
     */
    private String keyspaceName;

    /**
     * Cassandra username.
     */
    private String username;

    /**
     * Cassandra password.
     */
    private String password;

    @Override
    public String getContactPoints() {
        return contactPoints;
    }

    /**
     * Sets contact points.
     *
     * @param contactPoints the contact points
     */
    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }

    @Override
    public int getPort() {
        return port;
    }

    /**
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getKeyspaceName() {
        return keyspaceName;
    }

    /**
     * Sets keyspace name.
     *
     * @param keyspaceName the keyspace name
     */
    public void setKeyspaceName(String keyspaceName) {
        this.keyspaceName = keyspaceName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets up the cluster configuration.
     *
     * @return An instance of CassandraClusterFactoryBean.
     */
    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {

        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setMetricsEnabled(false);
        cluster.setJmxReportingEnabled(false);
        cluster.setContactPoints(this.contactPoints);
        cluster.setPort(this.port);
        return cluster;
    }
}