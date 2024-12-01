package com.sistema.gerenciamento_tarefas.controller;

import com.sistema.gerenciamento_tarefas.model.Task;
import com.sistema.gerenciamento_tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost") // Permite requisições do frontend
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> listarTarefas() {
        return taskService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Task> task = taskService.buscarTarefaPorId(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Task> criarTarefa(@RequestBody Task task) {
        Task novaTarefa = taskService.criarTarefa(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTarefa(@PathVariable Long id, @RequestBody Task task) {
        Task tarefaAtualizada = taskService.atualizarTarefa(id, task);
        return tarefaAtualizada != null ? ResponseEntity.ok(tarefaAtualizada)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        boolean isDeleted = taskService.deletarTarefa(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
