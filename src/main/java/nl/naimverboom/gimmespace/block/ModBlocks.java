package nl.naimverboom.gimmespace.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.naimverboom.gimmespace.GimmeSpace;
import nl.naimverboom.gimmespace.block.custom.GrainCrafterBlock;
import nl.naimverboom.gimmespace.block.custom.LimestoneSmelter;
import nl.naimverboom.gimmespace.item.ModCreativeModeTab;
import nl.naimverboom.gimmespace.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GimmeSpace.MOD_ID);


    // BLOCKS
    public static final RegistryObject<Block> BASIC_SOLID_ROCKET_FUEL = registerBlock("basic_solid_rocket_fuel", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).requiresCorrectToolForDrops().strength(2f).sound(SoundType.GRAVEL)), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<Block> HP_SOLID_ROCKET_FUEL = registerBlock("hp_solid_rocket_fuel", () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).requiresCorrectToolForDrops().strength(2f).sound(SoundType.GRAVEL)), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<GrainCrafterBlock> GRAIN_CRAFTER = registerBlock("grain_crafter", () -> new GrainCrafterBlock(BlockBehaviour.Properties.of(Material.METAL)
            .strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<Block> ALUMINIUM_PLATING = registerBlock("aluminium_plating",() -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(2f).sound(SoundType.METAL)), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<Block> POWER_SOCKET = registerBlock("power_socket",() -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(2f).sound(SoundType.METAL)), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1f)), ModCreativeModeTab.GIMMESPACE_TAB);
    public static final RegistryObject<LimestoneSmelter> LIMESTONE_SMELTER = registerBlock("limestone_smelter", () -> new LimestoneSmelter(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5f).noOcclusion()), ModCreativeModeTab.GIMMESPACE_TAB);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
