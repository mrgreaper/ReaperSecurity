package com.mrgreaper.reapersecurity.handlers;


import com.mrgreaper.reapersecurity.container.ContainerIdCard;
import com.mrgreaper.reapersecurity.gui.guiSecurityIdCard;
import com.mrgreaper.reapersecurity.reference.BlockInfo;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by david on 26/06/2014.
 */
public class GuiHandler implements IGuiHandler {


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {//ok so if we are going to have gui on some items i need to not check to see if the tile entity is legit...after all it wont be in existence
        TileEntity entity = world.getTileEntity(x, y, z);
        switch (ID) {
            case BlockInfo.guiIDSecurityId:
                return new ContainerIdCard(player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //ok so if we are going to have gui on some items i need to not check to see if the tile entity is legit...after all it wont be in existence
        TileEntity entity = world.getTileEntity(x, y, z);
        switch (ID) {
            case BlockInfo.guiIDSecurityId:
                return new guiSecurityIdCard(player, player.getCurrentEquippedItem());
        }
        return null;
    }
}
