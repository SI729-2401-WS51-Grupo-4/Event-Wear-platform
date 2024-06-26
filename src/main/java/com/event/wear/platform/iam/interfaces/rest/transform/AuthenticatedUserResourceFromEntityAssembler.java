package com.event.wear.platform.iam.interfaces.rest.transform;

import com.event.wear.platform.iam.domain.model.aggregates.User;
import com.event.wear.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

  public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
    return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
  }
}
