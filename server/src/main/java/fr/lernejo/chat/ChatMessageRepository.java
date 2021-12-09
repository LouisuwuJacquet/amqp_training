package fr.lernejo.chat;

import java.util.ArrayList;
import java.util.List;


public class ChatMessageRepository {

    List<String> LastTenMessages = new ArrayList<>();
    void addChatMessage(String message)
    {
        LastTenMessages.add(message);
    }

    List<String> getLastTenMessages()
    {
        if(LastTenMessages.size()>10)
            return LastTenMessages.subList(LastTenMessages.size()-10,LastTenMessages.size());
        else
            return LastTenMessages;
    }
}
