# Aetherworks Unofficial Extended Life

A dwarven magic addon

## v1.3.0 - Internal Overhaul
### Changes
- updated dependencies
- switched to stable mappings version 39

## v1.2.1 - CraftTweaker fix
### Changes
- Aetherium Ingot and Plate recipes now check for the Bronze OreDict instead of the Embers Bronze variant
- added Comparator support to the Aetherium Anvil, Metal Former and Forge Core
  - when the Anvil or Metal Former contain an item, the Comparator will output a signal strength equal to the amount of items in the inventory
  - when the Anvil has a recipe, the Comparator will output a signal strength of 15 whenever it needs to be smacked with a hammer
  - the Forge Core will output a signal strength equal to its current heat level
- added an entry in the Ancient Codex for the newly added Comparator support

### Bugfixes
- added missing localization entries for all config entries
- fixed broken CraftTweaker methods
- fixed broken mcmeta files (fixes fluid animation)

## v1.2.0 - Config Overhaul
### Changes
- restructured all config entries
- added a bunch more config options to all machines
- use non-deprecated methods to add recipes
- tweaked Forge recipes to accept Ingredient instead of ItemStacks
- tweaked Metal Former recipes to accept Ingredient instead of ItemStacks
- added documentation about the mod to the Ancient Codex
- added GroovyScript support for the Metal Former and Aetherium Anvil

## v1.1.1 - Forge Fix
### Bugfixes
- fixed crash when trying to craft anything with the forge

## v1.1.0 - UEL
### Changes
- added CHANGELOG.md
- switched to RetroFuturaGradle
- updated README.md
- updated repository dependencies
- depend on Embers Unofficial Extended Life

### Bugfixes
- fixed crash when placing any forge related block