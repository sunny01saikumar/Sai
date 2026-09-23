package com.education.sai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiDeveloperRequest {
    private String code;
    private String language; // e.g. java, python, javascript, sql, cpp, etc.
    private String actionMode; // EXPLAIN, FIX_BUGS, UNIT_TEST, REFACTOR, SQL_GEN, CHAT
    private String userPrompt;
    private String modelProvider; // OLLAMA, OPENAI, CUSTOM
    private String modelName; // e.g. codellama, deepseek-coder, llama3, gpt-4o, etc.
    private String apiKey; // optional custom API key override
}
