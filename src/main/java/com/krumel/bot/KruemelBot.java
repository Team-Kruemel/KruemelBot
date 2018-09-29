package com.krumel.bot;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.krumel.bot.commands.CoinflipCMD;
import com.krumel.bot.commands.DdosCMD;
import com.krumel.bot.commands.PingCMD;
import jdk.internal.jline.internal.Log;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;

import javax.security.auth.login.LoginException;

/*
 *
 *
 * Written by Filip M. (InterXellar)
 * 2018, July
 *
 *
 */

/**
 *
 * @author Filip M.
 *
 */


public class KruemelBot {

    public void main(String[] args) {

        // Call ConfigManager.setDefaultSettings to check if the Config already exits if no it will set up a default config
        ConfigManager.setDefaultSettings();

        // Call BotSetup.SetupBot to start the Bot
        try {

            BotSetup.SetupBot();

        } catch (LoginException | RateLimitedException | InterruptedException botExc) {

            botExc.printStackTrace();

        }

    }

    public static class BotSetup implements EventListener {

        private final String SAPI_READY = "The API now ready for use!";
        private final String SDEV_CHANNEL_ID = "467046869424406528";
        private final String BOT_READY_MSG = "The Bot is now ready for usage";
        private final String VER_INFO = "Version 0.1_debug (Unstable)";


        public static void SetupBot()
        throws LoginException, RateLimitedException, InterruptedException{

            Command.Category AdminCMDs = new Command.Category("Admin Commands");

            EventWaiter waiter = new EventWaiter();
            CommandClientBuilder client = new CommandClientBuilder();

            // Set up the Bot
            client.useDefaultGame();
            client.setOwnerId(ConfigManager.prop.getProperty("owner_id"));
            client.setEmojis("\uD83D\uDE03", "\uD83D\uDE2E", "\uD83D\uDE26");
            client.setPrefix(ConfigManager.prop.getProperty("cmd_prefix"));


            //Register the Commands
            client.addCommands(new CoinflipCMD(),
                                new DdosCMD(),
                                new PingCMD());

            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(ConfigManager.prop.getProperty("token"))
                    .setGame(Game.watching("loading..."))
                    .addEventListener(waiter)
                    .addEventListener(client.build())
                    .addEventListener(new BotSetup())
                    .buildBlocking();

        }

        @Override
        public void onEvent(Event event) {

            final JDA jda = event.getJDA();
            final EmbedBuilder eb = new EmbedBuilder();
            final String BOT_ICON = "https://cdn.discordapp.com/avatars/457972381911089154/bb389dfcc8ca15fcbc5512c2025aff04.png";
            final String BOT_URL = "https://gitlab.com/InterXellar/JDB/";
            final String WELCOME_TITEL = "Welcome message";
            final String DESC = "The bot is now ready for usage!";
            final String FOOTER_TEXT = "Requested by " + jda.getSelfUser().getAsMention();


            if (event instanceof ReadyEvent) {

                // Print to the Log that the API is ready
                Log.info(SAPI_READY);

                //Print a welcome message to the Dev Channel
                eb.setAuthor(jda.getSelfUser().getAsMention(), BOT_URL, BOT_ICON);
                eb.setTitle(WELCOME_TITEL);
                eb.setDescription(DESC);
                eb.setFooter(FOOTER_TEXT, jda.getSelfUser().getAvatarUrl());


            }

        }

    }

}

