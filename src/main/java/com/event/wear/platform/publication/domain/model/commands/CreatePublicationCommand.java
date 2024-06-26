package com.event.wear.platform.publication.domain.model.commands;

import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;

import java.util.List;

public record CreatePublicationCommand (Long userId, String image, String title, String description, Integer price){
}
