
// Auto generated groovyscript example file
// MODS_LOADED: aetherworks

log.info 'mod \'aetherworks\' detected, running script'

// Aetherium Anvil:
// Converts an input item into an output item using the Aetherium Forge Anvil. The anvil requires a specific temperature
// range and a number of hits to process the item. The anvil can fail up to 3 times before the item is destroyed.

mods.aetherworks.anvil.removeByInput(item('aetherworks:item_resource', 9))
mods.aetherworks.anvil.removeByOutput(item('aetherworks:item_resource', 7))
// mods.aetherworks.anvil.removeAll()

mods.aetherworks.anvil.recipeBuilder()
    .input(item('minecraft:iron_ingot'))
    .output(item('minecraft:iron_nugget') * 9)
    .difficulty(2)
    .embersPerHit(100)
    .hits(10)
    .temperature(1900, 2500, 10)
    .register()

mods.aetherworks.anvil.recipeBuilder()
    .input(ore('plateGold'))
    .output(item('minecraft:gold_ingot') * 9)
    .difficulty(4)
    .embersPerHit(150)
    .hits(5)
    .minTemperature(2000)
    .maxTemperature(2100)
    .temperatureFluctuation(50)
    .register()


// Metal Former:
// Converts an input item in addition of an input fluid into an output item using the Aetherium Forge Metal Former.

mods.aetherworks.metal_former.removeByInput(item('minecraft:diamond'))
mods.aetherworks.metal_former.removeByOutput(item('aetherworks:item_resource', 4))
// mods.aetherworks.metal_former.removeAll()

mods.aetherworks.metal_former.recipeBuilder()
    .fluidInput(fluid('water') * 100)
    .input(item('minecraft:iron_ingot'))
    .output(item('minecraft:iron_nugget') * 9)
    .temperature(2000)
    .register()


