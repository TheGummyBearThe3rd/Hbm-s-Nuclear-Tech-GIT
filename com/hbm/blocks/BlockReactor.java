package com.hbm.blocks;

import com.hbm.lib.RefStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockReactor extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	protected BlockReactor(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		if(this == ModBlocks.reactor_conductor)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":reactor_conductor_top");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":reactor_conductor_side");
		}
		if(this == ModBlocks.reactor_control)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":reactor_control_top");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":reactor_control_side");
		}
		if(this == ModBlocks.reactor_element)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":reactor_element_top");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":reactor_element_side");
		}
		if(this == ModBlocks.fusion_conductor)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + /*":fusion_conductor_top_alt"*/":block_steel");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + /*":fusion_conductor_alt"*/":fusion_conductor_side");
		}
		if(this == ModBlocks.fusion_center)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":fusion_center_top");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":fusion_center_side");
		}
		if(this == ModBlocks.fusion_motor)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":block_steel");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":fusion_motor_side");
		}
		if(this == ModBlocks.fusion_heater)
		{
			this.iconTop = iconRegister.registerIcon(RefStrings.MODID + ":block_tungsten");
			this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":fusion_heater_side");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : this.blockIcon);
	}

}
