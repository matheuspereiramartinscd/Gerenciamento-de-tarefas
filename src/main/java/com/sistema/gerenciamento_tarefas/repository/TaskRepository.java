package com.sistema.gerenciamento_tarefas.repository;

import com.sistema.gerenciamento_tarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Podemos adicionar consultas personalizadas aqui, se necessário
}
