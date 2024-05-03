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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import mongoDB.model.Provincia;

public class ControladorProvincia {
	
	public static MongoCollection<Document> getMongoCollectionProvincia(){
		// Mongodb inicializando parámetros.
        int port_no = 27017;
        String host_name = "localhost", db_name = "ComunidadesProvinciasPoblaciones", 
        		db_coll_name = "provincias";
 
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
	
	public static List<Provincia> getAllCcaa(MongoCollection<Document> col) {
        System.out.println("Obteniendo todas las ccaa de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<Provincia> allCcaa = new ArrayList<Provincia>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToProvincia(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allCcaa;
    }
	
	// Filtrar documentos dentro de una colección.
    public static Provincia getSelectiveDocument(MongoCollection<Document> col, String strCode) {
    	
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.eq("code", strCode));        
        MongoCursor<Document> cursor = fi.iterator();
        Provincia p = new Provincia();
        try {
            while(cursor.hasNext()) {
            	p = documentToProvincia(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return p;
    }
	
	public static Provincia documentToProvincia(Document doc) {
    	Provincia provincia = new Provincia();
    	provincia.setParent_code(doc.getString("parent_code"));
    	provincia.setCode(doc.getString("code"));
    	provincia.setLabel(doc.getString("label"));
    	return provincia;
    }
	
	public static void updateDocument (MongoCollection<Document> col,String code, String label, String parent_code) {
        try {
        	Document query = new Document().append("code",  code);
        	Bson update = Updates.combine(Updates.set("label", label));
        	Bson update2 = Updates.combine(Updates.set("parent_code", parent_code));
        	UpdateResult result = col.updateOne(query, update);
        	UpdateResult resultado = col.updateOne(query, update2);
        	
        	System.out.println("Modificados");
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }

}
