package com.mrgreaper.reapersecurity.items;

import com.mrgreaper.reapersecurity.ReaperSecurity;
import com.mrgreaper.reapersecurity.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by david on 23/06/2014.
 */
public class ReaperSecurityItems extends Item {

    public ReaperSecurityItems() {
        this.setCreativeTab(ReaperSecurity.ReaperSecurity);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

}
