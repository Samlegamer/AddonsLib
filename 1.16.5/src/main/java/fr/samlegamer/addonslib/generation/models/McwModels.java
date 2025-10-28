package fr.samlegamer.addonslib.generation.models;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Either;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

//@Mod.EventBusSubscriber
public class McwModels
{
    private McwModels() {}

    public static final String ITEM_MODEL_TEMPLATE = "item/generated";
    public static final String BLOCK_MODEL_TEMPLATE = "block/cube_all";
    public static final String BLOCK_ITEM_MODEL_TEMPLATE = "item/block/cube_all";

//    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        ResourceLocation modelLoc = new ResourceLocation("addonslib:block/my_block");
        ResourceLocation textureLoc = new ResourceLocation("addonslib", "block/my_block");
        RenderMaterial textureMaterial = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, textureLoc);

        Function<RenderMaterial, TextureAtlasSprite> textureGetter = (mat) -> {
            AtlasTexture atlas = Minecraft.getInstance().getModelManager().getAtlas(AtlasTexture.LOCATION_BLOCKS);
            return atlas.getSprite(textureMaterial.atlasLocation());
        };

        Either<RenderMaterial, String> material = Either.left(textureMaterial);

        BlockModel base = new BlockModel(
                new ResourceLocation("minecraft:block/cube_all"),
                Collections.emptyList(),
                ImmutableMap.of("all", material),
                false, BlockModel.GuiLight.FRONT, ItemCameraTransforms.NO_TRANSFORMS, new ArrayList<>()
        );

//        IUnbakedModel base = event.getModelLoader().getModelOrMissing(new ResourceLocation("minecraft:block/cube_all"));
        IBakedModel baked = base.bake(event.getModelLoader(), textureGetter,
                ModelRotation.X0_Y0, modelLoc);
        event.getModelRegistry().put(modelLoc, baked);

        ModelLoader.addSpecialModel(new ResourceLocation("addonslib:block/my_block"));

    }
}
