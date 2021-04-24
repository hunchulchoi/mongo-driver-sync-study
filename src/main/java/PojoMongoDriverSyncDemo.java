import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import model.Person;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Slf4j
public class PojoMongoDriverSyncDemo {

    final MongoClientSettings clientSettings;

    public PojoMongoDriverSyncDemo() {

        // create codec registry for POJOs
       clientSettings = MongoClientSettings.builder().codecRegistry(fromRegistries(MongoClientSettings.getDefaultCodecRegistry()
                , fromProviders(PojoCodecProvider.builder().automatic(true).build()))).build();

    }

    public static void main(String[] args) {

        PojoMongoDriverSyncDemo pojoMongoDriverSyncDemo = new PojoMongoDriverSyncDemo();


        //log.info("mongoClient: {}", mongoClient);

        MongoDatabase database = MongoClients.create(pojoMongoDriverSyncDemo.clientSettings).getDatabase("test");

        MongoCollection<Person> test_collection = database.getCollection("test_collection", Person.class);

        Person person = new Person("choi", 44, new Person.Address("gwaknapro", "jeju", "63034"));

        test_collection.insertOne(person);

        System.out.println(test_collection.countDocuments());

        // collection.insertMany(IntStream.range(0, 100).mapToObj(i->new Document("i", i)).collect(Collectors.toList()));

    }


}
