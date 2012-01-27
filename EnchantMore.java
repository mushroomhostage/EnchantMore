package me.exphc.EnchantMore;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Formatter;
import java.lang.Byte;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.io.*;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.Material.*;
import org.bukkit.material.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.configuration.*;
import org.bukkit.configuration.file.*;
import org.bukkit.scheduler.*;
import org.bukkit.enchantments.*;
import org.bukkit.*;

import org.bukkit.craftbukkit.entity.CraftPlayer;

import net.minecraft.server.MobEffectList;
import net.minecraft.server.MobEffect;

class EnchantMoreListener implements Listener {

    // Better enchantment names more closely matching in-game display
    // TODO: replace with ItemStackX
    final Enchantment PROTECTION = Enchantment.PROTECTION_ENVIRONMENTAL;
    final Enchantment FIRE_PROTECTION = Enchantment.PROTECTION_FIRE;
    final Enchantment FEATHER_FALLING = Enchantment.PROTECTION_FALL;
    final Enchantment BLAST_PROTECTION = Enchantment.PROTECTION_EXPLOSIONS;
    final Enchantment PROJECTILE_PROTECTION = Enchantment.PROTECTION_PROJECTILE;
    final Enchantment RESPIRATION = Enchantment.OXYGEN;
    final Enchantment AQUA_AFFINITY = Enchantment.WATER_WORKER;
    final Enchantment SHARPNESS = Enchantment.DAMAGE_ALL;
    final Enchantment SMITE = Enchantment.DAMAGE_UNDEAD;
    final Enchantment BANE = Enchantment.DAMAGE_ARTHROPODS;
    final Enchantment KNOCKBACK = Enchantment.KNOCKBACK;
    final Enchantment FIRE_ASPECT = Enchantment.FIRE_ASPECT;
    final Enchantment LOOTING = Enchantment.LOOT_BONUS_MOBS;
    final Enchantment EFFICIENCY = Enchantment.DIG_SPEED;
    final Enchantment SILK_TOUCH = Enchantment.SILK_TOUCH;
    final Enchantment UNBREAKING = Enchantment.DURABILITY;
    final Enchantment FORTUNE = Enchantment.LOOT_BONUS_BLOCKS;
    final Enchantment POWER = Enchantment.ARROW_DAMAGE;
    final Enchantment PUNCH = Enchantment.ARROW_KNOCKBACK;
    final Enchantment FLAME = Enchantment.ARROW_FIRE;
    final Enchantment INFINITE = Enchantment.ARROW_INFINITE;
   
    EnchantMore plugin;

    public EnchantMoreListener(EnchantMore pl) {
        plugin = pl;

        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        ItemStack item = event.getItem();
        Action action = event.getAction();
        Player player = event.getPlayer();

        if (item == null) {
            return;
        }

        // Flint & Steel + Smite = strike lightning
        if (item.getType() == Material.FLINT_AND_STEEL && action == Action.RIGHT_CLICK_BLOCK) {
            World world = block.getWorld();

            if (item.containsEnchantment(SMITE)) {
                world.strikeLightning(block.getLocation());
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();

        if (item == null) {
            return;
        }

        if (item.getType() == Material.FLINT_AND_STEEL) {
            if (entity == null) {
                return;
            }

            // Flint & Steel + Fire Aspect = set mobs on fire
            if (item.containsEnchantment(FIRE_ASPECT)) {
                entity.setFireTicks(getFireTicks(item.getEnchantmentLevel(FIRE_ASPECT)));

                // TODO: fix
                item.setDurability((short)(item.getDurability() - 1));
            }

            // Flint & Steel + Respiration = smoke inhalation
            if (item.containsEnchantment(RESPIRATION)) {
                World world = entity.getWorld();

                world.playEffect(entity.getLocation(), Effect.SMOKE, 0);    // TOOD: smoke direction
                world.playEffect(entity.getLocation(), Effect.EXTINGUISH, 0);    // TOOD: smoke direction

                // Confusion effect
                ((CraftPlayer)entity).getHandle().addEffect(new MobEffect(
                    9,      // MobEffectList.CONFUSION
                    20*10,  // length
                    1));    // amplifier
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();

        if (item == null) {
            return;
        }

        if (event.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
            Entity entity = event.getCaught();

            if (entity == null) {
                return;
            }

            // Fishing Rod + Fire Aspect = set mobs on fire
            if (item.containsEnchantment(FIRE_ASPECT)) {
                entity.setFireTicks(getFireTicks(item.getEnchantmentLevel(FIRE_ASPECT)));

                // TODO: fix
                item.setDurability((short)(item.getDurability() - 1));
            }
            
            // Fishing Rod + Smite = strike mobs with lightning
            if (item.containsEnchantment(SMITE)) {
                World world = entity.getWorld();

                world.strikeLightning(entity.getLocation());
            }
        }
    }

    // Get time to burn entity for given enchantment level
    private int getFireTicks(int level) {
         // TODO: configurable ticks per level
        return 20 * 10 * level;
    }
}

public class EnchantMore extends JavaPlugin {
    Logger log = Logger.getLogger("Minecraft");
    EnchantMoreListener listener;

    public void onEnable() {
        listener = new EnchantMoreListener(this);
    }
    
    public void onDisable() {
    }
}
