package login;

import java.sql.SQLException;

import common.RestUtil;
import dashboard.DashBoardScreen;
import dto.LoginRequest;
import dto.LoginResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

  @FXML
  private TextField mobile_number;

  @FXML
  private PasswordField password;

  @FXML
  private Button next_button;

  public void Next_Button(ActionEvent event) throws SQLException {
    boolean loginStatus = ValidatemobileAndpassword(mobile_number.getText(), password.getText());

    if (loginStatus) {
      try {
        DashBoardScreen.showDashboardScreen();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Login Unsuccessful");
    }
  }

  public static boolean ValidatemobileAndpassword(String mobile_number, String password) throws SQLException {
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setMobno(mobile_number);
    loginRequest.setPassword(password);

    LoginResponse response;

    try {
      response = RestUtil.sendPostRequest("http://localhost:8081/api/v1/directory/validate", LoginResponse.class, loginRequest);

      if (response != null ) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;
  }
}
