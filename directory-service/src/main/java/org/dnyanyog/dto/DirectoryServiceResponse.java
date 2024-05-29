package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class DirectoryServiceResponse {

  private String status;
  private String message;
  

  private long mobno;
  private String role;
  private String password;
  private String confirm;

  private String username;

  public String getUsername() {
    return username;
  }

  public DirectoryServiceResponse setUsername(String username) {
    this.username = username;
    return this;
  }

  

  private long userid;

  

  public long getUserid() {
  return userid;}

  public void setUserid(long userid) {
  this.userid = userid;}


private String email;

  public DirectoryServiceResponse getInstance() {
    return new DirectoryServiceResponse();
  }

  public String getStatus() {
    return status;
  }

  public DirectoryServiceResponse setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public DirectoryServiceResponse setMessage(String message) {
    this.message = message;
    return this;
  }


  public String getEmail() {
    return email;
  }

  public DirectoryServiceResponse setEmail(String email) {
    this.email = email;
    return this;
  }

 
  public long getMobno() {
return mobno;}

public DirectoryServiceResponse setMobno(long mobno) {
this.mobno = mobno;
return this;}

public String getRole() {
    return role;
  }

  public DirectoryServiceResponse setRole(String role) {
    this.role = role;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public DirectoryServiceResponse setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirm() {
    return confirm;
  }

  public DirectoryServiceResponse setConfirm(String confirm) {
    this.confirm = confirm;
    return this;
  }
}
