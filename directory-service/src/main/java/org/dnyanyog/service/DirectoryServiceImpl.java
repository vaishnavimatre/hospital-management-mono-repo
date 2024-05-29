package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.DirectoryServiceRequest;
import org.dnyanyog.dto.DirectoryServiceResponse;
import org.dnyanyog.encrypt.EncryptionUtils;
import org.dnyanyog.entity.Directory;

import org.dnyanyog.enumm.ResponseCode;
import org.dnyanyog.repo.DirectoryServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DirectoryServiceImpl implements DirectoryService{

  @Autowired DirectoryServiceRepository userRepo;
  @Autowired DirectoryServiceResponse response;

  @Autowired EncryptionUtils encrypt;

  public DirectoryServiceResponse addUser(DirectoryServiceRequest request) throws Exception {

    Directory UsersTable =
        Directory.getInstance()
            .setConfirm(request.getConfirm())
            .setMobno(request.getMobno())
            .setEmail(request.getEmail())
            .setPassword(encrypt.encrypt(request.getPassword()))
            .setUsername(request.getUsername())
            .setRole(request.getRole());

    UsersTable = userRepo.save(UsersTable);

    response
        .getInstance()
        .setMessage(ResponseCode.Add_User_Success.getMessage())
        .setStatus(ResponseCode.Add_User_Success.getStatus())
        .setMobno(UsersTable.getMobno())
        .setRole(UsersTable.getRole())
        .setPassword(UsersTable.getPassword())
        .setConfirm(UsersTable.getConfirm())
        .setEmail(UsersTable.getEmail())
        .setUserid(UsersTable.getUserid());

    return response;
  }

  public DirectoryServiceResponse updateUser(Long userid, DirectoryServiceRequest request)
      throws Exception {
    Optional<Directory> receiveData = userRepo.findById(userid);
    if (receiveData.isEmpty()) {
      response
          .getInstance()
          .setMessage(ResponseCode.Update_User_Fail.getMessage())
          .setStatus(ResponseCode.Update_User_Fail.getStatus())
          .setUserid(userid);
    } else {
      Directory user = receiveData.get();
      response
          .getInstance()
          .setMessage(ResponseCode.Update_User_Success.getMessage())
          .setStatus(ResponseCode.Update_User_Success.getStatus())
          .setMobno(request.getMobno())
          .setRole(request.getRole())
          .setPassword(request.getPassword())
          .setConfirm(request.getConfirm())
          .setEmail(request.getEmail())
          .setUserid(request.getUserid());
    }

    return response;
  }

  public DirectoryServiceResponse getSingleUser(Long userid) throws Exception {
    Optional<Directory> receiveData = userRepo.findById(userid);
    if (receiveData.isEmpty()) {
      response
          .getInstance()
          .setMessage(ResponseCode.Check_User_Fail.getMessage())
          .setStatus(ResponseCode.Check_User_Fail.getStatus())
          .setUserid(userid);
    } else {
      Directory user = receiveData.get();
      response
          .getInstance()
          .setMessage(ResponseCode.Check_User_Success.getMessage())
          .setStatus(ResponseCode.Check_User_Success.getStatus())
          .setUsername(user.getUsername())
          .setEmail(user.getEmail())
          .setMobno(user.getMobno())
          .setRole(user.getRole())
          .setPassword(user.getPassword())
          .setConfirm(user.getConfirm());
    }
    return response;
  }

  public DirectoryServiceResponse Deleteuser(Long userid) throws Exception {
    Optional<Directory> receiveData = userRepo.findById(userid);
    if (receiveData.isPresent()) {
      userRepo.deleteById(userid);
      response
          .getInstance()
          .setMessage(ResponseCode.Delete_User_Success.getMessage())
          .setStatus(ResponseCode.Delete_User_Success.getStatus())
          .setUserid(userid);
    }
    response
        .getInstance()
        .setMessage(ResponseCode.Delete_User_Fail.getMessage())
        .setStatus(ResponseCode.Delete_User_Fail.getStatus())
        .setUserid(userid);

    return response;
  }
}
