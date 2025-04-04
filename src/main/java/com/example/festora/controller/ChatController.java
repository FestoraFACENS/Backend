package com.example.festora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.festora.model.Mensagem;
import com.example.festora.model.dtos.MensagemDTO;
import com.example.festora.service.ChatService;
import com.example.festora.utils.RetornarIdToken;

@RestController
@RequestMapping("/eventos/chats")
public class ChatController {

	private ChatService chatService;

	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@PostMapping("/mensagens/{chatId}")
	public MensagemDTO enviarMensagem(@PathVariable String chatId, @RequestBody String mensagem) {
		
		return chatService.enviarMensagem(mensagem, chatId, RetornarIdToken.get());
	}
	
	@GetMapping("/mensagens/{chatId}")
	public List<MensagemDTO> obterMensagens(@PathVariable String chatId) {
		return chatService.obterMensagens(chatId);
	}
}





