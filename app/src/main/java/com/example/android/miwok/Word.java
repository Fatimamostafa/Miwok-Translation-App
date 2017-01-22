package com.example.android.miwok;

/**
 * Created by Fatima Mostafa on 01-Jan-17.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIED;
    private int mMediaResourceId;

    private static final int NO_IMAGE_PROVIED = -1;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mMediaResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mMediaResourceId = mMediaResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mMediaResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mMediaResourceId = mMediaResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmMediaResourceId() {
        return mMediaResourceId;
    }

    /* Returns whether or not there's an image for this word */

    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIED;
    }
}
