package com.devops.DevOpsAssignment;

public class VisitorNotFoundException extends RuntimeException{
    public VisitorNotFoundException(Long id) {
        super("Could not find visitor " + id);
    }
}
