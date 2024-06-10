package case_management;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class CaseManagementScreen {

					public static void showCaseManagementScreen() {
						try {
						
					Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\case_management\\case management.fxml"));
				        StageFactory.stage.setTitle("CaseManagement Screen");
						Scene scene=new Scene(actorGroup,600,400);
					     StageFactory.stage.setScene(scene);
					    StageFactory.stage.setFullScreen(true);;
						StageFactory.stage.show();
						
						
					}catch (Exception e){
						e.printStackTrace();
					}
					}
					}













