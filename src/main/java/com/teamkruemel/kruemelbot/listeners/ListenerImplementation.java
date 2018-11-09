package com.teamkruemel.kruemelbot.listeners;

import com.teamkruemel.kruemelbot.util.Vars;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListenerImplementation extends ListenerAdapter {

    private static final Logger logger = LogManager.getLogger(ListenerImplementation.class.getSimpleName());

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        JDA jda = event.getJDA();

        if (event.getAuthor().equals(event.getMember().equals(jda.getSelfUser()))) {

            logger.warn(Vars.botUsedCommandWarn);
            return;

        } else if (event.getAuthor().isBot()) {

            logger.warn(Vars.otherBotUsedCommandWarn);
            return;

        }

    }

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {

        JDA jda = event.getJDA();

    }

}
