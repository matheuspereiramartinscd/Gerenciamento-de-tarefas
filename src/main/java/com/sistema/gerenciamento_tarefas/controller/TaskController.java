package com.sistema.gerenciamento_tarefas.controller;

import com.sistema.gerenciamento_tarefas.model.Task;
import com.sistema.gerenciamento_tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> listarTarefas() {
        return taskService.listarTarefas();
    }

    @GetMapping("/{id}")
    public Optional<Task> buscarTarefaPorId(@PathVariable Long id) {
        return taskService.buscarTarefaPorId(id);
    }

    @PostMapping
    public Task criarTarefa(@RequestBody Task task) {
        return taskService.criarTarefa(task);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        taskService.deletarTarefa(id);
    }
}
