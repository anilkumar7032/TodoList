package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//src/main/java/com/example/service/SlackService.java
@Service
public class SlackService {
 private final WebClient webClient;
 private final String webhookUrl;
 
 public SlackService(@Value("${slack.webhook.url}") String webhookUrl) {
     this.webhookUrl = webhookUrl;
     this.webClient = WebClient.create();
 }
 
 public void sendToSlack(String message) {
     webClient.post()
         .uri(webhookUrl)
         .contentType(MediaType.APPLICATION_JSON)
         .bodyValue(Map.of("text", message))
         .retrieve()
         .toBodilessEntity()
         .block();
 }
}
