package com.mrgreaper.reapersecurity.reference;


import com.mrgreaper.reapersecurity.ReaperSecurity;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by david on 23/06/2014.
 */
public class BlockInfo {
    //same as iteminfo lets reduce clutter of the main class

    public static final int guiIDSecurityId = 0;

    public static Block blockAlarmSpeaker = new com.mrgreaper.reapersecurity.blocks.blockAlarmSpeaker(Material.iron).setBlockName("blockAlarmSpeaker").setCreativeTab(ReaperSecurity.ReaperSecurity);

    public static void init() {
        GameRegistry.registerBlock(blockAlarmSpeaker, "blockAlarmSpeaker");
    }
}
