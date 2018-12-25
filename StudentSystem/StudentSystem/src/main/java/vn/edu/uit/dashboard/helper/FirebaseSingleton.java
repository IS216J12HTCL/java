package vn.edu.uit.dashboard.helper;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseSingleton {

	private static FirebaseSingleton instance = null;
	private static FirebaseDatabase database = null;
	
	private FirebaseSingleton() {
		// Exists only to defeat instantiation.
	}

	public static FirebaseDatabase instance() {
		if (instance == null) {
			instance = new FirebaseSingleton();
			instance.init();
		}
		return database;
	}
	
	private void init() {
		try {
			//String keyPath = config.getJsonKeyPath();
		 	Path currentRelativePath = Paths.get("");
		 	String path = currentRelativePath.toAbsolutePath().toString();
			String keyPath = String.format("%s/%s", path,"eteacher-2018-firebase-adminsdk-wgrwr-e1103ffdc6.json");
			FileInputStream key = new FileInputStream(
					keyPath);
			FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(key))
					  .setDatabaseUrl("https://eteacher-2018.firebaseio.com")
					  .build();
			FirebaseApp.initializeApp(options);
			
			database = FirebaseDatabase.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			instance = null;
			e.printStackTrace();
		}
	}
}