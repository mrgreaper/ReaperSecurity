package com.mrgreaper.reapersecurity.handlers;


import com.mrgreaper.reapersecurity.reference.Reference;
import com.mrgreaper.reapersecurity.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.ServerChatEvent;

/**
 * Created by david on 02/07/2014.
 */
public class ReaperEventHandler {

    private String current;
    private String old;
    private boolean hasPlayed = false;

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MODID)) {
            ConfigHandler.loadConfiguration();
        }
    }


    @SubscribeEvent
    public void TwistedChatEvent(ServerChatEvent event) {
        String chatMessage = event.message;
        //LogHelper.info("message is :" + chatMessage);
        if (ConfigHandler.botsPmChat) { //only talk to the bots if its enabled
            if (chatMessage.startsWith("max")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());

                try {
                    String answer = BotHandler.maxBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(0, 5, 4, 2, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "Max");
                } catch (Exception e) {
                    LogHelper.error("max didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
            if (chatMessage.startsWith("fred")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());
                try {
                    String answer = BotHandler.fredBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(0, 11, 11, 10, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "Fred");
                } catch (Exception e) {
                    LogHelper.error("fred didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
            if (chatMessage.startsWith("george")) {
                String[] messageSplit = chatMessage.split(" ", 2); //so were spliting it at the first space, removing the botname from the start
                String toBot = messageSplit[1];
                ChatHandler.pmChat(event.player, chatMessage, event.player.getDisplayName());
                try {
                    String answer = BotHandler.georgeBot(toBot);
                    if (!event.player.worldObj.isRemote && ConfigHandler.botsUseSpeech) {
                        SpeechThreaded.speechSynth(1, 0, 60, 10, answer);
                    }
                    ChatHandler.pmChat(event.player, answer, "George");
                } catch (Exception e) {
                    LogHelper.error("George didnt want to respond :" + e);
                }
                event.setCanceled(true); //we cancel the chat event to stop disruption to players but also as the bot responds BEFORE the question lol
            }
        }
    }


}
