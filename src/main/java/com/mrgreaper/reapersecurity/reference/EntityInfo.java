package com.mrgreaper.reapersecurity.reference;

import com.mrgreaper.reapersecurity.entitys.TileEntitySpeaker;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by david on 26/06/2014.
 */
public class EntityInfo {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySpeaker.class, "twistedSpeaker");
    }
}
