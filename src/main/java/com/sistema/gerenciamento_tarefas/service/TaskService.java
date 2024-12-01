package com.sistema.gerenciamento_tarefas.service;

import com.sistema.gerenciamento_tarefas.model.Task;
import com.sistema.gerenciamento_tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listarTarefas() {
        return taskRepository.findAll();
    }

    public Optional<Task> buscarTarefaPorId(Long id) {
        return taskRepository.findById(id);
    }

    public Task criarTarefa(Task task) {
        // Inicializa a data de criação ao criar uma tarefa
        task.setDataCriacao(task.getDataCriacao() != null ? task.getDataCriacao() : LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task atualizarTarefa(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task tarefaExistente = existingTask.get();
            tarefaExistente.setNome(task.getNome());
            tarefaExistente.setDescricao(task.getDescricao());
            tarefaExistente.setStatus(task.getStatus());
            tarefaExistente.setUsuarioAtribuido(task.getUsuarioAtribuido());

            if (task.getStatus() == Task.StatusTask.CONCLUIDA) {
                tarefaExistente.setDataConclusao(LocalDateTime.now()); // Atualiza a data de conclusão
            }

            return taskRepository.save(tarefaExistente);
        }
        return null; // ou lançar uma exceção, se preferir
    }

    public void deletarTarefa(Long id) {
        taskRepository.deleteById(id);
    }
}
