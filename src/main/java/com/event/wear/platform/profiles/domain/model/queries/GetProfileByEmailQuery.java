package com.event.wear.platform.profiles.domain.model.queries;

import com.event.wear.platform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}