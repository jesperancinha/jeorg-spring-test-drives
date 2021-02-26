package org.jesperancinha.std.flash29.security.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FlashUser {
    private String name;
    private String password;
    private List<String> roles;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashUser)) return false;
        FlashUser flashUser = (FlashUser) o;
        return getName().equals(flashUser.getName()) && getPassword().equals(flashUser.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public static class FlashUserBuilder {
        private String name;
        private String password;
        private List<String> roles;

        public static FlashUserBuilder flashUserBuilder() {
            return new FlashUserBuilder();
        }

        public FlashUserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FlashUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public FlashUserBuilder roles(String ... roles) {
            this.roles = Arrays.asList(roles);
            return this;
        }

        public FlashUser build() {
            final var flashUser = new FlashUser();
            flashUser.setName(name);
            flashUser.setPassword(password);
            flashUser.setRoles(roles);
            return flashUser;
        }
    }
}
