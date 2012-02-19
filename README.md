EnchantMore - enchanted hoes, enchanted fishing rods, enchanted shears and more!

EnchantMore adds dozens of new item enchantment effects,
on flint & steel, hoes, shears, fishing rods, and other items --
ranging from entertainingly destructive to legitimately useful.

***New! [Download 0.5.7 here](http://dev.bukkit.org/server-mods/enchantmore/files/6-enchant-more-0-5-7/)*** - released 2012/02/18 (*use this link until sidebar is updated after approval*)

## Features
* More than 50 new enchantment/item combinations
* Items in inventory appear as expected (glowing + descriptive tooltip) 
* No client mods required
* Only adds functionality, does not change any -- all your existing enchanted tools work as expected

**Important**: to enchant items, you currently need to use an enchanting plugin or inventory editor. EnchantMore does not yet enchant items itself or alter enchantment tables. Known plugins compatible with EnchantMore:

* [Tim The Enchanter](http://dev.bukkit.org/server-mods/enchanter/) - /enchant command for ops
* [AutoEnchanter](http://dev.bukkit.org/server-mods/autoenchanter/) - set "unsafe" to true in config 

If you know of any other compatible plugins, let me know and I'll add them here. (If you're writing an enchanting plugin, use addUnsafeEnchantment() and 
ignore canEnchantItem(), then it should be compatible with EnchantMore.)

### Available Effects
* Axe + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Axe + Power = fell tree ([details](http://dev.bukkit.org/server-mods/enchantmore/images/3-axe-power-fell-tree/))
* Boots + Flame = firewalker (set ground on fire)
* Boots + Power = witch's broom (sprint flying)
* Boots + Punch = shift to hover jump
* Bow + Aqua Affinity = freeze water, stun players
* Bow + Bane of Arthropods = poison
* Bow + Efficiency = instant shoot
* Bow + Feather Falling = teleport ([details](http://dev.bukkit.org/server-mods/enchantmore/images/4-bow-feather-falling-teleport/))
* Bow + Fire Aspect = fiery explosions ([details](http://dev.bukkit.org/server-mods/enchantmore/images/5-bow-fire-aspect-fiery-explosions/))
* Bow + Knockback = pierce blocks
* Bow + Looting = steal ([details](http://dev.bukkit.org/server-mods/enchantmore/images/6-bow-looting-steal/))
* Bow + Respiration = stapled arrows (attach adjacent item in inventory)
* Bow + Sharpness = increase velocity
* Bow + Silk Touch = magnetic arrows (transport nearby entity)
* Bow + Smite = strike lightning
* Chestplate + Infinity = god mode (no damage)
* Chestplate + Knockback = reflect arrows
* Fishing Rod + Efficiency = fish faster
* Fishing Rod + Fire Aspect = set mobs on fire
* Fishing Rod + Flame = catch cooked fish
* Fishing Rod + Fortune = catch junk ([details](http://dev.bukkit.org/server-mods/enchantmore/images/7-fishing-rod-fortune-catch-sunken-treasure/))
* Fishing Rod + Looting = catch extra fish
* Fishing Rod + Silk Touch = catch more reliably
* Fishing Rod + Smite = strike mobs with lightning
* Flint & Steel + Aqua Affinity = vaporize water ([details](http://dev.bukkit.org/server-mods/enchantmore/images/9-flint-steel-aqua-affinity-vaporize-water/))
* Flint & Steel + Efficiency = burn faster (turn wood to grass)
* Flint & Steel + Fire Aspect = set mobs on fire
* Flint & Steel + Fire Protection = fire resistance ([details](http://dev.bukkit.org/server-mods/enchantmore/images/10-flint-steel-fire-protection-fire-resistance/))
* Flint & Steel + Respiration = smoke inhalation (confusion effect on player)
* Flint & Steel + Sharpness = fiery explosion
* Flint & Steel + Smite = strike lightning ([details](http://dev.bukkit.org/server-mods/enchantmore/images/8-fishing-rod-smite-strike-lightning/))
* Helmet + Fire Aspect = swim in lava
* Hoe + Aqua Affinity = auto-hydrate ([details](http://dev.bukkit.org/server-mods/enchantmore/images/11-hoe-aqua-affinity-auto-hydrate/))
* Hoe + Bane of Arthropods = toggle downfall
* Hoe + Efficiency = till larger area
* Hoe + Fortune = chance to drop seeds
* Hoe + Power = move time
* Hoe + Respiration = grow ([details](http://dev.bukkit.org/server-mods/enchantmore/images/12-hoe-respiration-grow/))
* Hoe + Silk Touch = collect farmland, crop block, pumpkin/melon stem, cake block, sugarcane block, netherwart block (preserving data)
* Pickaxe + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Pickaxe + Looting = deconstruct (reverse crafting)
* Pickaxe + Power = instantly break anything (including bedrock)
* Pickaxe + Silk Touch II = harvest ice
* Shears + Bane of Arthropods = collect spider eyes
* Shears + Fortune = apples from leaves
* Shears + Looting = more wool (random colors); feathers from chickens, leather from cows
* Shears + Power = hedge trimmer/builder; cut grass
* Shears + Silk Touch = collect cobweb, dead bush
* Shears + Smite = gouge eyes (blindness effect on player)
* Shovel + Flame = auto-smelt ([details](http://dev.bukkit.org/server-mods/enchantmore/images/2-pickaxe-shovel-axe-flame-auto-smelt/))
* Shovel + Power = excavation (dig large area, no drops)
* Shovel + Silk Touch II = harvest fallen snow, fire
* Sword + Fire Protection = return to player when dropped in lava
* Sword + Flame = create semi-permanent lit path
* Sword + Power = strike lightning 100+ meters away
* Sword + Protection = resistance when blocking 

## Limitations
* Not all enchantments reasonably combine with one another

* No protection/permission support (yet)

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