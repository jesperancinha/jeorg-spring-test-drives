package org.jesperancinha.std.mastery2.portuguese.music.configuration;

import java.util.Objects;

public class Mastery2User {
    private String name;
    private String password;
    private String role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mastery2User)) return false;
        Mastery2User mastery2User = (Mastery2User) o;
        return getName().equals(mastery2User.getName()) && getPassword().equals(mastery2User.getPassword());
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

    public static class Mastery2UserBuilder {
        private String name;
        private String password;
        private String role;

        public static Mastery2UserBuilder flashUserBuilder() {
            return new Mastery2UserBuilder();
        }

        public Mastery2UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Mastery2UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Mastery2UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public Mastery2User build() {
            final var flashUser = new Mastery2User();
            flashUser.setName(name);
            flashUser.setPassword(password);
            flashUser.setRole(role);
            return flashUser;
        }
    }
}
