package com.mrgreaper.reapersecurity;

import com.mrgreaper.reapersecurity.handlers.*;
import com.mrgreaper.reapersecurity.proxy.IProxy;
import com.mrgreaper.reapersecurity.reference.*;
import com.mrgreaper.reapersecurity.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by david on 13/07/2014.
 */

@Mod(modid = Reference.MODID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)

public class ReaperSecurity { //

    public static CreativeTabs ReaperSecurity;
    @Mod.Instance(Reference.MODID)
    public static ReaperSecurity instance;

    //materials moved to materials in handlers
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ReaperSecurity = new CreativeTabs(Reference.MOD_NAME) {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return ItemInfo.itemSecurityId;
            }
        };
        FMLCommonHandler.instance().bus().register(new ReaperEventHandler());
        MinecraftForge.EVENT_BUS.register(new ReaperEventHandler());
        ItemInfo.init();//to make things neater lets use an info class
        BlockInfo.init();//and a block one
        Recipies.init();//and a recipie one

        try {
            BotHandler.init();
            LogHelper.info("Bots are loaded");
            //LogHelper.info(BotHandler.fredBot("hello how are you today"));
        } catch (Exception e) {
            LogHelper.error("Bots failed to load :" + e);
        }

        ConfigHandler.init(event.getSuggestedConfigurationFile());


    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new CraftingHandler()); //for our durable items
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new DropsHandler());//register our drop handler example
        EntityInfo.init();


    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {


        LogHelper.info("post initialisation complete!");
    }


}
