package com.krumel.bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import com.krumel.bot.ConfigManager;
import net.dv8tion.jda.core.EmbedBuilder;

import java.util.Random;
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
            name = {"coinflip", "coinflip"},
            description = "start coinflip!"
)
@Author("Heinz")
        public class CoinflipCMD extends Command {
            EmbedBuilder eb = new EmbedBuilder();
        public CoinflipCMD()
        {
            this.name = "coinflip";
            this.help = "start coinflip!";
            this.guildOnly = false;
            this.aliases = new String[]{"coinflip"};
        }

@Override

        protected void execute(CommandEvent event) {
            int  IRandom = new Random().nextInt(2);
            final String SBOT_URL = "https://github.com/InterXellar/JDB/";
            final String SSHUTDOWN_TITLE = "Coin-Flipper command";

            final String SNoPerm = "You don't have permission to use this command!";
            final String SFOOTER_TEXT = "Requested by " + event.getAuthor().getName();

                if (event.getAuthor().isBot()) {

                return;

                } else {

                    // Check if the User is the Owner
                    if (event.getAuthor().getId().equals(ConfigManager.prop.getProperty("owner_id")) ) {

                    // Prepare Embed Message
                    eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                    eb.setTitle(SSHUTDOWN_TITLE);


                    eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                    if(IRandom==0){
                        final String SDESC = "The Flipping Coin Machine has fliped the Coin its **\uD83E\uDD2F**(**Head**)";
                        eb.setDescription(SDESC);
                        event.getTextChannel().sendMessage(eb.build()).queue();
                    }
                    else {
                        final String SDESC = "The Flipping Coin Machine has fliped the **\uD83D\uDD22**(**Number**)";
                        eb.setDescription(SDESC);
                        event.getTextChannel().sendMessage(eb.build()).queue();

                    }





                        } else {

                            // prepare Embed Message
                            eb.setAuthor(event.getSelfUser().getName(), SBOT_URL, event.getSelfUser().getAvatarUrl());
                            eb.setTitle(SSHUTDOWN_TITLE);
                            eb.setDescription(SNoPerm);
                            eb.setFooter(SFOOTER_TEXT, event.getAuthor().getAvatarUrl());

                            // Respond to the User
                            event.reactError();
                            event.getTextChannel().sendMessage(eb.build()).queue();

                        }

                }

        }
        }


