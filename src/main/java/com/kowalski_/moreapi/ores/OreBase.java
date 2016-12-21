package com.kowalski_.moreapi.ores;

import com.kowalski_.moreapi.mOreApi;
import com.kowalski_.morelib.lib.api.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreBase extends Block implements ItemModelProvider {

	protected String name;
	
	public OreBase(Material material, String name) {
		super(material);
		setHardness(3.0F);
		setResistance(5.0F);
		setSoundType(blockSoundType.STONE);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	@Override
	public void registerItemModel(Item itemBlock) {
		mOreApi.proxy.registerItemRenderer(itemBlock, 0, name);
		
	}
	
	 @Override
	 public OreBase setCreativeTab(CreativeTabs tab) {
		 super.setCreativeTab(tab);
		 return this;
	 }

}
