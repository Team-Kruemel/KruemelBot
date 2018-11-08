package com.teamkruemel.kruemelbot.util;

import org.simpleyaml.configuration.file.YamlFile;

public class Vars {

    public static final String configFileName = "config.yaml";
    public static final String botUsedCommandWarn = "The bot can't execute commands.\n The command has been ignored.";
    public static final String otherBotUsedCommandWarn = "Other bots can't execute commands.\n The command has been ignored";
    public static YamlFile configFile = new YamlFile(configFileName);

}
