package com.mrgreaper.reapersecurity.handlers;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by david on 10/07/2014.
 */
public class ReaperHelper {
    private static String letter = "";
    private static String CodeIs = "";

    public static String securityCode() {
        CodeIs = getLetter() + getLetter() + getLetter() + getLetter() + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + ThreadLocalRandom.current().nextInt(10) + getLetter() + getLetter();
        return CodeIs;
    }

    private static String getLetter() {
        String[] let = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" + "y" + "z"};
        letter = let[ThreadLocalRandom.current().nextInt(let.length)];
        return letter;
    }

    public static ResourceLocation getSkin(String name) {
        ResourceLocation resourcelocation = AbstractClientPlayer.locationStevePng;
        if (name.length() > 0) {
            resourcelocation = AbstractClientPlayer.getLocationSkin(name);
            AbstractClientPlayer.getDownloadImageSkin(resourcelocation, name);
        }
        return resourcelocation;
    }

}
