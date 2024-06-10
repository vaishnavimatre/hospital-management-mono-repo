package delete_patient;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class DeletePatientScreen {
	
			public static void showDeletePatientScreen() {
				try {
				
					
					Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\delete_patient\\delete patient.fxml"));
		        StageFactory.stage.setTitle("DeletePatient Screen");
				Scene scene=new Scene(actorGroup,600,400);
			     StageFactory.stage.setScene(scene);
			    StageFactory.stage.setFullScreen(true);;
				StageFactory.stage.show();
				
				
			}catch (Exception e){
				e.printStackTrace();
			}
			}
		}




