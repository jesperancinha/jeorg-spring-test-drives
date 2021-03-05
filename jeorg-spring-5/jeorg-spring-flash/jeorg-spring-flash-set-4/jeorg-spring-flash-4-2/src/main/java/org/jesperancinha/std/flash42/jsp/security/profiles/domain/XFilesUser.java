package org.jesperancinha.std.flash42.jsp.security.profiles.domain;

import java.util.Objects;

public class XFilesUser {
    private String name;
    private String password;
    private String role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XFilesUser)) return false;
        XFilesUser XFilesUser = (XFilesUser) o;
        return getName().equals(XFilesUser.getName()) && getPassword().equals(XFilesUser.getPassword());
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

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static class FlashUserBuilder {
        private String name;
        private String password;
        private String role;

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

        public FlashUserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public XFilesUser build() {
            final var flashUser = new XFilesUser();
            flashUser.setName(name);
            flashUser.setPassword(password);
            flashUser.setRole(role);
            return flashUser;
        }
    }
}
