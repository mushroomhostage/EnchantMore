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

class EnchantMoreListener implements Listener {
   
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

            if (item.containsEnchantment(Enchantment.DAMAGE_UNDEAD)) { // "Smite"
                world.strikeLightning(block.getLocation());
            }
        }
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
