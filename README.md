# DevAI Studio - AI Workbench for Software Developers

A powerful, full-stack **AI Workbench and Code Assistant** built with Spring Boot 3.3, LLM Integration (Ollama + Cloud APIs), and a modern dark-mode IDE interface.

![DevAI Studio](https://img.shields.io/badge/Spring_Boot-3.3.5-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-blue.svg)
![AI-Powered](https://img.shields.io/badge/AI-Ollama%20%7C%20OpenAI%20%7C%20DeepSeek-purple.svg)

---

## ⚡ Quick Start - Run on Any PC

### Option 1: Run with Maven (Zero Config)
No external database or setup required! Works out-of-the-box on Windows, Mac, or Linux.

```bash
git clone https://github.com/sunny01saikumar/Sai.git
cd Sai
./mvnw spring-boot:run
```
Then open **[http://localhost:8080](http://localhost:8080)** in your web browser!

---

### Option 2: Run with Docker Compose
To run both the Spring Boot app and local Ollama container together:

```bash
git clone https://github.com/sunny01saikumar/Sai.git
cd Sai
docker-compose up --build
```
Access the UI at **[http://localhost:8080](http://localhost:8080)**.

---

## 💡 Key Features

- 🔍 **Code Explainer**: Line-by-line algorithm analysis, complexity (\(O(N)\)), and logic breakdown.
- 🐛 **Bug & Vulnerability Auditor**: Scan for runtime bugs, security issues (OWASP), and receive defensive refactored code.
- 🧪 **Unit Test Generator**: Produce JUnit 5, PyTest, and Jest test cases covering edge cases.
- ⚡ **Code Refactor**: Modernize legacy code, apply SOLID principles, and clean formatting.
- 🗄️ **SQL Helper**: Generate optimized SQL queries, indexes, and JPA entity models.
- 💬 **Dev Assistant Chat**: Multi-turn pair programming assistant.

---

## ⚙️ Configuration

- **Local Ollama LLMs**: Connects to `http://localhost:11434` (`codellama`, `deepseek-coder`, `qwen2.5-coder`).
- **Cloud LLM Support**: Pass your API key directly in the UI for OpenAI / DeepSeek / OpenRouter.
- **Smart Fallback Engine**: If Ollama or Cloud APIs are offline, DevAI Studio automatically provides defensive code fixes and structured analysis!
