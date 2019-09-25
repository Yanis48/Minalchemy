package com.yanis48.minalchemy.container;

import java.util.Optional;

import com.yanis48.minalchemy.init.MinalchemyBlocks;
import com.yanis48.minalchemy.init.MinalchemyRecipes;
import com.yanis48.minalchemy.init.MinalchemyTags;
import com.yanis48.minalchemy.recipe.AlchemyRecipe;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.packet.GuiSlotUpdateS2CPacket;
import net.minecraft.container.BlockContext;
import net.minecraft.container.CraftingContainer;
import net.minecraft.container.CraftingResultSlot;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.DefaultedList;
import net.minecraft.world.World;

public class AlchemyTableContainer extends CraftingContainer<CraftingInventory> {
	private final CraftingInventory alchemyInv;
	private final CraftingResultInventory resultInv;
	private final BlockContext context;
	private final World world;
	private final PlayerEntity player;

	public AlchemyTableContainer(int syncId, PlayerEntity player) {
		this(syncId, player.inventory, BlockContext.EMPTY);
	}

	public AlchemyTableContainer(int syncId, PlayerInventory playerInv, BlockContext blockContext) {
		super(null, syncId);
		this.alchemyInv = new CraftingInventory(this, 1, 2) {
			@Override
			public void markDirty() {
				super.markDirty();
				AlchemyTableContainer.this.onContentChanged(this);
			}
		};
		this.resultInv = new CraftingResultInventory();
		this.context = blockContext;
		this.player = playerInv.player;
		this.world = player.world;
		
		// Input Slot 1
		this.addSlot(new Slot(this.alchemyInv, 0, 49, 23) {
			public boolean canInsert(ItemStack stack) {
				return stack.getItem().isIn(MinalchemyTags.ELEMENTS);
			}
		});
		
		// Input Slot 2
		this.addSlot(new Slot(this.alchemyInv, 1, 49, 44) {
			public boolean canInsert(ItemStack stack) {
				return stack.getItem().isIn(MinalchemyTags.ELEMENTS);
			}
		});
		
		// Output Slot
		this.addSlot(new CraftingResultSlot(this.player, this.alchemyInv, this.resultInv, 2, 129, 34) {
			@Override
			public ItemStack onTakeItem(PlayerEntity player, ItemStack stack) {
				this.onCrafted(stack);
				DefaultedList<ItemStack> list = player.world.getRecipeManager().getRemainingStacks(MinalchemyRecipes.ALCHEMY, alchemyInv, player.world);
				for(int i = 0; i < list.size(); ++i) {
					ItemStack inputStack = alchemyInv.getInvStack(i);
					ItemStack stackInList = (ItemStack) list.get(i);
					if (!inputStack.isEmpty()) {
						alchemyInv.takeInvStack(i, 1);
						inputStack = alchemyInv.getInvStack(i);
					}
					if (!stackInList.isEmpty()) {
						if (inputStack.isEmpty()) {
							alchemyInv.setInvStack(i, stackInList);
						} else if (ItemStack.areItemsEqualIgnoreDamage(inputStack, stackInList) && ItemStack.areTagsEqual(inputStack, stackInList)) {
							stackInList.increment(inputStack.getCount());
							alchemyInv.setInvStack(i, stackInList);
						} else if (!player.inventory.insertStack(stackInList)) {
							player.dropItem(stackInList, false);
						}
					}
				}
				return stack;
			}
		});
		
		// Player Inventory
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		// Player Hotbar
		for(int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return canUse(this.context, player, MinalchemyBlocks.ALCHEMY_TABLE);
	}
	
	@Override
	public void onContentChanged(Inventory inv) {
		updateResult(this.syncId, this.world, this.player, this.alchemyInv, this.resultInv);
	}
	
	protected static void updateResult(int syncId, World world, PlayerEntity player, CraftingInventory alchemyInv, CraftingResultInventory resultInv) {
		if (!world.isClient) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			ItemStack stack = ItemStack.EMPTY;
			Optional<AlchemyRecipe> optional = world.getServer().getRecipeManager().getFirstMatch(MinalchemyRecipes.ALCHEMY, alchemyInv, world);
			if (optional.isPresent()) {
				AlchemyRecipe recipe = optional.get();
				stack = recipe.craft(alchemyInv);
				stack.setCount(1);
			}
			resultInv.setInvStack(2, stack);
	        serverPlayer.networkHandler.sendPacket(new GuiSlotUpdateS2CPacket(syncId, 2, stack));
		}
	}
	
	@Override
	public void close(PlayerEntity player) {
		super.close(player);
		this.dropInventory(player, world, this.alchemyInv);
	}
	
	public ItemStack transferSlot(PlayerEntity player, int slotNum) {
		ItemStack stackToTransfer = ItemStack.EMPTY;
		Slot slot = this.slotList.get(slotNum);
		if (slot != null && slot.hasStack()) {
			ItemStack stackInSlot = slot.getStack();
			stackToTransfer = stackInSlot.copy();
			ItemStack stackInSlot1 = this.alchemyInv.getInvStack(0);
			ItemStack stackInSlot2 = this.alchemyInv.getInvStack(1);
			if (slotNum == 2) {
				if (!this.insertItem(stackInSlot, 3, 39, true)) {
					return ItemStack.EMPTY;
				}
				stackInSlot.getItem().onCraft(stackInSlot, world, player);
				//slot.onStackChanged(stackInSlot, stackToTransfer);
			} else if (slotNum != 0 && slotNum != 1) {
				if (!stackInSlot1.isEmpty() && !stackInSlot2.isEmpty()) {
					if (slotNum >= 3 && slotNum < 30) {
						if (!this.insertItem(stackInSlot, 30, 39, false)) {
							return ItemStack.EMPTY;
						}
					} else if (slotNum >= 30 && slotNum < 39 && !this.insertItem(stackInSlot, 3, 30, false)) {
						return ItemStack.EMPTY;
					}
				} else if (!this.insertItem(stackInSlot, 0, 2, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.insertItem(stackInSlot, 3, 39, false)) {
				return ItemStack.EMPTY;
			}
			if (stackInSlot.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
			if (stackInSlot.getCount() == stackToTransfer.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTakeItem(player, stackInSlot);
		}
		return stackToTransfer;
	}

	@Override
	public void populateRecipeFinder(RecipeFinder finder) {
		((RecipeInputProvider) this.alchemyInv).provideRecipeInputs(finder);
	}

	@Override
	public void clearCraftingSlots() {
		this.alchemyInv.clear();
		this.resultInv.clear();
	}

	@Override
	public boolean matches(Recipe<? super CraftingInventory> recipe) {
		return recipe.matches(this.alchemyInv, this.world);
	}

	@Override
	public int getCraftingResultSlotIndex() {
		return 2;
	}

	@Override
	public int getCraftingWidth() {
		return this.alchemyInv.getWidth();
	}

	@Override
	public int getCraftingHeight() {
		return this.alchemyInv.getHeight();
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getCraftingSlotCount() {
		return 3;
	}
}
