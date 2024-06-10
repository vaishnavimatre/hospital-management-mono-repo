package delete_case;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DeleteCaseScreen {
			public static void showDeleteCaseScreen() {
				try {
				
					
					Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\delete_case\\delete case.fxml"));
		        StageFactory.stage.setTitle("DeleteCase Screen");
				Scene scene=new Scene(actorGroup,600,400);
			     StageFactory.stage.setScene(scene);
			    StageFactory.stage.setFullScreen(true);;
				StageFactory.stage.show();
				
				
			}catch (Exception e){
				e.printStackTrace();
			}
			}
		}


