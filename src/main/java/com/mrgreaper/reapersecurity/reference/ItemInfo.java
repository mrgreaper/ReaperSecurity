package com.mrgreaper.reapersecurity.reference;


import com.mrgreaper.reapersecurity.items.itemSecurityId;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class ItemInfo {
    //rather then clutter up my main java file with item info lets pool it all here

    public static Item itemSecurityId = new itemSecurityId().setUnlocalizedName("SecurityId").setMaxStackSize(1);


    public static void init() {

        GameRegistry.registerItem(itemSecurityId, "SecurityId");

    }
}
