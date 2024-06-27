package com.event.wear.platform.iam.domain.services;

import com.event.wear.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
  void handle(SeedRolesCommand command);
}
