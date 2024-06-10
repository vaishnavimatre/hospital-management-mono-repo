package dto;

import org.springframework.stereotype.Component;

@Component
public class DirectoryServiceData {
  private long userid;
  private String username;
  private String email;
  private String mobno;
  private String role;
  private String password;
  private String confirm;

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
 
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

 
  public String getMobno() {
return mobno;}

public void setMobno(String mobno) {
this.mobno = mobno;}

public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm() {
    return confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }
}
