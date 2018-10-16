package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import com.krumel.bot.ConfigManager;
import net.dv8tion.jda.core.EmbedBuilder;


import java.io.File;
import java.io.IOException;
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
            name = {"Ddos", "ddos"},
            description = "start ddos!"
    )
    @Author("Heinz")
    public class DdosCMD extends Command {

        public DdosCMD()
        {
            this.name = "ddos";
            this.help = "start ddos!";
            this.guildOnly = false;
            this.aliases = new String[]{"ddos"};
        }


        @Override
        protected void execute(CommandEvent event) {
            ClassLoader ClassLoader = getClass().getClassLoader(); //load the gif  Resource
            EmbedBuilder eb = new EmbedBuilder();
            final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
            final String SDDos_TITLE = "DDos command";
            final String SDESC = "https://www.heinz-lukas.de/ddos/";
            final String SNoPerm = "You don't have permission to use this command!";
            final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();


            if (event.getAuthor().isBot()) {

                return;

            } else {

                // Check if the User is the Owner
                if (event.getAuthor().getId().equals(ConfigManager.prop.getProperty("owner_id")) ) {

                    // Prepare Embed Message
                    eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                    eb.setTitle(SDDos_TITLE);
                    eb.setDescription(SDESC);
                    eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                    //send The DDos insider gif and the massage

                    event.getTextChannel().sendFile(new File(ClassLoader.getResource("ddos.gif").getFile())).queue();
                    event.getTextChannel().sendMessage(eb.build()).queue();
                } else {

                    // prepare Embed Message
                    eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                    eb.setTitle(SDDos_TITLE);
                    eb.setDescription(SNoPerm);
                    eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                    // Respond to the User
                    event.reactError();
                    event.getTextChannel().sendMessage(eb.build()).queue();

                }

            }











            }
        }




