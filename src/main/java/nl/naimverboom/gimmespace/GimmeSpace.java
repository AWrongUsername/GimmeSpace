package nl.naimverboom.gimmespace;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nl.naimverboom.gimmespace.block.ModBlocks;
import nl.naimverboom.gimmespace.block.entity.ModBlockEntities;
import nl.naimverboom.gimmespace.item.ModCreativeModeTabs;
import nl.naimverboom.gimmespace.item.ModItems;
import nl.naimverboom.gimmespace.recipe.ModRecipes;
import nl.naimverboom.gimmespace.screen.ModMenuTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GimmeSpace.MOD_ID)
public class GimmeSpace
{
    public static final String MOD_ID = "gimmespace";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GimmeSpace()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
//            MenuScreens.register(ModMenuTypes.LIMESTONE_SMELTER_MENU.get(), LimestoneSmelterScreen::new);
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == ModCreativeModeTabs.GIMMESPACE_TAB.getKey()) {
            event.accept(ModItems.SCREW_BUCKET);
            event.accept(ModItems.AMMONIA_BOTTLE);
            event.accept(ModItems.LIMESTONE_GAS_CANISTER);

            event.accept(ModBlocks.BASIC_SOLID_ROCKET_FUEL);
            event.accept(ModBlocks.HP_SOLID_ROCKET_FUEL);
            event.accept(ModBlocks.GRAIN_CRAFTER);
            event.accept(ModBlocks.LIMESTONE);
            event.accept(ModBlocks.LIMESTONE_SMELTER);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
