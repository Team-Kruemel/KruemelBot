package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import com.krumel.bot.ConfigManager;
import com.krumel.bot.KruemelBot;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.File;
/*
 *
 *
 * Written by Lukas H. (ZickZackHD)
 * 2018, July
 *
 *
 */

/**
 *
 * @author Lukas H.
 *
 */

    @CommandInfo(
            name = {"Invite", ""},
            description = "If you want to have this 'Krümelbot' you get here the Invitation-Link."
    )
    @Author("Heinz")
    public class InviteCMD extends Command {

        public InviteCMD()
        {

            this.name = "join";
            this.help = "Invitation-Link";
            this.guildOnly = false;
            this.aliases = new String[]{"join"};
        }

        @Override
        protected void execute(CommandEvent event) {
            ClassLoader ClassLoader = getClass().getClassLoader(); //load the gif  Resource
            EmbedBuilder eb = new EmbedBuilder();
            final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
            final String Sinvite_TITLE = "Here is your invite-Link!";
            final String SDESC = "https://discordapp.com/oauth2/authorize?client_id=479025791565430799&scope=bot&permissions=8 ";
            final String SNoPerm = "You don't have permission to use this command!";
            final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();


            if (event.getAuthor().isBot()) {

                return;

            } else {
                        // Prepare Embed Message
                        eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                        eb.setTitle(Sinvite_TITLE);
                        eb.setDescription(SDESC);
                        eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());
                        //send The Invite link
                        event.getTextChannel().sendMessage(eb.build()).queue();
                    }

        }


    }





