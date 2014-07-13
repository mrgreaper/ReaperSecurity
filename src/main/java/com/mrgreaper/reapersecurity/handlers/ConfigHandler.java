package com.mrgreaper.reapersecurity.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by david on 23/06/2014.
 */
public class ConfigHandler {

    public static Configuration configuration;
    public static boolean botsPmChat = true;
    public static boolean botsUseSpeech = true;
    public static boolean easyMode = true;


    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }


    public static void loadConfiguration() {
        botsPmChat = configuration.getBoolean("Bots: can be pm'd ", configuration.CATEGORY_GENERAL, botsPmChat, "Control if players can pm the bots or not");
        botsUseSpeech = configuration.getBoolean("Bots: use Speech ", configuration.CATEGORY_GENERAL, botsUseSpeech, "Can the bots use thier voice to communicate?");
        easyMode = configuration.getBoolean("Option: Easymode", configuration.CATEGORY_GENERAL, easyMode, "easy mode means when you burn errr, i mean cook,a bunny you get a nether star, on false you get a wither skull");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
