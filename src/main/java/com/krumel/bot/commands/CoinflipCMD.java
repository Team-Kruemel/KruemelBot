package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;

import java.util.Random;

public class CoinflipCMD {

    @CommandInfo(
            name = {"coinflip", "coinflip"},
            description = "start coinflip!"
    )
    @Author("Heinz")
    public class PingCMD extends Command {

        public PingCMD()
        {
            this.name = "coinflip";
            this.help = "start coinflip!";
            this.guildOnly = false;
            this.aliases = new String[]{"coinflip"};
        }

        @Override
        protected void execute(CommandEvent event) {


            int  IRandom = new Random().nextInt(1);
            if(IRandom==0) {
                event.getTextChannel().sendMessage("Head!\uD83D\uDE03").queue();

            }else
            event.getTextChannel().sendMessage("Number 0").queue();


        }
    }

}
