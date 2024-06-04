package sladki.tfc.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.bioxx.tfc.Core.TFCTabs;

import sladki.tfc.Cellars;

public class BlockCellarWall extends BlockTerra {

    public BlockCellarWall(Material material) {
        super(material);
        this.setBlockTextureName(Cellars.MODID + ":" + "cellarWall");
        this.setCreativeTab(TFCTabs.TFC_BUILDING);
        this.setStepSound(Block.soundTypeWood);
    }

}
