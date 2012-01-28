package me.exphc.EnchantMore;

import java.util.Collection;
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

import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.entity.CraftSpider;
import org.bukkit.craftbukkit.entity.CraftCaveSpider;
import org.bukkit.craftbukkit.inventory.CraftItemStack;

import net.minecraft.server.MobEffect;
import net.minecraft.server.FurnaceRecipes;

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

        if (item.getType() == Material.FLINT_AND_STEEL && action == Action.RIGHT_CLICK_BLOCK) {
            World world = block.getWorld();
        
            // Flint & Steel + Smite = strike lightning
            if (item.containsEnchantment(SMITE)) {
                world.strikeLightning(block.getLocation());
            }

            // Flint & Steel + Fire Protection = player fire resistance
            if (item.containsEnchantment(FIRE_PROTECTION)) {
                ((CraftPlayer)player).getHandle().addEffect(new MobEffect(
                    12, // fireResistance - http://wiki.vg/Protocol#Effects
                    20*10*item.getEnchantmentLevel(FIRE_PROTECTION), // length
                    1)); // amplifier
            }

            // Flint & Steel + Aqua Affinity = vaporize water
            if (item.containsEnchantment(AQUA_AFFINITY)) {
                // Can't actually click on water, the click "goes through" as if it was air
                // Not like buckets filled or lily pads placements
                /* 
                if (block.getType() == Material.STATIONARY_WATER || block.getType() == Material.WATER) {
                    block.setType(Material.AIR);
                    plugin.log.info("water");
                }
                */

                // Find water within ignited cube area
                int r = item.getEnchantmentLevel(AQUA_AFFINITY);

                Location loc = block.getLocation();
                int x0 = loc.getBlockX();
                int y0 = loc.getBlockY();
                int z0 = loc.getBlockZ();
               
                for (int dx = -r; dx <= r; dx += 1) {
                    for (int dy = -r; dy <= r; dy += 1) {
                        for (int dz = -r; dz <= r; dz += 1) {
                            Block b = world.getBlockAt(dx+x0, dy+y0, dz+z0);
                           
                            if (b.getType() == Material.STATIONARY_WATER || b.getType() == Material.WATER) {
                                b.setType(Material.AIR);
                                world.playEffect(b.getLocation(), Effect.SMOKE, 0); // TODO: direction
                            }
                        }
                    }
                }
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

            // Flint & Steel + Respiration = smoke inhalation (confusion)
            if (item.containsEnchantment(RESPIRATION)) {
                World world = entity.getWorld();

                world.playEffect(entity.getLocation(), Effect.SMOKE, 0);    // TOOD: smoke direction
                world.playEffect(entity.getLocation(), Effect.EXTINGUISH, 0);    // TOOD: smoke direction

                // Confusion effect on players
                if (entity instanceof CraftPlayer) {
                    ((CraftPlayer)entity).getHandle().addEffect(new MobEffect(
                        9,      // confusion  - http://wiki.vg/Protocol#Effects
                        20*10*item.getEnchantmentLevel(RESPIRATION),  // length
                        1));    // amplifier
                }
            }
        } else if (item.getType() == Material.SHEARS) {
            // Shears + Smite = gouge eyes (blindness)
            if (item.containsEnchantment(SMITE)) {
                if (entity instanceof CraftPlayer) {
                    ((CraftPlayer)entity).getHandle().addEffect(new MobEffect(
                        15,     // blindness
                        20*10*item.getEnchantmentLevel(SMITE),  // length
                        1));    // amplifier
                }
                // TODO: use durability
            }

            // Shears + Bane of Arthropods = collect spider eyes
            if (item.containsEnchantment(BANE)) {
                if (entity instanceof CaveSpider || entity instanceof Spider) {
                    Creature bug = (Creature)entity;

                    // If at least 50% health, cut out eyes, then drop health
                    if (bug.getHealth() >= bug.getMaxHealth() / 2) {
                        World world = player.getWorld();

                        world.dropItemNaturally(bug.getEyeLocation(), new ItemStack(Material.SPIDER_EYE, 1));

                        bug.setHealth(bug.getMaxHealth() / 2 - 1);
                    }
                }
                // TODO: use durability
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

    @EventHandler(priority = EventPriority.NORMAL) 
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack item = player.getItemInHand();

        if (item == null) {
            return;
        }

        if (item.getType() == Material.DIAMOND_PICKAXE ||
            item.getType() == Material.GOLD_PICKAXE ||
            item.getType() == Material.IRON_PICKAXE ||
            item.getType() == Material.STONE_PICKAXE ||     // TODO: cleaner 'is pickaxe' data
            item.getType() == Material.WOOD_PICKAXE ||

            item.getType() == Material.DIAMOND_SPADE ||
            item.getType() == Material.GOLD_SPADE ||
            item.getType() == Material.IRON_SPADE ||
            item.getType() == Material.STONE_SPADE ||
            item.getType() == Material.WOOD_SPADE ||

            item.getType() == Material.DIAMOND_AXE ||
            item.getType() == Material.GOLD_AXE ||
            item.getType() == Material.IRON_AXE ||
            item.getType() == Material.STONE_AXE ||
            item.getType() == Material.WOOD_AXE) {

            // Pickaxe/shovel/axe + Flame = auto-smelt
            if (item.containsEnchantment(FLAME)) {
                Collection<ItemStack> rawDrops = block.getDrops(item);
                World world = player.getWorld();

                for (ItemStack rawDrop: rawDrops) {
                    ItemStack smeltedDrop = smelt(rawDrop);

                    world.dropItemNaturally(block.getLocation(), smeltedDrop);
                }


                block.setType(Material.AIR);
            }
        }
    }

    // Get item as if it was smelted
    private ItemStack smelt(ItemStack raw) {
        net.minecraft.server.ItemStack smeltNMS = FurnaceRecipes.getInstance().a(raw.getTypeId());

        ItemStack smelted = (ItemStack)(new CraftItemStack(smeltNMS));
    
        return smelted;
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
