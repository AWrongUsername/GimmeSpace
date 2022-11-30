package nl.naimverboom.gimmespace.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab GIMMESPACE_TAB = new CreativeModeTab("gimmespace_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SCREW_BUCKET.get());
        }
    };
}
