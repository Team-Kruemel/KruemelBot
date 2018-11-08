package com.teamkruemel.kruemelbot.commands;

import com.github.johnnyjayjay.discord.commandapi.CommandEvent;
import com.github.johnnyjayjay.discord.commandapi.ICommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

public class PingCommand implements ICommand {

    @Override
    public void onCommand(CommandEvent event, Member member, TextChannel channel, String[] args) {

        JDA jda = event.getJDA();

        event.respond(String.valueOf(jda.getPing()));

    }

}
