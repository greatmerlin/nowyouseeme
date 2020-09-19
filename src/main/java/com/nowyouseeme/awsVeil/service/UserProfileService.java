package com.nowyouseeme.awsVeil.service;

import com.nowyouseeme.awsVeil.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
