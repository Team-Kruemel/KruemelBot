package com.teamkruemel.kruemelbot.core;

import com.github.johnnyjayjay.discord.commandapi.CommandSettings;
import com.github.johnnyjayjay.discord.commandapi.DefaultHelpCommand;
import com.teamkruemel.kruemelbot.commands.PingCommand;
import com.teamkruemel.kruemelbot.listeners.MessageEventListener;
import com.teamkruemel.kruemelbot.util.Vars;
import com.teamkruemel.kruemelbot.util.YAMLManager;
import net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.bot.sharding.ShardManager;
import net.dv8tion.jda.core.entities.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;

public class KruemelBot {

    private static final Logger logger = LogManager.getLogger(KruemelBot.class.getSimpleName());

    public static void main(String[] args) {

        botInit();

    }

    public static void botInit() {

        YAMLManager.loadYAMLFile();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException exc) {

            logger.error("The Thread has been interrupted while trying to sleep.\n");
            logger.error("The stacktrace will be printed now!\n");
            logger.error(exc);

        }

        try {

            DefaultShardManagerBuilder shardBuilder = new DefaultShardManagerBuilder();
            shardBuilder.setToken(Vars.configFile.getString("bot-config.bot-token"));
            shardBuilder.addEventListeners(new MessageEventListener());
            shardBuilder.setGame(Game.playing("Awaiting command!"));
            shardBuilder.build();

            ShardManager shardManager = shardBuilder.build();

            CommandSettings commandSettings = new CommandSettings(Vars.configFile.getString("bot-config.bot-prefix"), shardManager, true);
            commandSettings.put(new PingCommand(), "ping").put(new DefaultHelpCommand(), "help").activate();

        } catch (LoginException exc) {

            logger.error("There was an error while the bot tried to login.\n");
            logger.error("The Stacktrace will be printed now!\n");
            logger.error(exc);

        }

    }

}
