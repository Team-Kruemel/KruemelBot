package com.teamkruemel.kruemelbot.listeners;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        JDA jda = event.getJDA();

        if (event.getMessage().getContentRaw().equals(jda.getSelfUser().getAsMention())) {

            System.out.println("Test");

        }

        if (event.getMessage().getContentRaw().equals(event.getAuthor().isBot())) {



        }

    }

}
