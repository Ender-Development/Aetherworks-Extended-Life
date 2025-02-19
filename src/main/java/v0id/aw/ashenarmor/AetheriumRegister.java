package v0id.aw.ashenarmor;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.item.IModeledItem;
import v0id.aw.ashenarmor.items.*;
import v0id.aw.lib.AWConsts;

@Mod.EventBusSubscriber(modid = AWConsts.MODID)
public class AetheriumRegister {
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AETHERIUM = EnumHelper.addArmorMaterial(
            "armor_material_aetherium",
            "aw:ingot_aether",
            30, new int[]{4, 8, 6, 4},
            30,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            2.0f);

    public static final Item AETHERIUM_ASHEN_HELMET = new AetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.HEAD);
    public static final Item AETHERIUM_ASHEN_CHESTPLATE = new AetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.CHEST);
    public static final Item AETHERIUM_ASHEN_LEGGINGS = new AetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 2, EntityEquipmentSlot.LEGS);
    public static final Item AETHERIUM_ASHEN_BOOTS = new AetheriumAshenCloak(ARMOR_MATERIAL_AETHERIUM, 1, EntityEquipmentSlot.FEET);
    public static final Item AETHERIUM_STAFF = new AetheriumStaff();
    public static final Item AETHERIUM_AXE = new AetheriumClockworkAxe("aetheriumclockworkaxe", true);
    public static final Item AETHERIUM_PICKAXE = new AetheriumClockworkPickaxe("aetheriumclockworkpickaxe", true);
    public static final Item AETHERIUM_BLAZING_RAY = new AetheriumBlazingRay();
    public static final Item AETHERIUM_HAMMER = new AetheriumClockworkGrandhammer("aetheriumclockworkgrandhammer", true);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(AETHERIUM_ASHEN_HELMET);
        event.getRegistry().register(AETHERIUM_ASHEN_CHESTPLATE);
        event.getRegistry().register(AETHERIUM_ASHEN_LEGGINGS);
        event.getRegistry().register(AETHERIUM_ASHEN_BOOTS);
        event.getRegistry().register(AETHERIUM_STAFF);
        event.getRegistry().register(AETHERIUM_AXE);
        event.getRegistry().register(AETHERIUM_PICKAXE);
        event.getRegistry().register(AETHERIUM_HAMMER);
        event.getRegistry().register(AETHERIUM_BLAZING_RAY);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        ((ArmorBase) AETHERIUM_ASHEN_HELMET).initModel();
        ((ArmorBase) AETHERIUM_ASHEN_CHESTPLATE).initModel();
        ((ArmorBase) AETHERIUM_ASHEN_LEGGINGS).initModel();
        ((ArmorBase) AETHERIUM_ASHEN_BOOTS).initModel();
        ((AetheriumBase) AETHERIUM_STAFF).initModel();
        ((AetheriumBase) AETHERIUM_BLAZING_RAY).initModel();
        ((IModeledItem) AETHERIUM_AXE).initModel();
        ((IModeledItem) AETHERIUM_PICKAXE).initModel();
        ((IModeledItem) AETHERIUM_HAMMER).initModel();
    }
}
