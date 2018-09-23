package com.krumel.bot.listener;

import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class MSG_listener extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author =event.getAuthor();
        Message message  = event.getMessage();
        MessageChannel channel =event.getChannel();
        String Smsg = message.getContentDisplay();



    }
    if (msg.equals("!block"))
}