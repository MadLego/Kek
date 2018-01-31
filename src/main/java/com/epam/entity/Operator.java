package com.epam.entity;

public class Operator {
    int id;
    String email;
    String login;
    String password;
    int op_type_id;

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", op_type_id=" + op_type_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;

        Operator operator = (Operator) o;

        if (id != operator.id) return false;
        if (op_type_id != operator.op_type_id) return false;
        if (!email.equals(operator.email)) return false;
        if (!login.equals(operator.login)) return false;
        return password.equals(operator.password);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + op_type_id;
        return result;
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

    public int getOp_type_id() {
        return op_type_id;
    }

    public void setOp_type_id(int op_type_id) {
        this.op_type_id = op_type_id;
    }
}
