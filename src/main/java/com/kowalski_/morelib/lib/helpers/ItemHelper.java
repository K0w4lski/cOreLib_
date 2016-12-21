package com.kowalski_.morelib.lib.helpers;

import com.kowalski_.morelib.lib.api.ItemModelProvider;
import com.kowalski_.morelib.util.OreDictionaryProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ItemHelper {
	
	public static final String BLOCK = "block";
	public static final String ORE = "ore";
	public static final String DUST = "dust";
	public static final String INGOT = "ingot";
	public static final String NUGGET = "nugget";
	public static final String LOG = "log";
	
	public static OreDictionaryProxy oreProxy = new OreDictionaryProxy();

	private ItemHelper() {

	}

	public static ItemStack cloneStack(Item item, int stackSize) {
		if(item == null)
		{
		return null;
		}
		
		ItemStack stack = new ItemStack(item, stackSize);
				
				return stack;
	}
	
	public static ItemStack cloneStack(ItemStack stack, int stackSize) {
		if(stack == null)
		{
		return null;
		}
		
		ItemStack retStack = stack;
		retStack.stackSize = stackSize;
				
				return retStack;
	}
	
	public static ItemStack cloneStack(Block item, int stackSize) {
		if(item == null)
		{
		return null;
		}
		
		ItemStack stack = new ItemStack(item, stackSize);
				
				return stack;
	}
	
	public static ItemStack cloneStack(ItemStack stack) {
		if(stack == null)
		{
		return null;
		}
		
		ItemStack retStack = stack.copy();
				
				return retStack;
	}


	public static void registerWithHandlers(String oreName, ItemStack stack) {

		OreDictionary.registerOre(oreName, stack);
		RegisterItemStack(stack.getItem());
		FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", stack);
	}
	
	public static <stack extends Item> stack RegisterItemStack(stack stack)
	{
		GameRegistry.register(stack);
		return stack;
	}
}
