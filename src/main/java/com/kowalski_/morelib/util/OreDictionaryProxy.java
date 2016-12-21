package com.kowalski_.morelib.util;

import com.kowalski_.morelib.lib.helpers.ItemHelper;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryProxy {
	public ItemStack getOre(String oreName) {

		if (!oreNameExists(oreName)) {
			return null;
		}
		return ItemHelper.cloneStack(OreDictionary.getOres(oreName).get(0), 1);
	}

	public int getOreID(ItemStack stack) {

		return OreDictionary.getOreIDs(stack)[0];
	}

	public int getOreID(String oreName) {

		return OreDictionary.getOreID(oreName);
	}

	public String getOreName(ItemStack stack) {

		return OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[0]);
	}

	public String getOreName(int oreID) {

		return OreDictionary.getOreName(oreID);
	}

	public boolean isOreIDEqual(ItemStack stack, int oreID) {

		return OreDictionary.getOreIDs(stack)[0] == oreID;
	}

	public boolean isOreNameEqual(ItemStack stack, String oreName) {

		return OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[0]).equals(oreName);
	}

	public boolean oreNameExists(String oreName) {

		return OreDictionary.doesOreNameExist(oreName);
	}

}
