package nl.naimverboom.gimmespace.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import nl.naimverboom.gimmespace.GimmeSpace;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            GimmeSpace.MOD_ID);

    public static RegistryObject<CreativeModeTab> GIMMESPACE_TAB = CREATIVE_MODE_TABS.register("tutorial_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIMESTONE_GAS_CANISTER.get()))
                    .title(Component.translatable("itemGroup.gimmespace_tab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
