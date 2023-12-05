package com.portfolio.api.service;

import com.portfolio.api.dto.ProfileDto;
import com.portfolio.api.entity.Profile;
import com.portfolio.api.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProfileService implements IService<Profile, ProfileDto> {

    @Autowired
    ProfileRepository profileRepository;


    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile add(ProfileDto entity) {
        Profile profile = new Profile();
        profile.setDescription(entity.getDescription());
        profile.setName(entity.getName());
        profile.setProfile_img(entity.getProfile_img());
        
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Integer id, ProfileDto entity) throws NotFoundException {
        
        Profile profile = this.findById(id);

        profile.setDescription(entity.getDescription());
        profile.setName(entity.getName());
        profile.setProfile_img(entity.getProfile_img());
        
        return profileRepository.save(profile);
    }

    @Override
    public Profile delete(Integer id) throws NotFoundException {
        Profile profile = this.findById(id);
        profileRepository.deleteById(id);
        return profile;
    }

    @Override
    public Profile findById(Integer id) throws NotFoundException {
        Optional<Profile> profile = profileRepository.findById(id);
        if (!profile.isPresent()) {
            throw new NotFoundException();
        }
        return profile.get();
    }

}
