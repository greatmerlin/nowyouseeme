package com.nowyouseeme.awsVeil.service;

import com.nowyouseeme.awsVeil.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        //TODO: check if image is not empty
        //TODO: check if file is an image
        //TODO:check whether the user exists in DB, if so some some metadata from file if any
        //TODO: store the image in s3 and update database with s3 image link
    }


}
