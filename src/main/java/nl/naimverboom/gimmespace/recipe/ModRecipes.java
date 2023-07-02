package nl.naimverboom.gimmespace.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nl.naimverboom.gimmespace.GimmeSpace;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, GimmeSpace.MOD_ID);

    public static final RegistryObject<RecipeSerializer<LimestoneSmelterRecipe>> LIMESTONE_SMELTER_SERIALIZER = SERIALIZERS.register("limestone_smelting", () -> LimestoneSmelterRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
