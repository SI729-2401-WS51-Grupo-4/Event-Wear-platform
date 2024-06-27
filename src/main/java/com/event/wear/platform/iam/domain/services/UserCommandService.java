package com.event.wear.platform.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import com.event.wear.platform.iam.domain.model.aggregates.User;
import com.event.wear.platform.iam.domain.model.commands.SignInCommand;
import com.event.wear.platform.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserCommandService {
  Optional<ImmutablePair<User, String>> handle(SignInCommand command);
  Optional<User> handle(SignUpCommand command);
}
