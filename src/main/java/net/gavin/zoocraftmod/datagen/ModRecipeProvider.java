package net.gavin.zoocraftmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gavin.zoocraftmod.block.ModBlocks;
import net.gavin.zoocraftmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FOSSIL_SMELTABLES = List.of(ModBlocks.FOSSIL_ORE);

        offerSmelting(exporter, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL,0.25f, 200, "fossil");
        offerBlasting(exporter, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL,0.25f, 100, "fossil");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_FENCE)
                .pattern("   ")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Ingredient.ofItems(Items.COPPER_INGOT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_FENCE_GATE)
                .pattern("   ")
                .pattern("RXR")
                .pattern("RXR")
                .input('R', Ingredient.ofItems(Items.COPPER_BLOCK))
                .input('X', Ingredient.ofItems(Items.COPPER_INGOT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlock.INSERTBLOCKHERE)
        .pattern("RRR")
        .pattern("RRR")
        .input('R', ModItems.INSERTITEMHERE)
        .criterion(hasItem(ModItems.INSERTITEMHERE), conditionFromItem(ModItems.INSERTITEMHERE))
        .offerTo(exporter);
        */

        /*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INSERTITEMHERE, count I,)
        .input(ModBlocks.INSERTBLOCKHERE)
        .criterion(hasItem(ModBlocks.INSERTBLOCKHERE, conditionsFromItem(ModBlocks.INSERTBLOCKHERE))
        .offerTo(exporter, Idnetifier.of(ZoocraftMod.MOD_ID, "Can insert custom json identifier here");
         */
    }
}
