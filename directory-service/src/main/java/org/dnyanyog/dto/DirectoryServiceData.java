package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class DirectoryServiceData {
  private long userid;
  private String username;
  private String email;
  private long mobno;
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

  public DirectoryServiceData setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getMobno() {
    return mobno;
  }

  public DirectoryServiceData setMobno(long mobno) {
    this.mobno = mobno;
    return this;
  }

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
