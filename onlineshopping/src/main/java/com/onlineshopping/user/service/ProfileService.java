package com.onlineshopping.user.service;

import java.util.List;



import com.onlineshopping.user.entity.Profile;



public interface ProfileService {
public List<Profile> getProfiles();

public List<Profile> findByName(String prname);

public void save(Profile profile);

public Profile updateProfile(Profile profile);



}