package fr.lernejo.chat;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    ChatMessageListener msgrepo;

    public ChatMessageController(ChatMessageListener msgrepo) {
        this.msgrepo = msgrepo;
    }

    @GetMapping(value = "/api/message")
    public List<String> MsgList()
    {
        return msgrepo.repo.getLastTenMessages();
    }
}
