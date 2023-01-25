package com.steven.webappdemo1.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {

    public List<TodoTask> findByUsername(String username);
}
