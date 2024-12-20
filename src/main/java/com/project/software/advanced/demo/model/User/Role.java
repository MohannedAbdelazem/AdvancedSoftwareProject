package com.project.software.advanced.demo.model.User;

public enum Role {
    STUDENT,
    INSTRUCTOR,
    ADMIN;

    public static Role fromString(String role) {
        if (role != null) {
            for (Role r : Role.values()) {
                if (r.name().equals(role)) {
                    return r;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant for role: " + role);
    }
}
