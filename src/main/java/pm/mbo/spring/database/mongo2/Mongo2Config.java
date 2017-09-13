package pm.mbo.spring.database.mongo2;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pm.mbo.spring.database.mongo2.repo.UserMongo2Repository;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(
        basePackageClasses = {UserMongo2Repository.class}
)
public class Mongo2Config {

    @Bean
    @ConfigurationProperties("app.datasource.mongo2")
    public MongoProperties mongo2Properties() {
        return new MongoProperties();
    }

    @Bean
    public MongoClient mongo(final ObjectProvider<MongoClientOptions> options, final Environment environment) throws UnknownHostException {
        return mongo2Properties().createMongoClient(options.getIfAvailable(), environment);
    }

}
