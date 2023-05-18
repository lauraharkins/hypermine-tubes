package laura.hyperminetubes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import laura.hyperminetubes.items.Welder;

public class ExampleMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("hypermine-tubes-mod");

    public static final Welder WELDER_ITEM = 
        Registry.register(Registries.ITEM, new Identifier("hyperminetubes", "welder"), 
            new Welder(new FabricItemSettings()));;

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("hyperminetubes", "stuff"))
            .icon(() -> new ItemStack(WELDER_ITEM))
            .build();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(WELDER_ITEM);
        });
    }
}