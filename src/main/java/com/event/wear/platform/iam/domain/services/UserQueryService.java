package com.event.wear.platform.iam.domain.services;

import com.event.wear.platform.iam.domain.model.aggregates.User;
import com.event.wear.platform.iam.domain.model.queries.GetAllUsersQuery;
import com.event.wear.platform.iam.domain.model.queries.GetUserByIdQuery;
import com.event.wear.platform.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
  List<User> handle(GetAllUsersQuery query);
  Optional<User> handle(GetUserByIdQuery query);
  Optional<User> handle(GetUserByUsernameQuery query);
}
