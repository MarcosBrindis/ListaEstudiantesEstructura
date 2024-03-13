package models;

import java.util.Objects;

public class Login {
    String name;
    String password;

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Login(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(name, login.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}