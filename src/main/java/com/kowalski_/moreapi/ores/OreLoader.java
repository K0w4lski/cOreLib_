package com.kowalski_.moreapi.ores;

import com.kowalski_.morelib.lib.api.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OreLoader{
	
	public static BlockOre ore;
	
	public static void preInit()
	{

	}
	
	public static void Init()
	{
		ore = register(new BlockOre("Ore").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
	}
	
	private static <T extends Block> T register (T block, ItemBlock itemBlock) {
		 
		GameRegistry.register(block);
		if(itemBlock != null) {
			GameRegistry.register(itemBlock);
		}
		 
		if(block instanceof ItemModelProvider) {
			 ((ItemModelProvider)block).registerItemModel(itemBlock);
	 	}
		 
		return block;
	}
		 
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	 }
		

	
	public static void RemoveOres()
	{
		
	}
}

/*
public void generateSurface(World world, java.util.Random rand, int chunkX, int chunkZ) {
	for(int x = 0; x<BlockList.length; x++){
		for (int i = 0; i < 3; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(11) + 0;
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(BlockList[x].getDefaultState(), 10))
			.generate(world, rand, new BlockPos(randPosX, randPosY, randPosZ));
		}
	}
}*/