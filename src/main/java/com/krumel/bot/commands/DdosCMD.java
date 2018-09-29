package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;


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


           ClassLoader ClassLoader = getClass().getClassLoader();



            event.getTextChannel().sendMessage("https://www.heinz-lukas.de/ddos/").queue();
            event.getTextChannel().sendFile(new File("../resources/ddos.gif")).queue();


            }
        }




