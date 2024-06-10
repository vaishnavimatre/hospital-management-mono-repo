package search_patient;


import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SearchPatientScreen {
	


			public static void showSearchPatientScreen() {
				try {
				
					
					Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\search_patient\\search patient.fxml"));
		        StageFactory.stage.setTitle("SearchPatient Screen");
				Scene scene=new Scene(actorGroup,600,400);
			     StageFactory.stage.setScene(scene);
			    StageFactory.stage.setFullScreen(true);;
				StageFactory.stage.show();
				
				
			}catch (Exception e){
				e.printStackTrace();
			}
			}
		}


