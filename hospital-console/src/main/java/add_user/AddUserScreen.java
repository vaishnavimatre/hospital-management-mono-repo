package add_user;

import java.net.URL;

import common.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddUserScreen {


	public static void showAddUserScreen() {
		try {
		
			//Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hotelmanagementjavafxdb\\src\\Add_User\\AddUser.HotelReservation.fxml"));
			Parent actorGroup=FXMLLoader.load(new URL("file:\\Users\\VAISHNAVI MATRE\\eclipse-workspace\\hospital-console\\src\\main\\java\\add_user\\add Users.fxml"));
        StageFactory.stage.setTitle("AddUser Screen");
		Scene scene=new Scene(actorGroup,600,400);
	     StageFactory.stage.setScene(scene);
	    StageFactory.stage.setFullScreen(true);;
		StageFactory.stage.show();
		
		
	}catch (Exception e){
		e.printStackTrace();
	}
	}
}
