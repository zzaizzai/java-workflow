package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Integer>  {

}
