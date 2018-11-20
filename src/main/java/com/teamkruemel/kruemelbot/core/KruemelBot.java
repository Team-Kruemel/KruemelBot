package com.teamkruemel.kruemelbot.core;

import com.teamkruemel.kruemelbot.listeners.MessageEventListener;
import com.teamkruemel.kruemelbot.util.Vars;
import com.teamkruemel.kruemelbot.util.YAMLManager;
import net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;

public class KruemelBot {

    //public static ConfigurationSection getBotConfigSection = Vars.configFile.getConfigurationSection("bot-config");

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

            shardManager();

        } catch (LoginException exc) {

            logger.error("There was an error while the bot tried to login.\n");
            logger.error("The Stacktrace will be printed now!\n");
            logger.error(exc);

        }

    }

    public static void shardManager() throws LoginException {

        DefaultShardManagerBuilder shardBuilder = new DefaultShardManagerBuilder();
        shardBuilder.setToken(Vars.configFile.getString("bot-config.bot-token"));
        shardBuilder.addEventListeners(new MessageEventListener());
        shardBuilder.build();

    }

}
