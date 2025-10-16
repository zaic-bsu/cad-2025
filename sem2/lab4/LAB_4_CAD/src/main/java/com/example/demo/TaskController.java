package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }
    @PostMapping("/addTask")
    public String addTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }
    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/updateTask/{id}")
    public String updateTask(@PathVariable Long id, @RequestParam boolean
            completed) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(completed);
        taskRepository.save(task);
        return "redirect:/";
    }
}