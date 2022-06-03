package com.devops.DevOpsAssignment.Repositories;

import com.devops.DevOpsAssignment.Entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
