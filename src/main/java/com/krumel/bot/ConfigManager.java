package com.krumel.bot;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

    /*
     * Call a new Object of "Properties"
     * Also set the Output path to null for now
     * And set the filename as a String
     */

    private Properties prop = new Properties();
    private OutputStream out = null;
    private InputStream in = null;
    private String filename = "config.properties";

    private boolean checkIfFileExists() {

        try {

            in = new FileInputStream(filename);

        } catch (IOException ioExc) {

            ioExc.printStackTrace();

        } finally {

            try {

                in.close();

            } catch (IOException ioExc4) {

                ioExc4.printStackTrace();

            }

        }

        if (in==null)
            return false;
        else return true;

    }

    private void setDefaultSettings() {

        if (checkIfFileExists()==false) {

            try {

                // Try to set FileOutputStream
                out = new FileOutputStream(filename);

                // Set the default Properties
                prop.setProperty("discord_token", "Set your Discord Token here");
                prop.setProperty("cmd_prefix", "Set your command prefix here");
                prop.setProperty("owner_id", "Set the ID of the bot owner here. Only one Owner may be set here.");

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

}
