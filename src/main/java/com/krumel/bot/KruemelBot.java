package com.krumel.bot;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.krumel.bot.commands.*;
import net.dv8tion.jda.core.AccountType;
/* import net.dv8tion.jda.core.EmbedBuilder;*/
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.EventListener;

import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 *
 *
 * Written by Filip M. (InterXellar)
 * 2018, September
 *
 *
 */

/**
 *
 * @author Filip M.
 *
 */


public class KruemelBot extends ConfigManager {

    private static String filename = "config.properties";

    public static void main(String[] args) {



        try {

            // Create new FileInputStream
            in = new FileInputStream(filename);

        } catch (FileNotFoundException FNFExc) {

            // If the File does not exist create it with default settings
            setDefaultSettings();
            FNFExc.printStackTrace();

        } catch (IOException ioexc) {

            setDefaultSettings();
            ioexc.printStackTrace();

        }

        // Try to load the properties file
        try {

           prop.load(in);

        } catch (IOException ioexc2) {

            ioexc2.printStackTrace();
            System.exit(1);

        }

        // Call BotSetup.SetupBot to start the Bot
        try {

            BotSetup.SetupBot();

        } catch (LoginException | RateLimitedException | InterruptedException botExc) {

            botExc.printStackTrace();

        }

    }

    public static class BotSetup implements EventListener {

        private final String SAPI_READY = "The API now ready for use!";
        public static Command.Category AdminCMDs = new Command.Category("Admin commands");

        public static void SetupBot()
        throws LoginException, RateLimitedException, InterruptedException{

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
                                new PingCMD(),
                                new ShutdownCMD(),
                                new InviteCMD());

            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(ConfigManager.prop.getProperty("discord_token"))
                    .setGame(Game.watching("loading..."))
                    .addEventListener(waiter)
                    .addEventListener(client.build())
                    .addEventListener(new BotSetup())
                    .build();

        }


        @Override
        public void onEvent(Event event) {

            /*
            final JDA jda = event.getJDA();
            final EmbedBuilder eb = new EmbedBuilder();
            final String BOT_URL = "https://github.com/Team-Kruemel/KruemelBot/";
            final String WELCOME_TITEL = "Welcome message";
            final String DESC = "The bot is now ready for usage!";
            final String FOOTER_TEXT = "Requested by ";
            final String SDEV_CHANNEL_ID = "467046869424406528";
            final String BOT_READY_MSG = "The Bot is now ready for usage";
            final String VER_INFO = "Version 0.1_debug (Unstable)";
            */
            if (event instanceof ReadyEvent) {

                // Print to the Log that the API is ready
                System.out.println(SAPI_READY);

                /*
                Print a welcome message to the Dev Channel
                eb.setAuthor(jda.getSelfUser().getName(), BOT_URL, jda.getSelfUser().getAvatarUrl());
                eb.setTitle(WELCOME_TITEL);
                eb.setDescription(DESC);
                eb.setFooter(FOOTER_TEXT + jda.getSelfUser().getName(), jda.getSelfUser().getAvatarUrl());
                jda.getTextChannelById(SDEV_CHANNEL_ID).sendMessage(eb.build()).queue();
                */
            }

        }


    }

}

