package com.hbm.handler.guncfg;

import java.util.ArrayList;

import com.hbm.handler.BulletConfigSyncingUtil;
import com.hbm.handler.BulletConfiguration;
import com.hbm.handler.GunConfiguration;
import com.hbm.items.ModItems;
import com.hbm.render.misc.RenderScreenOverlay.Crosshair;

public class GunGrenadeFactory {
	
	public static GunConfiguration getHK69Config() {
		
		GunConfiguration config = new GunConfiguration();
		
		config.rateOfFire = 30;
		config.roundsPerCycle = 1;
		config.gunMode = GunConfiguration.MODE_NORMAL;
		config.firingMode = GunConfiguration.FIRE_MANUAL;
		config.hasReloadAnim = false;
		config.hasFiringAnim = false;
		config.hasSpinup = false;
		config.hasSpindown = false;
		config.reloadDuration = 40;
		config.firingDuration = 0;
		config.ammoCap = 1;
		config.reloadType = GunConfiguration.RELOAD_SINGLE;
		config.allowsInfinity = true;
		config.crosshair = Crosshair.L_CIRCUMFLEX;
		
		config.name = "Granatpistole HK69";
		config.manufacturer = "Heckler & Koch";
		
		config.config = new ArrayList<Integer>();
		config.config.add(BulletConfigSyncingUtil.GRENADE_NORMAL);
		config.config.add(BulletConfigSyncingUtil.GRENADE_HE);
		config.config.add(BulletConfigSyncingUtil.GRENADE_INCENDIARY);
		config.config.add(BulletConfigSyncingUtil.GRENADE_CHEMICAL);
		config.config.add(BulletConfigSyncingUtil.GRENADE_SLEEK);
		config.durability = 140;
		
		return config;
	}

	public static BulletConfiguration getGrenadeConfig() {
		
		BulletConfiguration bullet = BulletConfigFactory.standardGrenadeConfig();
		
		bullet.ammo = ModItems.ammo_grenade;
		bullet.velocity = 2.0F;
		bullet.dmgMin = 10;
		bullet.dmgMax = 15;
		bullet.wear = 10;
		bullet.trail = 0;
		
		return bullet;
	}
	
	public static BulletConfiguration getGrenadeHEConfig() {
		
		BulletConfiguration bullet = BulletConfigFactory.standardGrenadeConfig();
		
		bullet.ammo = ModItems.ammo_grenade_he;
		bullet.velocity = 2.0F;
		bullet.dmgMin = 20;
		bullet.dmgMax = 15;
		bullet.wear = 10;
		bullet.explosive = 5.0F;
		bullet.trail = 1;
		
		return bullet;
	}
	
	public static BulletConfiguration getGrenadeIncendirayConfig() {
		
		BulletConfiguration bullet = BulletConfigFactory.standardGrenadeConfig();
		
		bullet.ammo = ModItems.ammo_grenade_incendiary;
		bullet.velocity = 2.0F;
		bullet.dmgMin = 15;
		bullet.dmgMax = 15;
		bullet.wear = 10;
		bullet.trail = 0;
		bullet.incendiary = 2;
		
		return bullet;
	}
	
	public static BulletConfiguration getGrenadeChlorineConfig() {
		
		BulletConfiguration bullet = BulletConfigFactory.standardGrenadeConfig();
		
		bullet.ammo = ModItems.ammo_grenade_toxic;
		bullet.velocity = 2.0F;
		bullet.dmgMin = 10;
		bullet.dmgMax = 15;
		bullet.wear = 10;
		bullet.trail = 3;
		bullet.explosive = 0;
		bullet.chlorine = 50;
		
		return bullet;
	}
	
	public static BulletConfiguration getGrenadeSleekConfig() {
		
		BulletConfiguration bullet = BulletConfigFactory.standardGrenadeConfig();
		
		bullet.ammo = ModItems.ammo_grenade_sleek;
		bullet.velocity = 2.0F;
		bullet.dmgMin = 10;
		bullet.dmgMax = 15;
		bullet.wear = 10;
		bullet.trail = 4;
		bullet.explosive = 7.5F;
		bullet.jolt = 6.5D;
		
		return bullet;
	}
}
