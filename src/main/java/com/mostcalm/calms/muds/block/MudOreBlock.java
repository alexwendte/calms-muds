package com.mostcalm.calms.muds.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MudOreBlock extends Block {
	public static final BooleanProperty HARDENED = BooleanProperty.of("hardened");

	public MudOreBlock(Settings settings) {
		super(settings);
		setDefaultState(getStateManager().getDefaultState().with(HARDENED, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		stateManager.add(HARDENED);
	}

	protected int getExperienceWhenMined(Random random) {
		return MathHelper.nextInt(random, 0, 2);
	}

	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
		if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			int i = this.getExperienceWhenMined(world.random);
			if (i > 0) {
				this.dropExperience(world, pos, i);
			}
		}
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		if (!world.isClient) {
			boolean hardened = state.get(HARDENED);
			world.setBlockState(pos, state.with(HARDENED, !hardened));
		}

		return ActionResult.SUCCESS;
	}

	@Override
	public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
		float f = state.getHardness(world, pos);
		if (f == -1.0F) {
			return 0.0F;
		} else {
			int i = player.canHarvest(state) ? 30 : 100;
			float hardenedF = state.get(HARDENED) ? 10f : .5f;
			return player.getBlockBreakingSpeed(state) / hardenedF / (float) i;
		}
	}

}
