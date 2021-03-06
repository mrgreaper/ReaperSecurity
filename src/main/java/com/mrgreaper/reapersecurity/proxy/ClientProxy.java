package com.mrgreaper.reapersecurity.proxy;


import com.mrgreaper.reapersecurity.handlers.AlarmHandler2;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by david on 02/07/2014.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void alarmSound(TileEntity tileEntity, String soundName) {
        AlarmHandler2 alarm2 = new AlarmHandler2(tileEntity, "alarm-airraidA"); //create a new instance of the alarmhandler2
        Minecraft.getMinecraft().getSoundHandler().playSound(alarm2); //make some noise
    }
}
