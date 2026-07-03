package io.cucumber.models;

import java.util.Objects;

public class UserRecord {

    private final String lastName;
    private final String firstName;
    private final String email;
    private final String due;
    private final String website;

    public UserRecord(String lastName,
                      String firstName,
                      String email,
                      String due,
                      String website) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRecord)) return false;
        UserRecord that = (UserRecord) o;
        return Objects.equals(lastName, that.lastName)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(email, that.email)
                && Objects.equals(due, that.due)
                && Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, email, due, website);
    }
}