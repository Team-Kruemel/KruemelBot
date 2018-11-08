package com.teamkruemel.kruemelbot.core;

import com.teamkruemel.kruemelbot.util.Vars;
import com.teamkruemel.kruemelbot.util.YAMLManager;
import net.dv8tion.jda.bot.sharding.DefaultShardManagerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;

public class KruemelBot {

    private static final Logger logger = LogManager.getLogger(KruemelBot.class.getSimpleName());

    public static void main(String[] args) {

        botInit();

    }

    public static void botInit() {

        if (Vars.configFile.exists()) {



        } else {

            YAMLManager.createDefaultConfig();

        }

    }

    public static void shardManager() throws LoginException {

        DefaultShardManagerBuilder shardBuilder = new DefaultShardManagerBuilder();
        shardBuilder.setToken("")
                    //.addEventListener(new MessageListener())
                    .build();

    }

}
