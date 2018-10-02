package com.krumel.bot.commands;

/*
 *
 *
 * Written by Lukas H. (ZickZackHD)
 * 2018, Oktober
 *
 *
 */
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.krumel.bot.ConfigManager;
import com.krumel.bot.KruemelBot;
import net.dv8tion.jda.core.EmbedBuilder;

import java.io.File;
import java.io.IOException;

@CommandInfo(
        name = {"Reboot", "Restart"},
        description = "Reboots the hole bot "
)
public class RebootCMD extends Command {

    EmbedBuilder eb = new EmbedBuilder();

    public RebootCMD(){
        this.category = KruemelBot.BotSetup.AdminCMDs;
        this.name = "reboot";
        this.help = "Shutdown and reboot the hole bot.";
        this.guildOnly = true;
        this.aliases = new String[]{"restart"};
    }
    @Override
    protected void execute(CommandEvent event) {
        final String SBOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
        final String SREBOOT_TITLE = "Reboot command";
        final String SDESC = "The bot will now safely reboot!";
        final String SNoPerm = "You don't have permission to use this command!";
        final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();
        String SApplicationname = "KruemelBot.jar";
        String SJavapath = "java";

        if (event.getAuthor().isBot()) {

            return;

        } else {

            // Check if the User is the Owner
            if (event.getAuthor().getId().equals(ConfigManager.prop.getProperty("owner_id")) ) {

                // Prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SREBOOT_TITLE);
                eb.setDescription(SDESC);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                //Start the Bot & Shutdown the old one Bot
                ProcessBuilder pb = new ProcessBuilder(SJavapath + "-jar" + SApplicationname );
                pb.directory(new File(""));
                try{
                    Process p = pb.start();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                event.reactWarning();
                event.getTextChannel().sendMessage(eb.build()).queue();
                event.getJDA().shutdown();
                System.exit(0);

            } else {

                // prepare Embed Message
                eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                eb.setTitle(SREBOOT_TITLE);
                eb.setDescription(SNoPerm);
                eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                // Respond to the User
                event.reactError();
                event.getTextChannel().sendMessage(eb.build()).queue();

            }

        }




    }
}
