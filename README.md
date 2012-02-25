EnchantMore - enchanted hoes, enchanted fishing rods, enchanted shears and more!

EnchantMore adds dozens of new item enchantment effects,
on flint & steel, hoes, shears, fishing rods, and other items --
ranging from entertainingly destructive to legitimately useful.

***New! [Download 0.7.5 here](http://dev.bukkit.org/server-mods/enchantmore/files/8-enchant-more-0-7-5/)*** - released 2012/02/25, 
*use this link instead of the links on the sidebar to get the newest version*

## Features
* More than 50 new enchantment/item combinations
* Items in inventory appear as expected (glowing + descriptive tooltip) 
* No client mods required
* Only adds functionality, does not change any -- all your existing enchanted tools work as expected

**Important**: to enchant items, you currently need to use an enchanting plugin or inventory editor. EnchantMore does not yet enchant items itself or alter enchantment tables. Known plugins compatible with EnchantMore:

* [EasyEnchant](http://dev.bukkit.org/server-mods/easyenchant/) - see the Exception section in the config to enable/disable
* [Tim The Enchanter](http://dev.bukkit.org/server-mods/enchanter/) - /enchant command for ops
* [AutoEnchanter](http://dev.bukkit.org/server-mods/autoenchanter/) - set "unsafe" to true in config 

If you know of any other compatible plugins, let me know and I'll add them here. (If you're writing an enchanting plugin, use addUnsafeEnchantment() and 
ignore canEnchantItem(), then it should be compatible with EnchantMore.)

## Available Effects
*[Vote for your favorite!](http://dev.bukkit.org/server-mods/enchantmore/polls/what-is-your-favorite-enchantment-in-enchant-more-0/)*

* Axe + Aqua Affinity = slowness effect
* Axe + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Axe + Flame II = auto-smelt and lit path
* Axe + Power = fell tree ([details](http://dev.bukkit.org/server-mods/enchantmore/images/3-axe-power-fell-tree/))
* Axe + Respiration = generate tree
* Boots + Flame = firewalker (set ground on fire)
* Boots + Power = witch's broom (sprint flying)
* Boots + Punch = hover jump (double-tap shift)
* Bow + Aqua Affinity = freeze water, stun players
* Bow + Bane of Arthropods = poison
* Bow + Efficiency = instant shoot
* Bow + Feather Falling = teleport ([details](http://dev.bukkit.org/server-mods/enchantmore/images/4-bow-feather-falling-teleport/))
* Bow + Feather Falling II = grapple hook (hold Shift to hang on)
* Bow + Fire Aspect = fiery explosions ([details](http://dev.bukkit.org/server-mods/enchantmore/images/5-bow-fire-aspect-fiery-explosions/))
* Bow + Knockback = pierce blocks
* Bow + Looting = steal ([details](http://dev.bukkit.org/server-mods/enchantmore/images/6-bow-looting-steal/))
* Bow + Respiration = stapled arrows (attach adjacent item in inventory)
* Bow + Sharpness = increase velocity
* Bow + Silk Touch = magnetic arrows (transport nearby entity)
* Bow + Smite = strike lightning
* Chestplate + Infinity = god mode (no damage/hunger)
* Chestplate + Knockback = reflect arrows
* Chestplate + Sharpness = reflect damage 
* Chestplate + Silk Touch = cactus protection (no contact damage)
* Fishing Rod + Efficiency = fish faster
* Fishing Rod + Fire Aspect = set mobs on fire
* Fishing Rod + Flame = catch cooked fish
* Fishing Rod + Fortune = catch junk ([details](http://dev.bukkit.org/server-mods/enchantmore/images/7-fishing-rod-fortune-catch-sunken-treasure/))
* Fishing Rod + Looting = catch extra fish
* Fishing Rod + Sharpness = damage mobs
* Fishing Rod + Silk Touch = catch more reliably
* Fishing Rod + Smite = strike mobs with lightning
* Flint & Steel + Aqua Affinity = vaporize water ([details](http://dev.bukkit.org/server-mods/enchantmore/images/9-flint-steel-aqua-affinity-vaporize-water/))
* Flint & Steel + Blast Protection = anti-creeper (cancel nearby explosion)
* Flint & Steel + Efficiency = burn faster (turn wood to grass)
* Flint & Steel + Fire Aspect = set mobs on fire
* Flint & Steel + Fire Protection = fire resistance ([details](http://dev.bukkit.org/server-mods/enchantmore/images/10-flint-steel-fire-protection-fire-resistance/))
* Flint & Steel + Punch = cannon
* Flint & Steel + Respiration = smoke inhalation (confusion effect)
* Flint & Steel + Sharpness = fiery explosion
* Flint & Steel + Silk Touch = remote detonate (ignite TNT)
* Flint & Steel + Smite = strike lightning ([details](http://dev.bukkit.org/server-mods/enchantmore/images/8-fishing-rod-smite-strike-lightning/))
* Helmet + Fire Aspect = swim in lava
* Hoe + Aqua Affinity = auto-hydrate ([details](http://dev.bukkit.org/server-mods/enchantmore/images/11-hoe-aqua-affinity-auto-hydrate/))
* Hoe + Bane of Arthropods = downpour
* Hoe + Efficiency = till larger area
* Hoe + Fire Protection = sensor
* Hoe + Fortune = chance to drop seeds
* Hoe + Power = move time
* Hoe + Punch = grow animal
* Hoe + Respiration = grow ([details](http://dev.bukkit.org/server-mods/enchantmore/images/12-hoe-respiration-grow/))
* Hoe + Silk Touch = collect farmland, crop block, pumpkin/melon stem, cake block, sugarcane block, netherwart block (preserving data)
* Leggings + Feather Falling = surface (triple-tap shift)
* Leggings + Punch = rocket launch pants (double-tap shift)
* Pickaxe + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Pickaxe + Flame II = auto-smelt and light path
* Pickaxe + Looting = deconstruct (reverse crafting)
* Pickaxe + Power = instantly break anything (including bedrock)
* Pickaxe + Sharpness = mine ore vein
* Pickaxe + Silk Touch II = harvest ice, double slabs
* Shears + Bane of Arthropods = collect spider eyes
* Shears + Fortune = apples from leaves
* Shears + Looting = more wool (random colors); feathers from chickens, leather from cows, saddles from saddled pigs
* Shears + Power = hedge trimmer/builder; cut grass
* Shears + Silk Touch = collect cobweb, dead bush
* Shears + Smite = gouge eyes (blindness effect)
* Shovel + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Shovel + Flame II = auto-smelt and light path
* Shovel + Power = excavation (dig large area, no drops)
* Shovel + Silk Touch II = harvest fallen snow, fire
* Sword + Fire Protection = return to player when dropped in lava
* Sword + Flame = create semi-permanent lit path
* Sword + Power = strike lightning far away
* Sword + Protection = resistance when blocking 
* Sword + Silk Touch = capture (right-click to drop creature/boat/minecart/primedTNT as item)

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

***[Fork me on GitHub!](https://github.com/mushroomhostage/EnchantMore)***
