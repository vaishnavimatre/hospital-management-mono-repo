package add_case;


import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class AddCaseScreen {
	
	


		public static void showAddCaseScreen() {
			try {
			
				
				Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\add_case\\add case.fxml"));
	        StageFactory.stage.setTitle("AddCase Screen");
			Scene scene=new Scene(actorGroup,600,400);
		     StageFactory.stage.setScene(scene);
		    StageFactory.stage.setFullScreen(true);;
			StageFactory.stage.show();
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		}
	}

