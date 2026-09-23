package com.education.sai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiDeveloperResponse {
    private boolean success;
    private String responseMarkdown;
    private String generatedCode;
    private String explanation;
    private String modelUsed;
    private String actionMode;
    private LocalDateTime timestamp;
    private String errorMessage;
}
