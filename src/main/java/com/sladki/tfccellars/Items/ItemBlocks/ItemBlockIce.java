package com.sladki.tfccellars.Items.ItemBlocks;

import net.minecraft.block.Block;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

public class ItemBlockIce extends ItemTerraBlock {

    public ItemBlockIce(Block block) {
        super(block);
        this.setCreativeTab(TFCTabs.TFC_BUILDING);
    }

}
