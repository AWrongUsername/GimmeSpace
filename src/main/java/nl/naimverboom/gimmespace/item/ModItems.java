package nl.naimverboom.gimmespace.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.naimverboom.gimmespace.GimmeSpace;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GimmeSpace.MOD_ID);

    public static final RegistryObject<Item> SCREW_BUCKET = ITEMS.register("screw_bucket",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> AMMONIA_BOTTLE = ITEMS.register("ammonia_bottle",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> LIMESTONE_GAS_CANISTER = ITEMS.register("limestone_gas_canister",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
