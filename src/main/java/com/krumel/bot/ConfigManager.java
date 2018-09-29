package com.krumel.bot;

import java.io.*;
import java.util.Properties;

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


public class ConfigManager {

    /*
     * Call a new Object of "Properties"
     * Also set the Output path to null for now
     * And set the filename as a String
     */

    public static final Properties prop = new Properties();
    public static OutputStream out = null;
    public static InputStream in = null;
    private static final String filename = "config.properties";

    public static void setDefaultSettings() {

            try {

                // Try to set FileOutputStream
                out = new FileOutputStream(filename);

                // Set the default Properties
                prop.setProperty("discord_token", "Set your Discord Token here");
                prop.setProperty("cmd_prefix", "Set your command prefix here");
                prop.setProperty("owner_id", "Set the ID of the bot owner here. Only one Owner may be set here.");

                // Store the properties in the file
                prop.store(out, null);

                System.out.println("The default settings have now been set the bot will now exit.");

                System.exit(1);

            } catch (IOException ioExc2) {

                ioExc2.printStackTrace();

            } finally {

                if (out!=null) {

                    try {

                        out.close();

                    } catch (IOException ioExc3) {

                        ioExc3.printStackTrace();

                    }

                }

            }

        }

    }
