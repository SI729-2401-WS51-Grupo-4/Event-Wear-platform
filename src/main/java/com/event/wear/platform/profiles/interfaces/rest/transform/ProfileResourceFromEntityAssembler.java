package com.event.wear.platform.profiles.interfaces.rest.transform;

import com.event.wear.platform.profiles.domain.model.aggregates.Profile;
import com.event.wear.platform.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
  public static ProfileResource toResourceFromEntity(Profile entity) {
    return new ProfileResource(entity.getId(), entity.getEmailAddress(),
        entity.getFullName(), entity.getStreetAddress());
  }
}
