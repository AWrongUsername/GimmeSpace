package nl.naimverboom.gimmespace.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import nl.naimverboom.gimmespace.block.ModBlocks;
import nl.naimverboom.gimmespace.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GrainCrafterBlock extends Block {
    public GrainCrafterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        player.sendSystemMessage(Component.literal("This block is WIP."));

        return super.use(state, level, pos, player, hand, blockHitResult);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof Player p) {
            p.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 20));
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("The Grain Crafter makes various Solid Rocket Fuels.").withStyle(ChatFormatting.DARK_GREEN));
            components.add(Component.literal("For usage instructions, check the manual!").withStyle(ChatFormatting.DARK_GREEN));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(itemStack, blockGetter, components, flag);
    }
}
