package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.entity.Todo;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

@Service
public class LlmService {

    private final OpenAiService openAiService;

    public LlmService(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String summarizeTodos(List<Todo> todos) {
        if (todos == null || todos.isEmpty()) {
            return "No todos to summarize.";
        }

        String todoText = todos.stream()
                .map(Todo::getTask)
                .collect(Collectors.joining("\n"));

        String prompt = "Summarize the following to-do items in a meaningful and concise way:\n" + todoText;

        // Compose the chat messages properly
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("system", "You are an assistant that summarizes task lists."));
        messages.add(new ChatMessage("user", prompt));

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

        return openAiService.createChatCompletion(request)
                .getChoices()
                .get(0)
                .getMessage()
                .getContent()
                .trim();
    }
}
