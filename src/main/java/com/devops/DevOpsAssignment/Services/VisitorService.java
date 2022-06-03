package com.devops.DevOpsAssignment.Services;

import com.devops.DevOpsAssignment.Entities.Visitor;
import com.devops.DevOpsAssignment.Repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public Optional<Visitor> getVisitorById(Long visitorId) {
        return visitorRepository.findById(visitorId);
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }
}
