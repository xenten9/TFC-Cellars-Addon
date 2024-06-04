package com.sladki.tfccellars.Items.Tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.bioxx.tfc.api.TFCBlocks;
import com.google.common.collect.Sets;
import com.sladki.tfccellars.Cellars;
import com.sladki.tfccellars.ModManager;

public class ItemIceSaw extends ItemTerraTool {

    private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(new Block[] { TFCBlocks.ice });

    public ItemIceSaw(ToolMaterial material) {
        super(1.0f, material, blocksEffectiveAgainst);
    }

    @Override
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
        return par2Block != null && par2Block.getMaterial() == Material.ice ? this.efficiencyOnProperMaterial * 0.1F
            : super.func_150893_a(par1ItemStack, par2Block);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        String name = this.getUnlocalizedName()
            .replace("item.", "");
        this.itemIcon = register.registerIcon(Cellars.MODID + ":" + "tools/" + name);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z,
        EntityLivingBase player) {
        super.onBlockDestroyed(itemStack, world, block, x, y, z, player);

        if (world.isRemote) {
            return false;
        }

        if (block == TFCBlocks.ice || block == ModManager.IceBlock) {
            EntityItem entityItem = new EntityItem(
                world,
                x + 0.5,
                y + 0.5,
                z + 0.5,
                new ItemStack(ModManager.IceBlock, 1));
            world.spawnEntityInWorld(entityItem);
            world.setBlockToAir(x, y, z);
        }
        return true;
    }

}
