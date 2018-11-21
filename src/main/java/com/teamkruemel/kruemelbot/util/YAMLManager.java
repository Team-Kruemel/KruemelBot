package com.teamkruemel.kruemelbot.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleyaml.configuration.ConfigurationSection;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import java.io.IOException;

public class YAMLManager {

    private static final Logger logger = LogManager.getLogger(YAMLManager.class.getSimpleName());

    public static void createDefaultConfig() {

        ConfigurationSection createBotConfigSection = Vars.configFile.createSection("bot-config");
        createBotConfigSection.set("bot-token", "test");
        createBotConfigSection.set("bot-owner", "test");
        createBotConfigSection.set("bot-prefix", "Set the prefix of the bot here");

        try {

            Vars.configFile.save();
            System.exit(1);

        } catch (IOException exc) {

            logger.error("There was an error while trying to save the config-file.\n");
            logger.error("The stacktrace will be printed now!\n");
            logger.error(exc);

        }

    }

    public static void loadYAMLFile() {

        try {

            if(Vars.configFile.exists()) {

                logger.info("Config file already exists loading now...\n");
                Vars.configFile.load();

            } else {

                logger.error("Config doesn't exists yet.\n");
                logger.error("Creating now: " + Vars.configFile.getFilePath() + "\n");
                Vars.configFile.createNewFile(false);
                Thread.sleep(4000);
                createDefaultConfig();

            }

        } catch (IOException | InvalidConfigurationException exc) {

            logger.error("There was an error while trying to create or load the file.\n");
            logger.error("The stacktrace will be printed now!\n");
            logger.error(exc);

        } catch (InterruptedException exc) {

            logger.error("The Thread has been interrupted while trying to sleep.\n");
            logger.error("The stacktrace will be printed now!\n");
            logger.error(exc);

        }

    }

}
