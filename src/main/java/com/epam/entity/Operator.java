package com.epam.entity;

public class Operator {
    int id;
    String email;
    String login;
    String password;
    int opTypeId;

    public int getOpTypeId() {
        return opTypeId;
    }

    public void setOpTypeId(int opTypeId) {
        this.opTypeId = opTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;

        Operator operator = (Operator) o;

        if (id != operator.id) return false;
        if (opTypeId != operator.opTypeId) return false;
        if (email != null ? !email.equals(operator.email) : operator.email != null) return false;
        if (login != null ? !login.equals(operator.login) : operator.login != null) return false;
        return password != null ? password.equals(operator.password) : operator.password == null;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", opTypeId=" + opTypeId +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + opTypeId;
        return result;
    }
}
