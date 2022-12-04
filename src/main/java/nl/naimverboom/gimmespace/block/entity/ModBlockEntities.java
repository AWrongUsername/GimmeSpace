package nl.naimverboom.gimmespace.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.naimverboom.gimmespace.GimmeSpace;
import nl.naimverboom.gimmespace.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GimmeSpace.MOD_ID);

    public static final RegistryObject<BlockEntityType<LimestoneSmelterBlockEntity>> LIMESTONE_SMELTER =
            BLOCK_ENTITIES.register("limestone_smelter", () -> BlockEntityType.Builder.of(LimestoneSmelterBlockEntity::new,
                    ModBlocks.LIMESTONE_SMELTER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
