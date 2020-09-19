package com.nowyouseeme.awsVeil.service;

import com.nowyouseeme.awsVeil.bucket.BucketName;
import com.nowyouseeme.awsVeil.filestore.FileStore;
import com.nowyouseeme.awsVeil.model.UserProfile;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Repository
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;

        this.fileStore = fileStore;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        if(file.isEmpty()) {
            throw new IllegalStateException("could not upload empty file");
        }

        if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("file must be an image");
        }

        UserProfile user = userProfileDataAccessService.getUserProfiles().stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfile))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("userprofile not found"));

        // the metadate to pass to our method
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.PROFILE_NAME.getBucketName(), user.getUserProfileId());

        String fileName = String.format("%s-%s", file.getName(), UUID.randomUUID());

        // path will be the bucket to store the images there
        try {
            fileStore.save(path, fileName, Optional.of(metaData), file.getInputStream());

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
