package com.epam.db;

import com.epam.entity.Operator;

public enum  Role {
    ADMIN, DISPATCHER, CLIENT;

    public static Role getRole(Operator operator) {
        int roleId = operator.getOpTypeId();
        System.out.println("Role: "+roleId);
        return Role.values()[roleId-1];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
