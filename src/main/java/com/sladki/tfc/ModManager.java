package sladki.tfc;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;
import com.bioxx.tfc.api.Crafting.PlanRecipe;
import com.bioxx.tfc.api.Enums.RuleEnum;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.registry.GameRegistry;
import sladki.tfc.Blocks.BlockCellarDoor;
import sladki.tfc.Blocks.BlockCellarShelf;
import sladki.tfc.Blocks.BlockCellarWall;
import sladki.tfc.Blocks.BlockIce;
import sladki.tfc.Blocks.BlockIceBunker;
import sladki.tfc.Handlers.PlayerTickEventHandler;
import sladki.tfc.Items.ItemBlocks.ItemBlockCellarShelf;
import sladki.tfc.Items.ItemBlocks.ItemBlockCellarWall;
import sladki.tfc.Items.ItemBlocks.ItemBlockIce;
import sladki.tfc.Items.ItemBlocks.ItemBlockIceBunker;
import sladki.tfc.Items.ItemCellarDoor;
import sladki.tfc.Items.Tools.ItemIceSaw;
import sladki.tfc.Items.Tools.ItemIceSawHead;
import sladki.tfc.TileEntities.TECellarShelf;
import sladki.tfc.TileEntities.TEIceBunker;

public class ModManager {

    public static Block CellarWallBlock;
    public static Block IceBunkerBlock;
    public static Block CellarShelfBlock;
    public static Block CellarDoorBlock;
    public static Block IceBlock;

    public static Item CellarDoorItem;

    public static Item BismuthBronzeIceSawHead;
    public static Item BlackBronzeIceSawHead;
    public static Item BlackSteelIceSawHead;
    public static Item BlueSteelIceSawHead;
    public static Item BronzeIceSawHead;
    public static Item CopperIceSawHead;
    public static Item WroughtIronIceSawHead;
    public static Item RedSteelIceSawHead;
    public static Item SteelIceSawHead;

    public static Item BismuthBronzeIceSaw;
    public static Item BlackBronzeIceSaw;
    public static Item BlackSteelIceSaw;
    public static Item BlueSteelIceSaw;
    public static Item BronzeIceSaw;
    public static Item CopperIceSaw;
    public static Item WroughtIronIceSaw;
    public static Item RedSteelIceSaw;
    public static Item SteelIceSaw;

