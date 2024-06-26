package com.sladki.tfccellars.Handlers.Network;

import net.minecraft.entity.player.EntityPlayer;

import com.bioxx.tfc.Handlers.Network.AbstractPacket;
import com.sladki.tfccellars.ModManager;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class InitClientWorldPacket extends AbstractPacket {

    public InitClientWorldPacket() {

    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}

    @Override
    public void handleClientSide(EntityPlayer player) {
        ModManager.registerAnvilRecipes();
    }

    @Override
    public void handleServerSide(EntityPlayer player) {}
}
