
        package com.krumel.bot.commands;

        import java.time.temporal.ChronoUnit;
        import com.jagrosh.jdautilities.command.Command;
        import com.jagrosh.jdautilities.command.CommandEvent;
        import com.jagrosh.jdautilities.doc.standard.CommandInfo;
        import com.jagrosh.jdautilities.examples.doc.Author;
        import net.dv8tion.jda.client.managers.EmoteManager;
        import net.dv8tion.jda.core.EmbedBuilder;
        import net.dv8tion.jda.core.entities.Emote;
        import net.dv8tion.jda.client.*;
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
        name = {"Ping", "Pong"},
        description = "Checks the bot's latency"
)
@Author("Heinz")
public class PingCMD extends Command {

    public PingCMD()
    {
        this.name = "ping";
        this.help = "checks the bot's latency";
        this.guildOnly = false;
        this.aliases = new String[]{"pong"};
    }

    @Override
    protected void execute(CommandEvent event) {


        EmbedBuilder eb = new EmbedBuilder();
        final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
        final String SPING_TITLE = "Here is your invite-Link!";
        long PINGMS = 0;
        final String SNoPerm = "You don't have permission to use this command!";
        final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();
        event.reply("Ping: ...", m -> {
            long ping = event.getMessage().getCreationTime().until(m.getCreationTime(), ChronoUnit.MILLIS);






        });
        final  String SDESC = "Ping: " + PINGMS + "ms | Websocket: " +  event.getJDA().getPing() + "ms";

        if (event.getAuthor().isBot()) {

            return;

        } else {



            // Prepare Embed Message
            eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
            eb.setTitle(SPING_TITLE);
            eb.setDescription(SDESC);
            eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());
            //send The Invite link

            event.getTextChannel().sendMessage(eb.build()).queue();
        }

    }



    }


