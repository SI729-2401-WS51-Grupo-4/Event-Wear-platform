package com.event.wear.platform.profiles.domain.services;

import com.event.wear.platform.profiles.domain.model.aggregates.Profile;
import com.event.wear.platform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
  Optional<Profile> handle(CreateProfileCommand command);
}