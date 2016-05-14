package com.spartans.manager;



import partha.mongodb.manager.DBpublicConnector;
import partha.mongodb.manager.MongoInterface;
import com.spartans.utils.ApplicationConstant;

/**
 *
 * @author Partha
 */
public class DBManager {
//set the dbschema here.
//In the example I have set in the Application Constants,Please do Change to the required
    
    public static MongoInterface getDB() throws Exception {
        String schema = ApplicationConstant.DBSCHEMA;
        String dbUrl = ApplicationConstant.DBURL;
        Integer dbPort = Integer.parseInt(ApplicationConstant.DBPORT);
        MongoInterface db = new DBpublicConnector().getConnection(schema, dbUrl, dbPort);
        return db;
    }
}
