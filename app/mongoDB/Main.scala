package mongoDB
import com.mongodb.connection.ClusterSettings
import org.mongodb.scala._
import scala.collection.JavaConverters._
object Main {
  def main(args: Array[String]): Unit = {
    // To directly connect to the default server localhost on port 27017
    val mongoClient: MongoClient = MongoClient()

    // Use a Connection String
    val mongoClient1: MongoClient = MongoClient("mongodb://localhost")

    // or provide custom MongoClientSettings
    val clusterSettings: ClusterSettings = ClusterSettings.builder().hosts(List(new ServerAddress("localhost")).asJava).build()
    val settings: MongoClientSettings = MongoClientSettings.builder().clusterSettings(clusterSettings).build()
    val mongoClient2: MongoClient = MongoClient(settings)

    val database: MongoDatabase = mongoClient2.getDatabase("test")

    val collection: MongoCollection[Document] = database.getCollection("db.persons")
    print(collection.find().first())

  }
}
