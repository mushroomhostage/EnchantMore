EnchantMore - enchanted hoes, enchanted fishing rods, enchanted shears and more!

EnchantMore adds dozens of new item enchantment effects,
on flint & steel, hoes, shears, fishing rods, and other items --
ranging from entertainingly destructive to legitimately useful.

***[Download 0.8.2 here](http://dev.bukkit.org/server-mods/enchantmore/files/9-enchant-more-0-8-2/)*** - released 2012/03/13

## Features
* More than 50 new enchantment/item combinations
* Items in inventory appear as expected (glowing + descriptive tooltip) 
* No client mods required
* Only adds functionality, does not change any -- all your existing enchanted tools work as expected
* You can disable any effects in config.yml
* Supports enchantments on modded items

**Important**: to enchant items, you currently need to use an enchanting plugin or inventory editor. EnchantMore does not yet enchant items itself or alter enchantment tables. Known plugins compatible with EnchantMore:

* [EasyEnchant](http://dev.bukkit.org/server-mods/easyenchant/) - see the Exception section in the config to enable/disable
* [Tim The Enchanter](http://dev.bukkit.org/server-mods/enchanter/) - /enchant command for ops
* [AutoEnchanter](http://dev.bukkit.org/server-mods/autoenchanter/) - set "unsafe" to true in config 
* [General](http://dev.bukkit.org/server-mods/general/) - supported in v4.3+, enable in config

If you know of any other compatible plugins, let me know and I'll add them here. (If you're writing an enchanting plugin, use addUnsafeEnchantment() and 
ignore canEnchantItem(), then it should be compatible with EnchantMore.)

## Available Effects
*[Vote for your favorite!](http://dev.bukkit.org/server-mods/enchantmore/polls/what-is-your-favorite-enchantment-in-enchant-more-0/)*



## Limitations
* Not all enchantments reasonably combine with one another

* No permission support, incomplete world protection support

* Some effects are overpowered or unstable; be careful!

For all known issues or to file a new bug see [Tickets](http://dev.bukkit.org/server-mods/enchantmore/tickets/).

## Notes
[Slot data](http://wiki.vg/Slot\_Data) protocol reference

Other relevant plugins of interest pertaining to enchantments:

* [Sublimation](http://dev.bukkit.org/server-mods/sublimation/) - silk touch ice, no longer overpowered
* [SilkSpawners](http://dev.bukkit.org/server-mods/silkspawners/) - pickup and move mob spawners with silk touch

Got a cool idea for a new effect? I can't promise I'll implement everything, but all suggestions are welcome!
Feel free to discuss your ideas below, or open a [ticket](http://dev.bukkit.org/server-mods/enchantmore/tickets/)
for more specific requests. Including the specific item + enchantment name is appreciated, preferably
from the available [wanted effects](http://dev.bukkit.org/server-mods/enchantmore/pages/wanted-effects/) list.

Also interested in new potions? Try [PotionsPlus](http://dev.bukkit.org/server-mods/potionsplus/).

***[Fork me on GitHub!](https://github.com/mushroomhostage/EnchantMore)***
