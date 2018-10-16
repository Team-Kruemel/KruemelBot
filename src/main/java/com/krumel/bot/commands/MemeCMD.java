package com.krumel.bot.commands;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.krumel.bot.ConfigManager;
import com.krumel.bot.KruemelBot;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.File;
import java.io.IOException;
@CommandInfo(
        name = {"Memer", "meme"},
        description = "Send an random meme "
)

public class MemeCMD extends Command {
    EmbedBuilder eb = new EmbedBuilder();


    public MemeCMD(){

        this.name = "meme";

        this.help = "Sends a randome meme";
        this.guildOnly = true;
        this.aliases = new String[]{"memer"};
    }
    @Override
    protected void execute(CommandEvent event) {
        final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
        final String SMEME_TITLE = "Mememachine";
        final String SDESC = "The Bot now send your meme";
        final String SNoPerm = "You don't have permission to use this command!";
        final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();
        if (event.getAuthor().isBot()) {

            return;

        } else {

            // Check if the User is the Owner
            if (event.getAuthor().getId().equals(ConfigManager.prop.getProperty("owner_id")) ) {

                // Prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SMEME_TITLE);
                eb.setDescription(SDESC);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                //Send Meme
                event.getTextChannel().sendMessage("MemeMachine is not working now").queue();


            } else {

                // prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SMEME_TITLE);
                eb.setDescription(SNoPerm);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());
                // Respond to the User
                event.reactError();
                event.getTextChannel().sendMessage(eb.build()).queue();

            }

        }

    }
}
