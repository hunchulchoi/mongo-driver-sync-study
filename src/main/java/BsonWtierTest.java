import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import model.Person;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;

public class BsonWtierTest {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create();

        MongoDatabase test = mongoClient.getDatabase("test");

        test.getCollection("test_collection-");


        Person person = new Person();


    }
}
