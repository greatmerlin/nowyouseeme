package com.nowyouseeme.awsVeil.datastore;

import com.nowyouseeme.awsVeil.model.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    // dummy profiles to test
    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Theo", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Chris", null));
    }
}