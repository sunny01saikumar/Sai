package com.education.sai.controller;

import com.education.sai.dto.AiDeveloperRequest;
import com.education.sai.dto.AiDeveloperResponse;
import com.education.sai.service.AiService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai/developer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AiDeveloperController {

    private final AiService aiService;

    @PostMapping("/analyze")
    public ResponseEntity<AiDeveloperResponse> analyzeCode(@RequestBody AiDeveloperRequest request) {
        AiDeveloperResponse response = aiService.processDeveloperTask(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/chat")
    public ResponseEntity<AiDeveloperResponse> devChat(@RequestBody AiDeveloperRequest request) {
        request.setActionMode("CHAT");
        AiDeveloperResponse response = aiService.processDeveloperTask(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/models")
    public ResponseEntity<Map<String, Object>> getAvailableModels() {
        List<Map<String, String>> models = List.of(
                Map.of("id", "codellama", "name", "CodeLlama (Local Ollama)", "provider", "OLLAMA"),
                Map.of("id", "deepseek-coder", "name", "DeepSeek Coder (Local Ollama)", "provider", "OLLAMA"),
                Map.of("id", "qwen2.5-coder", "name", "Qwen 2.5 Coder (Local Ollama)", "provider", "OLLAMA"),
                Map.of("id", "llama3", "name", "Llama 3 (Local Ollama)", "provider", "OLLAMA"),
                Map.of("id", "gpt-4o-mini", "name", "GPT-4o Mini (Cloud API)", "provider", "OPENAI"),
                Map.of("id", "deepseek-chat", "name", "DeepSeek V3 / R1 (Cloud API)", "provider", "CUSTOM")
        );

        return ResponseEntity.ok(Map.of(
                "status", "ACTIVE",
                "defaultProvider", "OLLAMA",
                "ollamaEndpoint", "http://localhost:11434",
                "models", models
        ));
    }
}
