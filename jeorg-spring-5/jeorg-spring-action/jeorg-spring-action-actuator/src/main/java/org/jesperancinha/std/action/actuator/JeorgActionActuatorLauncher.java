package org.jesperancinha.std.action.actuator;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.amqp.RabbitHealthIndicator;
import org.springframework.boot.actuate.cassandra.CassandraHealthIndicator;
import org.springframework.boot.actuate.couchbase.CouchbaseHealthIndicator;
import org.springframework.boot.actuate.elasticsearch.ElasticsearchRestHealthIndicator;
import org.springframework.boot.actuate.hazelcast.HazelcastHealthIndicator;
import org.springframework.boot.actuate.health.PingHealthIndicator;
import org.springframework.boot.actuate.influx.InfluxDbHealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.actuate.jms.JmsHealthIndicator;
import org.springframework.boot.actuate.ldap.LdapHealthIndicator;
import org.springframework.boot.actuate.mail.MailHealthIndicator;
import org.springframework.boot.actuate.mongo.MongoHealthIndicator;
import org.springframework.boot.actuate.neo4j.Neo4jHealthIndicator;
import org.springframework.boot.actuate.redis.RedisHealthIndicator;
import org.springframework.boot.actuate.solr.SolrHealthIndicator;
import org.springframework.boot.actuate.system.DiskSpaceHealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootApplication
public class JeorgActionActuatorLauncher implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionActuatorLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ConsolerizerComposer.outSpace()
                .cyan(title("All Health Indicators Available in the Actuator by default"))
                .magenta(CassandraHealthIndicator.class)
                .magenta(CouchbaseHealthIndicator.class)
                .magenta(DataSourceHealthIndicator.class)
                .magenta(DiskSpaceHealthIndicator.class)
                .magenta(ElasticsearchRestHealthIndicator.class)
                .magenta(HazelcastHealthIndicator.class)
                .magenta(InfluxDbHealthIndicator.class)
                .magenta(JmsHealthIndicator.class)
                .magenta(LdapHealthIndicator.class)
                .magenta(MailHealthIndicator.class)
                .magenta(MongoHealthIndicator.class)
                .magenta(Neo4jHealthIndicator.class)
                .magenta(PingHealthIndicator.class)
                .magenta(RabbitHealthIndicator.class)
                .magenta(RedisHealthIndicator.class)
                .magenta(SolrHealthIndicator.class)
                .reset();

    }
}
