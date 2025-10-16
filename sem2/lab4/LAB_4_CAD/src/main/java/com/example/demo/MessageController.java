package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class MessageController {
    private List<String> userMessages = new ArrayList<>();

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }
    @GetMapping("/messages")
    public List<String> getAllMessages() {
        return userMessages;
    }
    @GetMapping("/count")
    public String countMessages() {
        return "Message count - " + userMessages.size();
    }
    @PostMapping("/messages")
    public String publishMessage(@RequestBody String message) {
        userMessages.add(message);
        return "Message published successfully!";
    }
    @PutMapping("/messages/{index}")
    public String updateMessage(@PathVariable int index, @RequestBody String
            message) {
        if (index >= 0 && index < userMessages.size()) {
            userMessages.set(index, message);

            return "Message updated successfully!";
        }
        return "Message not found at index " + index;
    }
    @DeleteMapping("/messages/{index}")
    public String deleteMessage(@PathVariable int index) {
        if (index >= 0 && index < userMessages.size()) {
            userMessages.remove(index);
            return "Message deleted successfully!";
        }
        return "Message not found at index " + index;
    }
}