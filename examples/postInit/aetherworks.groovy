
// Auto generated groovyscript example file
// MODS_LOADED: aetherworks

log.info 'mod \'aetherworks\' detected, running script'

// groovyscript.wiki.aetherworks.metal_former.title:
// groovyscript.wiki.aetherworks.metal_former.description.

mods.aetherworks.metal_former.removeByInput(item('minecraft:diamond'))
mods.aetherworks.metal_former.removeByOutput(item('aetherworks:item_resource', 4))
// mods.aetherworks.metal_former.removeAll()

mods.aetherworks.metal_former.recipeBuilder()
    .fluidInput(fluid('water') * 100)
    .input(item('minecraft:iron_ingot'))
    .output(item('minecraft:iron_nugget') * 9)
    .temperature(2000)
    .register()


