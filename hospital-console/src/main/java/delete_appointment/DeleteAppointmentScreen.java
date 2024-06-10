package delete_appointment;


import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class DeleteAppointmentScreen {
	
				public static void showDeleteAppointmentScreen() {
					try {
					
						
						Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\delete_appointment\\delete appointment.fxml"));
			        StageFactory.stage.setTitle("DeleteAppointment Screen");
					Scene scene=new Scene(actorGroup,600,400);
				     StageFactory.stage.setScene(scene);
				    StageFactory.stage.setFullScreen(true);;
					StageFactory.stage.show();
					
					
				}catch (Exception e){
					e.printStackTrace();
				}
				}
			}




