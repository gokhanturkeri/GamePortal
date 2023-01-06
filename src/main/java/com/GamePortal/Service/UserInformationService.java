package com.GamePortal.Service;

import com.GamePortal.Entity.UserInformation;
import com.GamePortal.Repository.IUserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {

    @Autowired(required = false)
    private IUserInformationRepository UserInformationRepository;

    public String addUserInformation(UserInformation userInformation) {
        UserInformationRepository.save(userInformation);
        return "Yeni kullanıcı veri tabanına kaydedildi";
    }

    public UserInformation getUserInformation(Long id){
        return UserInformationRepository.findById(id).get();
    }

    public String deleteUserInformation(Long id){
        UserInformation userInformation = UserInformationRepository.getById(id);
        UserInformationRepository.delete(userInformation);
        return "Kullanıcı veri tabanından silindi" + "==>" + id;
    }

    public String updateUserInformation(UserInformation userInformation){
        UserInformationRepository.save(userInformation);
        return userInformation.getUserId() + "==>" + "Kullanıcı veri tabanına bilgileri güncellendi";
    }





}
