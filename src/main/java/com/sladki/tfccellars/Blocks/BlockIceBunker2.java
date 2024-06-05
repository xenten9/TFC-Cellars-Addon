package com.sladki.tfccellars.Blocks;

import com.sladki.tfccellars.TileEntities.TEIceBunker2;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockIceBunker2 extends BlockIceBunker {

    public BlockIceBunker2(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TEIceBunker2();
    }

}
