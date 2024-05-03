package mongoDB.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import mongoDB.model.Ccaa;





public class ControladorComunidad {
	
	public static MongoCollection<Document> getMongoCollectionCCAA(){
		// Mongodb inicializando parámetros.
        int port_no = 27017;
        String host_name = "localhost", db_name = "ComunidadesProvinciasPoblaciones", 
        		db_coll_name = "ccaa";
 
        // Mongodb creando la cadena de conexión.
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);
 
        // Conectando y obteniendo un cliente.
        MongoClient mongo_client = new MongoClient(uri);
 
        // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
        
        return coll;
	}
	
	public static List<Ccaa> getAllCcaa(MongoCollection<Document> col) {
        System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Ccaa> allCcaa = new ArrayList<Ccaa>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToCcaa(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allCcaa;
    }
	
	public static Ccaa documentToCcaa(Document doc) {
    	Ccaa ccaa = new Ccaa();
    	ccaa.setParent_code(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
	
	public static void updateDocument (MongoCollection<Document> col,String code, String label) {
        try {
        	Document query = new Document().append("code",  code);
        	Bson update = Updates.combine(Updates.set("label", label));
        	UpdateResult result = col.updateOne(query, update);
        	
        	System.out.println("Modificados: " + result.getModifiedCount());
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }

}
