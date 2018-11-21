package com.teamkruemel.kruemelbot.commands;

import com.github.johnnyjayjay.discord.commandapi.CommandEvent;
import com.github.johnnyjayjay.discord.commandapi.ICommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.util.Set;

public class PingCommand implements ICommand {

    @Override
    public void onCommand(CommandEvent event, Member member, TextChannel channel, String[] args) {

        JDA jda = event.getJDA();

        event.respond(String.valueOf(jda.getPing()));

    }

    @Override
    public Message info(Member member, String prefix, Set<String> labels) {

        final Message infoMsg = new MessageBuilder().setContent("This command returns the current ping of the bot.").build();

        return infoMsg;

    }
}
