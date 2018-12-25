/**
 * 
 */
package vn.edu.uit.dashboard.configuration;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author Minh Anh
 *
 */
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "eteacher_logs";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
	}

}
