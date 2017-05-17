package com.niit.DAO;

import com.niit.model.ProfilePicture;

public interface ProfileUploadDAO {
void save(ProfilePicture profilePicture);
ProfilePicture getProfilePic(String username);
}