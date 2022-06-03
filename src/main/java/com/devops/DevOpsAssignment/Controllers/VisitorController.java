package com.devops.DevOpsAssignment.Controllers;

import com.devops.DevOpsAssignment.Entities.Visitor;
import com.devops.DevOpsAssignment.Repositories.VisitorRepository;

import com.devops.DevOpsAssignment.VisitorNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {

    private final VisitorRepository visitorRepository;
    
    VisitorController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @GetMapping("/visitors")
    List<Visitor> getAll() {
        return visitorRepository.findAll();
    }

    @PostMapping("/visitors")
    Visitor newVisitor(@RequestBody Visitor newVisitor) {
        return visitorRepository.save(newVisitor);
    }

    @GetMapping("/visitors/{id}")
    Visitor getVisitor(@PathVariable Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new VisitorNotFoundException(id));
    }

    @PutMapping("/visitors/{id}")
    Visitor updateVisitor(@RequestBody Visitor newVisitor, @PathVariable Long id) {
        return visitorRepository.findById(id)
                .map(visitor -> {
                    visitor.setFirstName(newVisitor.getFirstName());
                    visitor.setLastName(newVisitor.getLastName());
                    visitor.setEmail(newVisitor.getEmail());
                    visitor.setAddress(newVisitor.getAddress());
                    visitor.setPhoneNumber(newVisitor.getPhoneNumber());
                    return visitorRepository.save(visitor);
                })
                .orElseGet(() -> {
                    newVisitor.setId(id);
                    return visitorRepository.save(newVisitor);
                });
    }

    @DeleteMapping("/visitors/{id}")
    void deleteVisitor(@PathVariable Long id) {
        visitorRepository.deleteById(id);
    }

}
