package com.example.enums;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    String permission;

    UserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
