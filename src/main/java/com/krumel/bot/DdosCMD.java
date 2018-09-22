package com.krumel.bot;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
public class DdosCMD {
    @CommandInfo(
            name = {"Ddos", "ddos"},
            description = "start ddos!"
    )
    @Author("Heinz")
    public class PingCMD extends Command {

        public PingCMD()
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