    private static PlayerTickEventHandler playerTickEventHandler = new PlayerTickEventHandler();

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TEIceBunker.class, "IceBunker");
        GameRegistry.registerTileEntity(TECellarShelf.class, "CellarShelf");
    }

    public static void loadBlocks() {
        CellarWallBlock = new BlockCellarWall(Material.wood).setBlockName("CellarWall")
            .setHardness(4);
        IceBunkerBlock = new BlockIceBunker(Material.wood).setBlockName("IceBunker")
            .setHardness(5);
        CellarShelfBlock = new BlockCellarShelf(Material.wood).setBlockName("CellarShelf")
            .setHardness(3);
        CellarDoorBlock = new BlockCellarDoor(Material.wood).setBlockName("CellarDoor")
            .setHardness(4);
        IceBlock = new BlockIce().setHardness(0.5F)
            .setLightOpacity(3)
            .setStepSound(Block.soundTypeGlass)
            .setBlockName("Ice");
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(CellarWallBlock, ItemBlockCellarWall.class, "CellarWall");
        GameRegistry.registerBlock(IceBunkerBlock, ItemBlockIceBunker.class, "IceBunker");
        GameRegistry.registerBlock(CellarShelfBlock, ItemBlockCellarShelf.class, "CellarShelf");
        GameRegistry.registerBlock(CellarDoorBlock, "CellarDoor");
        GameRegistry.registerBlock(IceBlock, ItemBlockIce.class, "Ice");
    }

    public static void loadItems() {
        CellarDoorItem = new ItemCellarDoor();

        BismuthBronzeIceSawHead = new ItemIceSawHead().setUnlocalizedName("BismuthBronzeIceSawBlade");
        BlackBronzeIceSawHead = new ItemIceSawHead().setUnlocalizedName("BlackBronzeIceSawBlade");
        BlackSteelIceSawHead = new ItemIceSawHead().setUnlocalizedName("BlackSteelIceSawBlade");
        BlueSteelIceSawHead = new ItemIceSawHead().setUnlocalizedName("BlueSteelIceSawBlade");
        BronzeIceSawHead = new ItemIceSawHead().setUnlocalizedName("BronzeIceSawBlade");
        CopperIceSawHead = new ItemIceSawHead().setUnlocalizedName("CopperIceSawBlade");
        WroughtIronIceSawHead = new ItemIceSawHead().setUnlocalizedName("WroughtIronIceSawBlade");
        RedSteelIceSawHead = new ItemIceSawHead().setUnlocalizedName("RedSteelIceSawBlade");
        SteelIceSawHead = new ItemIceSawHead().setUnlocalizedName("SteelIceSawBlade");

        BismuthBronzeIceSaw = new ItemIceSaw(TFCItems.bismuthBronzeToolMaterial)
            .setUnlocalizedName("BismuthBronzeIceSaw")
            .setMaxDamage(TFCItems.bismuthBronzeUses);
        BlackBronzeIceSaw = new ItemIceSaw(TFCItems.blackBronzeToolMaterial).setUnlocalizedName("BlackBronzeIceSaw")
            .setMaxDamage(TFCItems.blackBronzeUses);
        BlackSteelIceSaw = new ItemIceSaw(TFCItems.blackSteelToolMaterial).setUnlocalizedName("BlackSteelIceSaw")
            .setMaxDamage(TFCItems.blackSteelUses);
        BlueSteelIceSaw = new ItemIceSaw(TFCItems.blueSteelToolMaterial).setUnlocalizedName("BlueSteelIceSaw")
            .setMaxDamage(TFCItems.blueSteelUses);
        BronzeIceSaw = new ItemIceSaw(TFCItems.bronzeToolMaterial).setUnlocalizedName("BronzeIceSaw")
            .setMaxDamage(TFCItems.bronzeUses);
        CopperIceSaw = new ItemIceSaw(TFCItems.copperToolMaterial).setUnlocalizedName("CopperIceSaw")
            .setMaxDamage(TFCItems.copperUses);
        WroughtIronIceSaw = new ItemIceSaw(TFCItems.ironToolMaterial).setUnlocalizedName("WroughtIronIceSaw")
            .setMaxDamage(TFCItems.wroughtIronUses);
        RedSteelIceSaw = new ItemIceSaw(TFCItems.redSteelToolMaterial).setUnlocalizedName("RedSteelIceSaw")
            .setMaxDamage(TFCItems.redSteelUses);
        SteelIceSaw = new ItemIceSaw(TFCItems.steelToolMaterial).setUnlocalizedName("SteelIceSaw")
            .setMaxDamage(TFCItems.steelUses);
    }

    public static void registerItems() {
        GameRegistry.registerItem(CellarDoorItem, "CellarDoorItem");

        GameRegistry.registerItem(BismuthBronzeIceSawHead, "BismuthBronzeIceSawHead");
        GameRegistry.registerItem(BlackBronzeIceSawHead, "BlackBronzeIceSawHead");
        GameRegistry.registerItem(BlackSteelIceSawHead, "BlackSteelIceSawHead");
        GameRegistry.registerItem(BlueSteelIceSawHead, "BlueSteelIceSawHead");
        GameRegistry.registerItem(BronzeIceSawHead, "BronzeIceSawHead");
        GameRegistry.registerItem(CopperIceSawHead, "CopperIceSawHead");
        GameRegistry.registerItem(WroughtIronIceSawHead, "WroughtIronIceSawHead");
        GameRegistry.registerItem(RedSteelIceSawHead, "RedSteelIceSawHead");
        GameRegistry.registerItem(SteelIceSawHead, "SteelIceSawHead");

        GameRegistry.registerItem(BismuthBronzeIceSaw, "BismuthBronzeIceSaw");
        GameRegistry.registerItem(BlackBronzeIceSaw, "BlackBronzeIceSaw");
        GameRegistry.registerItem(BlackSteelIceSaw, "BlackSteelIceSaw");
        GameRegistry.registerItem(BlueSteelIceSaw, "BlueSteelIceSaw");
        GameRegistry.registerItem(BronzeIceSaw, "BronzeIceSaw");
        GameRegistry.registerItem(CopperIceSaw, "CopperIceSaw");
        GameRegistry.registerItem(WroughtIronIceSaw, "WroughtIronIceSaw");
        GameRegistry.registerItem(RedSteelIceSaw, "RedSteelIceSaw");
        GameRegistry.registerItem(SteelIceSaw, "SteelIceSaw");
    }

    public static void registerRecipes() {
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(CellarDoorItem, 1, 0),
                new Object[] { "PCP", "PSP", "PCP", Character.valueOf('P'), "woodLumber", Character.valueOf('C'),
                    new ItemStack(TFCItems.clayBall), Character.valueOf('S'), new ItemStack(TFCItems.straw) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(CellarWallBlock, 1, 0),
                new Object[] { "PSP", "C C", "PSP", Character.valueOf('P'), "woodLumber", Character.valueOf('C'),
                    new ItemStack(TFCItems.clayBall), Character.valueOf('S'), new ItemStack(TFCItems.straw) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(CellarWallBlock, 1, 0),
                new Object[] { "PCP", "S S", "PCP", Character.valueOf('P'), "woodLumber", Character.valueOf('C'),
                    new ItemStack(TFCItems.clayBall), Character.valueOf('S'), new ItemStack(TFCItems.straw) }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(IceBunkerBlock, 1, 0),
                new Object[] { "P P", "W W", "P P", Character.valueOf('P'), "woodLumber", Character.valueOf('W'),
                    "plankWood" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(CellarShelfBlock, 1, 0),
                new Object[] { "P P", "PPP", "P P", Character.valueOf('P'), "woodLumber" }));

        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(BismuthBronzeIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(BismuthBronzeIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(BlackBronzeIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(BlackBronzeIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(BlackSteelIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(BlackSteelIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(BlueSteelIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(BlueSteelIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(BronzeIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(BronzeIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(CopperIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(CopperIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(WroughtIronIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(WroughtIronIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(RedSteelIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(RedSteelIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
        GameRegistry.addRecipe(
            new ShapedOreRecipe(
                new ItemStack(SteelIceSaw, 1),
                new Object[] { "#", "I", Character.valueOf('#'), new ItemStack(SteelIceSawHead, 1, 0),
                    Character.valueOf('I'), "stickWood" }));
    }

    public static void registerAnvilRecipes() {
        String iceSawPlan = "icesaw";

        Map map = AnvilManager.getInstance()
            .getPlans();
        if (map.containsKey(iceSawPlan)) {
            return;
        }

        if (AnvilManager.world == null) {
            return;
        }

        AnvilManager manager = AnvilManager.getInstance();
        manager.addPlan(
            iceSawPlan,
            new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.UPSETSECONDFROMLAST, RuleEnum.DRAWNOTLAST }));

        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.bismuthBronzeIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.BISMUTHBRONZE,
                new ItemStack(BismuthBronzeIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.blackBronzeIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.BLACKBRONZE,
                new ItemStack(BlackBronzeIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.blackSteelIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.BLACKSTEEL,
                new ItemStack(BlackSteelIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.blueSteelIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.BLUESTEEL,
                new ItemStack(BlueSteelIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.bronzeIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.BRONZE,
                new ItemStack(BronzeIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.copperIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.COPPER,
                new ItemStack(CopperIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.wroughtIronIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.WROUGHTIRON,
                new ItemStack(WroughtIronIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.redSteelIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.REDSTEEL,
                new ItemStack(RedSteelIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
        manager.addRecipe(
            new AnvilRecipe(
                new ItemStack(TFCItems.steelIngot2x),
                null,
                iceSawPlan,
                false,
                AnvilReq.STEEL,
                new ItemStack(SteelIceSawHead, 1)).addRecipeSkill(Global.SKILL_TOOLSMITH));
    }

    public static PlayerTickEventHandler getPlayerTickEventHandler() {
        return playerTickEventHandler;
    }

}
