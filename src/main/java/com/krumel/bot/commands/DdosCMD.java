package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
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
public class DdosCMD {
    @CommandInfo(
            name = {"Ddos", "ddos"},
            description = "start ddos!"
    )
    @Author("Heinz")
    public class DdosCOM extends Command {

        public DdosCOM()
        {
            this.name = "ddos";
            this.help = "start ddos!";
            this.guildOnly = false;
            this.aliases = new String[]{"ddos"};
        }


        @Override
        protected void execute(CommandEvent event) {
            event.getTextChannel().sendMessage("https://www.heinz-lukas.de/ddos/").queue();


            }
        }

    }


