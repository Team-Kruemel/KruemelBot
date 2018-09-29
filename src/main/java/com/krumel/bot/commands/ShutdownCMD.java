package com.krumel.bot.commands;

/*
 *
 *
 * Written by Filip M. (InterXellar)
 * 2018, September
 *
 *
 */

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.krumel.bot.ConfigManager;
import com.krumel.bot.KruemelBot;
import net.dv8tion.jda.core.EmbedBuilder;

/**
 *
 * @author Filip M.
 *
 */


public class ShutdownCMD extends Command {

    EmbedBuilder eb = new EmbedBuilder();

    public ShutdownCMD() {

        this.name = "shutdown";
        this.aliases = new String[]{"exit"};
        this.category = KruemelBot.BotSetup.AdminCMDs;
        this.guildOnly = true;
        this.help = "Shutdown the bot";

    }

    @Override
    protected void execute(CommandEvent event) {

        final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
        final String SSHUTDOWN_TITLE = "Shutdown command";
        final String SDESC = "The bot will now safely shutdown!";
        final String SNoPerm = "You don't have permission to use this command!";
        final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();

        if (event.getAuthor().isBot()) {

            return;

        } else {

            // Check if the User is the Owner
            if (event.getAuthor().getId().equals(ConfigManager.prop.getProperty("owner_id")) ) {

                // Prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SSHUTDOWN_TITLE);
                eb.setDescription(SDESC);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                //Shutdown the Bot
                event.reactWarning();
                event.getTextChannel().sendMessage(eb.build()).queue();
                event.getJDA().shutdown();
                System.exit(0);

            } else {

                // prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SSHUTDOWN_TITLE);
                eb.setDescription(SNoPerm);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                // Respond to the User
                event.reactError();
                event.getTextChannel().sendMessage(eb.build()).queue();

            }

        }

    }
}
