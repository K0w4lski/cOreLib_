package com.kowalski_.moreapi.ores;

import java.util.List;

import com.kowalski_.moreapi.mOreApi;
import com.kowalski_.morelib.lib.api.IInitializer;
import com.kowalski_.morelib.lib.api.ItemModelProvider;
import com.kowalski_.morelib.lib.helpers.ItemHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;


public class BlockOre extends OreBase implements IInitializer{

	public static final String[] ORENAMES = {"platinium"};
	public static final ResourceLocation[] ORETEXTURES = new ResourceLocation[ORENAMES.length];
	public static final int[] LIGHT = { 0, 0, 4, 0, 0, 4, 8 };
	public static final int[] RARITY = { 0, 0, 0, 0, 0, 1, 2 };
	
	public static ItemStack orePlatinum;
	
	public BlockOre(String name) {
		super(Material.ROCK, name);
		
		setHarvestLevel("pickaxe", 2);
	}
	
	public BlockOre setCreativeTab(CreativeTabs tab)
	{
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {

		for (int i = 0; i < ORENAMES.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public ResourceLocation getResourceLocation(int metadata) {

		return ORETEXTURES[metadata];
	}

	public void setResourceLoacation() {

		for (int i = 0; i < ORENAMES.length; i++) {
			ORETEXTURES[i] = new ResourceLocation("moreapi:ore/ore_" + ORENAMES[i]);
		}
	}
	
	
	private void registerBlockTextures()
	{
		for(int i = 0; i< ORENAMES.length; i++)
		{
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(Item.getItemFromBlock(this), i, new ModelResourceLocation(ORETEXTURES[i], "inventory"));
		}
	
	}
	
	@Override
	public void registerItemModel(Item itemBlock)
	{
		mOreApi.proxy.registerItemRenderer(itemBlock, 0, "moreapi.ore");
	}
	
	@Override
	public boolean preInit() 
	{
		return true;
	}

	@Override
	public boolean initialize() 
	{
		
		return true;
	}

	@Override
	public boolean postInit() 
	{
		return true;
	}
}