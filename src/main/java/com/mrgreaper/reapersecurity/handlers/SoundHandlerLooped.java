package com.mrgreaper.reapersecurity.handlers;


import com.mrgreaper.reapersecurity.reference.Reference;
import com.mrgreaper.reapersecurity.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by david on 06/07/2014.
 */
@SideOnly(Side.CLIENT)
public class SoundHandlerLooped extends MovingSound {
    private final TileEntity tileentity;


    public SoundHandlerLooped(TileEntity tile, String Soundname) {
        super(new ResourceLocation(Reference.MODID + ":" + Soundname));
        this.tileentity = tile;
        this.repeat = true;
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
    }


    public void update() {
        LogHelper.info("i should be making noise oh and volume is " + volume);
        if (this.tileentity.isInvalid()) {
            LogHelper.info("ok ill shut up now");
            this.donePlaying = true;
        }
    }

    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }
}

