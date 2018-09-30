package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import com.krumel.bot.KruemelBot;

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
            this.category = KruemelBot.BotSetup.AdminCMDs;
            this.aliases = new String[]{"join"};
        }

        @Override
        protected void execute(CommandEvent event) {

            event.getTextChannel().sendMessage("https://discordapp.com/oauth2/authorize?client_id=479025791565430799&scope=bot&permissions=8 ").queue();

            }
        }




