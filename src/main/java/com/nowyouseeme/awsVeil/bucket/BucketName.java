package com.nowyouseeme.awsVeil.bucket;

public enum BucketName {

    PROFILE_NAME("liftthevail");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
