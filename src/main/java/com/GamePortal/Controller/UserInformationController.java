package com.GamePortal.Controller;

import com.GamePortal.Entity.GameInformation;
import com.GamePortal.Entity.UserInformation;
import com.GamePortal.Service.GameInformationService;
import com.GamePortal.Service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/add/user")
    public String addUserInformation(@RequestBody UserInformation userInformation) {
        return userInformationService.addUserInformation(userInformation);
    }

    @PutMapping("/update/user")
    public String updateUserInformation(@RequestBody UserInformation userInformation) {
        return userInformationService.updateUserInformation(userInformation);
    }

    @DeleteMapping("/delete/user/{id}")
    public String deleteUserInformation(@PathVariable Long id) {
        return userInformationService.deleteUserInformation(id);
    }

    @RequestMapping("/get/user/{id}")
    public UserInformation getUserInformation(@PathVariable Long id) {
        return userInformationService.getUserInformation(id);
    }
}
