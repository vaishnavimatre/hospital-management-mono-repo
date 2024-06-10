package edit_appointment;


import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class EditAppointmentScreen {

				public static void showEditAppointmentScreen() {
					try {
					
						
						Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\edit_appointment\\update appointment.fxml"));
			        StageFactory.stage.setTitle("EditAppointment Screen");
					Scene scene=new Scene(actorGroup,600,400);
				     StageFactory.stage.setScene(scene);
				    StageFactory.stage.setFullScreen(true);;
					StageFactory.stage.show();
					
					
				}catch (Exception e){
					e.printStackTrace();
				}
				}
			}





