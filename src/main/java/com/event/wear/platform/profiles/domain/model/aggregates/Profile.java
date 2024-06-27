package com.event.wear.platform.profiles.domain.model.aggregates;

import com.event.wear.platform.profiles.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import com.event.wear.platform.profiles.domain.model.commands.CreateProfileCommand;
import com.event.wear.platform.profiles.domain.model.valueobjects.EmailAddress;
import com.event.wear.platform.profiles.domain.model.valueobjects.PersonName;
import com.event.wear.platform.profiles.domain.model.valueobjects.StreetAddress;
import com.event.wear.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

  @Embedded
  private PersonName name;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
  EmailAddress email;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "street", column = @Column(name = "address_street")),
          @AttributeOverride(name = "number", column = @Column(name = "address_number")),
          @AttributeOverride(name = "city", column = @Column(name = "address_city")),
          @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
          @AttributeOverride(name = "country", column = @Column(name = "address_country"))})
  private StreetAddress address;

  @Embedded
  UserId userId;

  public Profile(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country, Long userId) {
    this.name = new PersonName(firstName, lastName);
    this.email = new EmailAddress(email);
    this.address = new StreetAddress(street, number, city, postalCode, country);
    this.userId = new UserId(userId);
  }

  public Profile(CreateProfileCommand command) {
    this.name = new PersonName(command.firstName(), command.lastName());
    this.email = new EmailAddress(command.email());
    this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
    this.userId = new UserId(command.userId());
  }

  public Profile() {
  }

  public void updateName(String firstName, String lastName) {
    this.name = new PersonName(firstName, lastName);
  }

  public void updateEmail(String email) {
    this.email = new EmailAddress(email);
  }

  public void updateAddress(String street, String number, String city, String postalCode, String country) {
    this.address = new StreetAddress(street, number, city, postalCode, country);
  }

  public String getFullName() {
    return name.getFullName();
  }

  public String getEmailAddress() {
    return email.address();
  }

  public String getStreetAddress() {
    return address.getStreetAddress();
  }
}