package com.krumel.bot.listener;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ConnectionProperties;
import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import com.mysql.*;
import javax.security.auth.login.LoginException;

public class MSG_listener extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        String Smsg = message.getContentDisplay();
        String SGuild = message.getGuild().toString();
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "password";

        System.out.println("Connecting database...");

        // init connection object
        // init connection object
         Connection connection;
// init properties object
        ConnectionProperties properties;

            if (properties == null) {
                properties = new Properties();
                properties.setProperty("user", USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("MaxPooledStatements", MAX_POOL);
            }
            return properties;
        }

    }}