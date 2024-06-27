package com.event.wear.platform.profiles.domain.services;

import com.event.wear.platform.profiles.domain.model.aggregates.Profile;
import com.event.wear.platform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.event.wear.platform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.event.wear.platform.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
  Optional<Profile> handle(GetProfileByEmailQuery query);
  Optional<Profile> handle(GetProfileByIdQuery query);
  List<Profile> handle(GetAllProfilesQuery query);
}
