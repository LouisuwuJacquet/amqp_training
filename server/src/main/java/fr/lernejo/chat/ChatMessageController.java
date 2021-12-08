package fr.lernejo.chat;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ChatMessageController {
    ChatMessageListener chatMessageListener;
    public ChatMessageController(ChatMessageListener chatMessageListener) {
        this.chatMessageListener = chatMessageListener;
    }

    @GetMapping(value ="/api/message")
    public List<String> getmessage(){
        return chatMessageListener.chatMessageRepository.getLastTenMessages();
    }
}
