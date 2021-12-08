package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    public static ChatMessageRepository chatMessageRepository = new ChatMessageRepository();
    public void onMessage(String message){
        chatMessageRepository.addChatMessage(message);
    }
}

