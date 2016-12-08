package team.chisel;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import team.chisel.api.block.BlockCreator;
import team.chisel.api.block.BlockProvider;
import team.chisel.api.block.ChiselBlockFactory;
import team.chisel.api.block.ICarvable;
import team.chisel.api.block.VariationData;
import team.chisel.api.carving.CarvingUtils;
import team.chisel.common.block.*;
import team.chisel.common.carving.Carving;
import team.chisel.common.config.Configurations;
import team.chisel.common.init.ChiselBlocks;
import team.chisel.common.util.GenerationHandler;
import team.chisel.common.util.GenerationHandler.WorldGenInfo;

public enum Features {

    // @formatter:off
    ALUMINUM {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            
            factory.newBlock(Material.ROCK, "blockAluminum", provider)
                    .setParentFolder("metals/aluminum")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build();
            
            CarvingUtils.getChiselRegistry().registerOre("blockAluminum", "blockAluminum");
        }
    },

    ANDESITE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState stone = Blocks.STONE.getDefaultState();
            IProperty<BlockStone.EnumType> prop = BlockStone.VARIANT;
            Carving.chisel.addVariation("andesite", stone.withProperty(prop, BlockStone.EnumType.ANDESITE), -21);
            Carving.chisel.addVariation("andesite", stone.withProperty(prop, BlockStone.EnumType.ANDESITE_SMOOTH), -20);

            CarvingUtils.getChiselRegistry().registerOre("andesite", "stoneAndesite");
            //CarvingUtils.getChiselRegistry().registerOre("andesite", "stoneAndesitePolished");

            factory.newBlock(Material.ROCK, "andesite", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(30.0F).setSoundType(SoundType.STONE));
        }
    },

    ANTIBLOCK {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "antiblock", provider)
                    .newVariation("black")
                    .next("red")
                    .next("green")
                    .next("brown")
                    .next("blue")
                    .next("purple")
                    .next("cyan")
                    .next("silver")
                    .next("gray")
                    .next("pink")
                    .next("lime")
                    .next("yellow")
                    .next("light_blue")
                    .next("magenta")
                    .next("orange")
                    .next("white")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.antiblock, 8, 15), "SSS", "SGS", "SSS", 'S', "stone", 'G', "dustGlowstone"));
        }
    },

    BASALT {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "basalt", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "basaltextra", provider)
                    .setGroup("basalt")
                    .setParentFolder("basalt")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("raw").setOrder(-100)
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
            
            CarvingUtils.getChiselRegistry().registerOre("basalt", "stoneBasalt");
            //CarvingUtils.getChiselRegistry().registerOre("basalt", "stoneBasaltPolished");
        }

        @Override
        void addRecipes() {
            if (!Configurations.basaltSpecialGen) {
                GenerationHandler.INSTANCE.addGeneration(ChiselBlocks.basaltextra.getDefaultState().withProperty(ChiselBlocks.basaltextra.getMetaProp(), 7),
                        new WorldGenInfo(Configurations.basaltVeinAmount, 0, 32, 1, BlockMatcher.forBlock(Blocks.STONE)));
            }
        }
    },

    BLOOD_MAGIC {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "bloodMagic", new ChiselBlockProvider<>(BlockCarvableAltarComponent::new, BlockCarvableAltarComponent.class))
                    .newVariation("bloodRuneArranged")
                    .next("bloodRuneBricks")
                    .next("bloodRuneCarved")
                    .next("bloodRuneCarvedRadial")
                    .next("bloodRuneClassicPanel")
                    .next("bloodRuneTiles")
                    .build();
        }
    },

    BOOKSHELF {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            String[] woodTypes = new String[]{"Oak", "Spruce", "Birch", "Jungle", "Acacia", "DarkOak"};

            Carving.chisel.addVariation("bookshelf_oak", Blocks.BOOKSHELF.getDefaultState(), -1);

            for (String woodType : woodTypes) {
                factory.newBlock(Material.WOOD, "bookshelf_" + woodType.toLowerCase(), new ChiselBlockProvider<>(BlockCarvableBookshelf::new, BlockCarvableBookshelf.class))
                        .newVariation("rainbow")
                        .next("necromancer-novice")
                        .next("necromancer")
                        .next("redtomes")
                        .next("abandoned")
                        .next("hoarder")
                        .next("brim")
                        .next("historician")
                        .next("cans")
                        .next("papers")
                        .build(b -> b.setSoundType(SoundType.WOOD).setHardness(1.5f));

                CarvingUtils.getChiselRegistry().registerOre("bookshelf_" + woodType.toLowerCase(), "bookshelf" + woodType);
            }
        }

        @Override
        void addRecipes()
        {
            BlockCarvable[] bookshelves = new BlockCarvable[]{ChiselBlocks.bookshelf_spruce, ChiselBlocks.bookshelf_birch, ChiselBlocks.bookshelf_jungle, ChiselBlocks.bookshelf_acacia, ChiselBlocks.bookshelf_darkoak};
            Block[] stairs = new Block[]{Blocks.SPRUCE_STAIRS, Blocks.BIRCH_STAIRS, Blocks.JUNGLE_STAIRS, Blocks.ACACIA_STAIRS, Blocks.DARK_OAK_STAIRS};

            for (int c = 0; c < bookshelves.length; c++)
            {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bookshelves[c], 1), "S S", "BBB", "S S", 'S', new ItemStack(stairs[c], 1), 'B', new ItemStack(Items.BOOK, 1)));
            }
        }
    },

    BRICKS {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("bricks", Blocks.BRICK_BLOCK.getDefaultState(), -1);

            factory.newBlock(Material.ROCK, "bricks", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "bricksextra", provider)
                    .setGroup("bricks")
                    .setParentFolder("bricks")
                    .newVariation("bricks-solid")
                    //.next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    BRONZE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockBronze", provider)
                    .setParentFolder("metals/bronze")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(5.0F));
            
            CarvingUtils.getChiselRegistry().registerOre("blockBronze", "blockBronze");
        }
    },

    /*CERTUS { TODO Retexture
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "certus", provider)
                    .setParentFolder("quartz/certus")
                    .newVariation("certusChiseled")
                    .next("certusPrismatic")
                    .next("certusPrismaticPattern")
                    .next("masonryCertus")
                    .build();
        }
    }, // There is no AE yet */

    CARPET {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            IBlockState carpet = Blocks.CARPET.getDefaultState();
            IProperty<EnumDyeColor> prop = BlockCarpet.COLOR;

            for(int c = 0; c < dyeColors.length; c++)
            {
                // TODO Fix model; see Issue #239
                Carving.chisel.addVariation("carpet_" + (dyeColors[c].toLowerCase()), carpet.withProperty(prop, EnumDyeColor.byDyeDamage(c)), -1);

                //CarvingUtils.getChiselRegistry().registerOre("glassdyed" + (dyeColors[c].toLowerCase()), "blockGlass" + dyeColors[c]);

                factory.newBlock(Material.CARPET, "carpet_" + (dyeColors[c].toLowerCase()), new ChiselBlockProvider<>(BlockCarvableCarpet::new, BlockCarvableCarpet.class)).opaque(false)
                        .setParentFolder("wool")
                        .newVariation("legacy_"+(dyeColors[c].toLowerCase()))
                        .next("llama_"+(dyeColors[c].toLowerCase()))
                        .build(b -> b.setSoundType(SoundType.CLOTH).setHardness(0.8F));
            }
        }
    },

    CLOUD {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.CLOTH, "cloud", provider)
                    .newVariation("cloud")
                    .next("large")
                    .next("small")
                    .next("vertical")
                    .next("grid")
                    .build(b -> b.setSoundType(SoundType.CLOTH).setHardness(0.3F));
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.cloud, 32, 0), " S ", "S S", " S ", 'S', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE)));
        }
    },

    COBALT {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockCobalt", provider)
                    .setParentFolder("metals/cobalt")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b -> b.setSoundType(SoundType.METAL).setHardness(5.0F));
            
            CarvingUtils.getChiselRegistry().registerOre("blockCobalt", "blockCobalt");
        }
    },

    COBBLESTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("cobblestone", Blocks.COBBLESTONE.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("cobblestone", "cobblestone");

            factory.newBlock(Material.ROCK, "cobblestone", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "cobblestoneextra", provider)
                    .setGroup("cobblestone")
                    .setParentFolder("cobblestone")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("emboss")
                    .next("indent")
                    .next("marker")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    COBBLESTONEMOSSY {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("cobblestonemossy", Blocks.MOSSY_COBBLESTONE.getDefaultState(), -1);

            factory.newBlock(Material.ROCK, "cobblestonemossy", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    /*CONCRETE { TODO Retexture
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "concrete", provider)
                    .newVariation("default")
                    .next("block")
                    .next("doubleslab")
                    .next("blocks")
                    .next("weathered")
                    .next("weathered-block")
                    .next("weathered-doubleslab")
                    .next("weathered-blocks")
                    .next("weathered-half")
                    .next("weathered-block-half")
                    .next("asphalt")
                    .build();
        }
        @Override
        void addRecipes() {
            FurnaceRecipes.instance().addSmelting(new ItemStack(Blocks.GRAVEL).getItem(), new ItemStack(ChiselBlocks.concrete), 0.1F);
        }
    },*/

    COPPER {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockCopper", provider)
                    .setParentFolder("metals/copper")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b -> b.setSoundType(SoundType.METAL).setHardness(5.0F));
            
            CarvingUtils.getChiselRegistry().registerOre("blockCopper", "blockCopper");
        }
    },

    /*CRAG_ROCK { TODO Retexture
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "cragROCK", provider)
                    .newVariation("terrain-cob-detailedbrick")
                    .next("terrain-cob-french")
                    .next("terrain-cob-french2")
                    .next("terrain-cob-smallbrick")
                    .next("terrain-cobb-brickaligned")
                    .next("terrain-cobblargetiledark")
                    .next("terrain-cobbsmalltile")
                    .next("terrain-cobmoss-creepdungeon")
                    .next("terrain-mossysmalltiledark")
                    .next("terrain-pistonback-darkcreeper")
                    .next("terrain-pistonback-darkdent")
                    .next("terrain-pistonback-darkemboss")
                    .next("terrain-pistonback-darkmarker")
                    .next("terrain-pistonback-darkpanel")
                    .next("terrain-pistonback-dungeontile")
                    .build();
        }
    }, //  */

    DIAMOND {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("diamond", Blocks.DIAMOND_BLOCK.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("diamond", "blockDiamond");

            factory.newBlock(Material.IRON, "diamond", provider)
                    .newVariation("terrain-diamond-embossed")
                    .next("terrain-diamond-gem")
                    .next("terrain-diamond-cells")
                    .next("terrain-diamond-space")
                    .next("terrain-diamond-spaceblack")
                    .next("terrain-diamond-simple")
                    .next("terrain-diamond-bismuth")
                    .next("terrain-diamond-crushed")
                    .next("terrain-diamond-four")
                    .next("terrain-diamond-fourornate")
                    .next("terrain-diamond-zelda")
                    .next("terrain-diamond-ornatelayer")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(5.0F));
        }
    },

    DIORITE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState stone = Blocks.STONE.getDefaultState();
            IProperty<BlockStone.EnumType> prop = BlockStone.VARIANT;
            Carving.chisel.addVariation("diorite", stone.withProperty(prop, BlockStone.EnumType.DIORITE), -21);
            Carving.chisel.addVariation("diorite", stone.withProperty(prop, BlockStone.EnumType.DIORITE_SMOOTH), -20);

            CarvingUtils.getChiselRegistry().registerOre("diorite", "stoneDiorite");
            //CarvingUtils.getChiselRegistry().registerOre("diorite", "stoneDioritePolished");

            factory.newBlock(Material.ROCK, "diorite", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(30.0F).setSoundType(SoundType.STONE));
        }
    },

    DIRT {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("dirt", Blocks.DIRT.getDefaultState(), -1);
            factory.newBlock(Material.GROUND, "dirt", provider)
                    .newVariation("bricks")
                    .next("netherbricks")
                    .next("bricks3")
                    .next("cobble")
                    .next("reinforcedCobbleDirt")
                    .next("reinforcedDirt")
                    .next("happy")
                    .next("bricks2")
                    .next("bricks+dirt2")
                    .next("hor")
                    .next("vert")
                    .next("layers")
                    .next("vertical")
                    .next("chunky")
                    .next("horizontal")
                    .next("plate")
                    .build(b -> b.setSoundType(SoundType.GROUND).setHardness(0.5F));
        }
    },

    ELECTRUM {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockElectrum", provider)
                    .setParentFolder("metals/electrum")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b -> b.setSoundType(SoundType.METAL).setHardness(5.0F));
            
            CarvingUtils.getChiselRegistry().registerOre("blockElectrum", "blockElectrum");
        }
    },

    EMERALD {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("emerald", Blocks.EMERALD_BLOCK.getDefaultState(), -1);

            CarvingUtils.getChiselRegistry().registerOre("emerald", "blockEmerald");

            factory.newBlock(Material.IRON, "emerald", provider)
                    .newVariation("panel")
                    .next("panelclassic")
                    .next("smooth")
                    .next("chunk")
                    .next("goldborder")
                    .next("zelda")
                    .next("cell")
                    .next("cellbismuth")
                    .next("four")
                    .next("fourornate")
                    .next("ornate")
                    .next("masonryEmerald")
                    .next("emeraldCircle")
                    .next("emeraldPrismatic")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(5.0F));
        }
    },

    END_PURPUR {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState purpur_pillar = Blocks.PURPUR_PILLAR.getDefaultState();
            IProperty<Axis> prop = BlockRotatedPillar.AXIS;

            Carving.chisel.addVariation("purpur", Blocks.PURPUR_BLOCK.getDefaultState(), -5);
            //Carving.chisel.addVariation("purpur", purpur_pillar.withProperty(prop, Axis.X), -4);
            Carving.chisel.addVariation("purpur", purpur_pillar.withProperty(prop, Axis.Y), -3);
            //Carving.chisel.addVariation("purpur", purpur_pillar.withProperty(prop, Axis.Z), -2);
            //Carving.chisel.addVariation("purpur", Blocks.purpur_double_slab.getDefaultState(), -1);

            factory.newBlock(Material.ROCK, "purpur", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "purpurextra", provider)
                    .setGroup("purpur")
                    .setParentFolder("purpur")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    //.next("tiles-medium")
                    //.next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    /*ENDER_PEARL_BLOCK { TODO Retexture
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "ender_pearl_block", provider)
                    .newVariation("resonantSolid")
                    .next("enderZelda")
                    .next("enderEye")
                    .next("resonantBricks")
                    .build();
        }
        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.ender_pearl_block), "SS", "SS", 'S', new ItemStack(Items.ENDER_PEARL));
        }
    },*/

    ENDSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("endstone", Blocks.END_STONE.getDefaultState(), -21);
            Carving.chisel.addVariation("endstone", Blocks.END_BRICKS.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("endstone", "endstone");

            factory.newBlock(Material.ROCK, "endstone", provider)
                    .newVariation("cracked")
                    .next("bricks-solid")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(3.0F).setResistance(15.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "endstoneextra", provider)
                    .setGroup("endstone")
                    .setParentFolder("endstone")
                    .newVariation("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setHardness(3.0F).setResistance(15.0F).setSoundType(SoundType.STONE));
        }
    },

    FACTORY {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.IRON, "factory", provider)
                    .newVariation("dots")
                    .next("rust2")
                    .next("rust")
                    .next("platex")
                    .next("wireframewhite")
                    .next("wireframe")
                    .next("hazard")
                    .next("hazardorange")
                    .next("circuit")
                    .next("metalbox")
                    .next("goldplate")
                    .next("goldplating")
                    .next("grinder")
                    .next("plating")
                    .next("rustplates")
                    .next("column")
                    .next("frameblue")
                    .next("iceiceice")
                    .next("tilemosaic")
                    .next("vent")
                    .next("wireframeblue")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.factory, 32, 0), "SXS", "X X", "SXS",
                    'X', new ItemStack(Blocks.STONE, 1),
                    'S', new ItemStack(Items.IRON_INGOT, 1));
        }
    },

    FUTURA {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "futura", provider)
                    .newVariation("screenMetallic")
                    .next("screenCyan")
                    .next("controller")
                    .next("wavy")
                    .next("controllerPurple")
                    .next("uberWavy")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.futura, 8, 0), "SSS", "SGS", "SSS", 'S', "stone", 'G', "dustRedstone"));
        }
    },

    GLASS {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("glass", Blocks.GLASS.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("glass", "blockGlassColorless");

            factory.newBlock(Material.GLASS, "glass", provider).opaque(false)
                    .newVariation("terrain-glassbubble")
                    .next("terrain-glass-chinese")
                    .next("japanese")
                    .next("terrain-glassdungeon")
                    .next("terrain-glasslight")
                    .next("terrain-glassnoborder")
                    .next("terrain-glass-ornatesteel")
                    .next("terrain-glass-screen")
                    .next("terrain-glassshale")
                    .next("terrain-glass-steelframe")
                    .next("terrain-glassstone")
                    .next("terrain-glassstreak")
                    .next("terrain-glass-thickgrid")
                    .next("terrain-glass-thingrid")
                    .next("a1-glasswindow-ironfencemodern")
                    .next("chrono")
                    .build(b -> b.setQuantityDropped(0).setCanSilkHarvest(true).setSoundType(SoundType.GLASS).setHardness(0.3F));
        }
    },

    GLASSDYED {
        @SuppressWarnings("null")
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState stainedGlass = Blocks.STAINED_GLASS.getDefaultState();
            IProperty<EnumDyeColor> prop = BlockStainedGlass.COLOR;

            for(int c = 0; c < dyeColors.length; c++)
            {
                Carving.chisel.addVariation("glassdyed" + (dyeColors[c].toLowerCase()), stainedGlass.withProperty(prop, EnumDyeColor.byDyeDamage(c)), -1);

                CarvingUtils.getChiselRegistry().registerOre("glassdyed" + (dyeColors[c].toLowerCase()), "blockGlass" + dyeColors[c]);

                factory.newBlock(Material.GLASS, "glassdyed" + (dyeColors[c].toLowerCase()), provider).opaque(false)
                        .setParentFolder("glassdyed")
                        .newVariation((dyeColors[c].toLowerCase())+"-bubble")
                        .next((dyeColors[c].toLowerCase())+"-panel")
                        .next((dyeColors[c].toLowerCase())+"-panel-fancy")
                        .next((dyeColors[c].toLowerCase())+"-transparent")
                        .next((dyeColors[c].toLowerCase())+"-forestry")
                        .build(b -> b.setQuantityDropped(0).setCanSilkHarvest(true).setSoundType(SoundType.GLASS).setHardness(0.3F));
            }
        }
    },

    /*GLASSPANE { TODO Remodel
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            //Carving.chisel.addVariation("glasspane", Blocks.glass_pane.getDefaultState(), -1);
            factory.newBlock(Material.GLASS, "glasspane", new ChiselBlockProvider<BlockCarvablePane>(new BlockCreator<BlockCarvablePane>()
            {
                @Override
                public BlockCarvablePane createBlock(Material mat, int index, int maxVariation, VariationData... data) {
                    return new BlockCarvablePane(mat, false, index, maxVariation, data);
                }
            }, BlockCarvablePane.class))
                    .newVariation("chinese")
                    .next("chinese2")
                    .next("japanese")
                    .next("japanese2")
                    .next("terrain-glass-screen")
                    .next("terrain-glassbubble")
                    .next("terrain-glassnoborder")
                    .next("terrain-glassstreak")
                    .build(b -> b.setQuantityDropped(0).setCanSilkHarvest(true).setSoundType(SoundType.GLASS));
        }
    },
    GLASSPANEDYED { TODO Remodel
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            for(int c = 0; c < dyeColors.length; c++)
            {
                //Carving.chisel.addVariation("glasspanedyed"+dyeColors[c], stainedGlassPane.withProperty(prop, EnumDyeColor.byDyeDamage(c)), -1);
                factory.newBlock(Material.GLASS, "glasspanedyed"+dyeColors[c], provider)
                        .setParentFolder("glasspanedyed")
                        .newVariation(dyeColors[c]+"-bubble")
                        .next(dyeColors[c]+"-panel")
                        .next(dyeColors[c]+"-panel-fancy")
                        .next(dyeColors[c]+"-transparent")
                        .next(dyeColors[c]+"-quad")
                        .next(dyeColors[c]+"-quad-fancy")
                        .build(b -> b.setQuantityDropped(0).setCanSilkHarvest(true).setSoundType(SoundType.GLASS));
            }
        }
    },*/

    GLOWSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("glowstone", Blocks.GLOWSTONE.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("glowstone", "glowstone");

            factory.newBlock(Material.ROCK, "glowstone", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bismuth")
                    .next("tiles-large-bismuth")
                    .next("tiles-medium-bismuth")
                    .next("neon")
                    .next("neon-panel")
                    .build(b ->b/*.setDrop(Items.GLOWSTONE_DUST).setQuantityDropped(2).setQuantityBonusDropped(2)*/.setLightLevel(1.0f).setHardness(0.3f).setResistance(1.5f).setSoundType(SoundType.GLASS));
        } //TODO Why isn't this dropping glowstone with meta 0 always? Drops glowstone with meta of block
    },

    GOLD {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("blockGold", Blocks.GOLD_BLOCK.getDefaultState(), -1);

            CarvingUtils.getChiselRegistry().registerOre("blockGold", "blockGold");

            factory.newBlock(Material.IRON, "blockGold", provider)
                    .setParentFolder("metals/gold")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(3.0F));

            factory.newBlock(Material.IRON, "gold", provider)
                    .setGroup("blockGold")
                    .newVariation("terrain-gold-largeingot")
                    .next("terrain-gold-smallingot")
                    .next("terrain-gold-brick")
                    .next("terrain-gold-cart")
                    .next("terrain-gold-coin-heads")
                    .next("terrain-gold-coin-tails")
                    .next("terrain-gold-crate-dark")
                    .next("terrain-gold-crate-light")
                    .next("terrain-gold-plates")
                    .next("terrain-gold-rivets")
                    .next("terrain-gold-star")
                    .next("terrain-gold-space")
                    .next("terrain-gold-spaceblack")
                    .next("terrain-gold-simple")
                    .next("goldEye")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(3.0F));
        }
    },

    GRANITE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState stone = Blocks.STONE.getDefaultState();
            IProperty<BlockStone.EnumType> prop = BlockStone.VARIANT;
            Carving.chisel.addVariation("granite", stone.withProperty(prop, BlockStone.EnumType.GRANITE), -21);
            Carving.chisel.addVariation("granite", stone.withProperty(prop, BlockStone.EnumType.GRANITE_SMOOTH), -20);

            CarvingUtils.getChiselRegistry().registerOre("granite", "stoneGranite");
            //CarvingUtils.getChiselRegistry().registerOre("granite", "stoneGranitePolished");

            factory.newBlock(Material.ROCK, "granite", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(30.0F).setSoundType(SoundType.STONE));
        }
    },

    HARDENED_CLAY {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("hardenedclay", Blocks.HARDENED_CLAY.getDefaultState(), -1);

            CarvingUtils.getChiselRegistry().registerOre("hardenedclay", "hardenedClay");

            factory.newBlock(Material.ROCK, "hardenedclay", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b-> b.setHardness(1.25F).setResistance(7.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "hardenedclayextra", provider)
                    .setGroup("hardenedclay")
                    .setParentFolder("hardenedclay")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setHardness(1.25F).setResistance(7.0F).setSoundType(SoundType.STONE));
        }
    },

    /*HEX_PLATING {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "hexPlating", provider)
                    .newVariation("hexBase") //TODO: Colored+Glowy stuff
                    .next("hexNew")
                    .build();
        }
    },*/

    ICE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("ice", Blocks.ICE.getDefaultState(), -1);
            /*factory.newBlock(Material.ICE, "ice", provider) TODO Retexture
                    .newVariation("a1-ice-light")
                    .next("a1-stonecobble-icecobble")
                    .next("a1-netherbrick-ice")
                    .next("a1-stonecobble-icebrick")
                    .next("a1-stonecobble-icebricksmall")
                    .next("a1-stonecobble-icedungeon")
                    .next("a1-stonecobble-icefour")
                    .next("a1-stonecobble-icefrench")
                    .next("sunkentiles")
                    .next("tiles")
                    .next("a1-stonecobble-icepanel")
                    .next("a1-stoneslab-ice")
                    .next("zelda")
                    .next("bismuth")
                    .next("poison")
                    .next("scribbles")
                    .build();*/
        }
    },

    ICEPILLAR {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ICE, "icepillar", provider)
                    .setGroup("ice")
                    .newVariation("plainplain")
                    .next("plaingreek")
                    .next("greekplain")
                    .next("greekgreek")
                    .next("convexplain")
                    .next("carved")
                    .next("ornamental")
                    .build(b-> b.setSoundType(SoundType.GLASS).setHardness(0.5f));
        }
    },

    INVAR {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.IRON, "blockInvar", provider)
                    .setParentFolder("metals/invar")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
        }
    },

    IRON {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("blockIron", Blocks.IRON_BLOCK.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("blockIron", "blockIron");

            factory.newBlock(Material.IRON, "blockIron", provider)
                    .setParentFolder("metals/iron")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));

            factory.newBlock(Material.IRON, "iron", provider)
                    .setGroup("blockIron")
                    .newVariation("terrain-iron-largeingot")
                    .next("terrain-iron-smallingot")
                    .next("terrain-iron-gears")
                    .next("terrain-iron-brick")
                    .next("terrain-iron-plates")
                    .next("terrain-iron-rivets")
                    .next("terrain-iron-coin-heads")
                    .next("terrain-iron-coin-tails")
                    .next("terrain-iron-crate-dark")
                    .next("terrain-iron-crate-light")
                    .next("terrain-iron-moon")
                    .next("terrain-iron-space")
                    .next("terrain-iron-spaceblack")
                    .next("terrain-iron-vents")
                    .next("terrain-iron-simple")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
        }
    },

    IRONPANE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            //Carving.chisel.addVariation("ironpane", Blocks.IRON_BARS.getDefaultState(), -1); TODO fix model
            factory.newBlock(Material.IRON, "ironpane", provider)
                    .newVariation("fenceIron")
                    .next("barbedwire")
                    .next("cage")
                    .next("fenceIronTop")
                    .next("terrain-glass-thickgrid")
                    .next("terrain-glass-thingrid")
                    .next("terrain-glass-ornatesteel")
                    .next("bars")
                    .next("spikes")
                    .next("a1-ironbars-ironclassicnew")
                    .next("a1-ironbars-ironfence")
                    .next("a1-ironbars-ironfencemodern")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
        }
    },

    LABORATORY {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "laboratory", provider)
                    .newVariation("wallpanel")
                    .next("dottedpanel")
                    .next("largewall")
                    .next("roundel")
                    .next("wallvents")
                    .next("largetile")
                    .next("smalltile")
                    .next("floortile")
                    .next("checkertile")
                    .next("clearscreen")
                    .next("fuzzscreen")
                    .next("largesteel")
                    .next("smallsteel")
                    .next("directionright")
                    .next("directionleft")
                    .next("infocon")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.laboratory, 8), "***", "*X*", "***", '*', new ItemStack(Blocks.STONE, 1), 'X', new ItemStack(Items.QUARTZ, 1));
        }
    },

    LAPIS {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("lapis", Blocks.LAPIS_BLOCK.getDefaultState(), -1);

            CarvingUtils.getChiselRegistry().registerOre("lapis", "blockLapis");

            factory.newBlock(Material.ROCK, "lapis", provider)
                    .newVariation("terrain-lapisblock-chunky")
                    .next("terrain-lapisblock-panel")
                    .next("terrain-lapisblock-zelda")
                    .next("terrain-lapisornate")
                    .next("terrain-lapistile")
                    .next("a1-blocklapis-panel")
                    .next("a1-blocklapis-smooth")
                    .next("a1-blocklapis-ornatelayer")
                    .next("masonryLapis")
                    .build(b-> b.setHardness(3.0F).setResistance(5.0F).setSoundType(SoundType.STONE));
        }
    },

    LAVASTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "lavastone", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(4.0F).setResistance(50.0F).setSoundType(SoundType.STONE));
        }
        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.lavastone, 8, 0), "***", "*X*", "***", '*', new ItemStack(Blocks.STONE, 1), 'X', new ItemStack(Items.LAVA_BUCKET, 1));
        }
    },

    LEAD {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockLead", provider)
                    .setParentFolder("metals/lead")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
            
            CarvingUtils.getChiselRegistry().registerOre("blockLead", "blockLead");
        }
    },

    /*LEAVES { TODO Potential omission candidate
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "leaves", provider)
                    .newVariation("christmasBalls")
                    .next("christmasBalls_opaque")
                    .next("christmasLights")
                    .next("christmasLights_opaque")
                    .next("dead")
                    .next("dead_opaque")
                    .next("fancy")
                    .next("fancy_opaque")
                    .next("pinkpetal")
                    .next("pinkpetal_opaque")
                    .next("red_roses")
                    .next("red_roses_opaque")
                    .next("roses")
                    .next("roses_opaque")
                    .build();
        }
    },*/

    LIMESTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "limestone", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "limestoneextra", provider)
                    .setGroup("limestone")
                    .setParentFolder("limestone")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("raw").setOrder(-100)
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
            
            CarvingUtils.getChiselRegistry().registerOre("limestone", "stoneLimestone");
            //CarvingUtils.getChiselRegistry().registerOre("limestone", "stoneLimestonePolished");

        }

        @Override
        void addRecipes() {
            GenerationHandler.INSTANCE.addGeneration(ChiselBlocks.limestoneextra.getDefaultState().withProperty(ChiselBlocks.limestoneextra.getMetaProp(), 7),
                    new WorldGenInfo(Configurations.limestoneAmount, 32, 64, 1, BlockMatcher.forBlock(Blocks.STONE)));
        }
    },

    MARBLE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "marble", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "marbleextra", provider)
                    .setGroup("marble")
                    .setParentFolder("marble")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism").setOrder(-100)
                    .next("raw")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
            

            CarvingUtils.getChiselRegistry().registerOre("marble", "stoneMarble");
            //CarvingUtils.getChiselRegistry().registerOre("marble", "stoneMarblePolished");
        }

        @Override
        void addRecipes() {
            GenerationHandler.INSTANCE.addGeneration(ChiselBlocks.marbleextra.getDefaultState().withProperty(ChiselBlocks.marbleextra.getMetaProp(), 7),
                    new WorldGenInfo(Configurations.marbleAmount, 32, 64, 1, BlockMatcher.forBlock(Blocks.STONE)));
        }
    },

    MARBLEPILLAR {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            if (Configurations.oldPillars) {
                factory.newBlock(Material.ROCK, "marblepillarold", provider)
                        .setGroup("marble")
                        .newVariation("column")
                        .next("capstone")
                        .next("base")
                        .next("small")
                        .next("pillar-carved")
                        .next("a1-stoneornamental-marblegreek")
                        .next("a1-stonepillar-greek")
                        .next("a1-stonepillar-plain")
                        .next("a1-stonepillar-greektopplain")
                        .next("a1-stonepillar-plaintopplain")
                        .next("a1-stonepillar-greekbottomplain")
                        .next("a1-stonepillar-plainbottomplain")
                        .next("a1-stonepillar-greektopgreek")
                        .next("a1-stonepillar-plaintopgreek")
                        .next("a1-stonepillar-greekbottomgreek")
                        .next("a1-stonepillar-plainbottomgreek")
                        .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
            } else {
                factory.newBlock(Material.ROCK, "marblepillar", provider)
                        .setGroup("marble")
                        .newVariation("pillar")
                        .next("default")
                        .next("simple")
                        .next("convex")
                        .next("rough")
                        .next("greekdecor")
                        .next("greekgreek")
                        .next("greekplain")
                        .next("plaindecor")
                        .next("plaingreek")
                        .next("plainplain")
                        .next("widedecor")
                        .next("widegreek")
                        .next("wideplain")
                        .next("carved")
                        .next("ornamental")
                        .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
            }
        }
    },

    NETHERBRICK {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("netherbrick", Blocks.NETHER_BRICK.getDefaultState(), -1);
            factory.newBlock(Material.ROCK, "netherbrick", provider)
                    .newVariation("a1-netherbrick-brinstar")
                    .next("a1-netherbrick-classicspatter")
                    .next("a1-netherbrick-guts")
                    .next("a1-netherbrick-gutsdark")
                    .next("a1-netherbrick-gutssmall")
                    .next("a1-netherbrick-lavabrinstar")
                    .next("a1-netherbrick-lavabrown")
                    .next("a1-netherbrick-lavaobsidian")
                    .next("a1-netherbrick-lavastonedark")
                    .next("a1-netherbrick-meat")
                    .next("a1-netherbrick-meatred")
                    .next("a1-netherbrick-meatredsmall")
                    .next("a1-netherbrick-meatsmall")
                    .next("a1-netherbrick-red")
                    .next("a1-netherbrick-redsmall")
                    .next("netherFancyBricks")
                    .build(b -> b.setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    NETHERRACK {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("netherrack", Blocks.NETHERRACK.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("netherrack", "netherrack");

            factory.newBlock(Material.ROCK, "netherrack", provider)
                    .newVariation("a1-netherrack-bloodgravel")
                    .next("a1-netherrack-bloodrock")
                    .next("a1-netherrack-bloodrockgrey")
                    .next("a1-netherrack-brinstar")
                    .next("a1-netherrack-brinstarshale")
                    .next("a1-netherrack-classic")
                    .next("a1-netherrack-classicspatter")
                    .next("a1-netherrack-guts")
                    .next("a1-netherrack-gutsdark")
                    .next("a1-netherrack-meat")
                    .next("a1-netherrack-meatred")
                    .next("a1-netherrack-meatrock")
                    .next("a1-netherrack-red")
                    .next("a1-netherrack-wells")
                    .build(b -> b.setHardness(0.4F).setSoundType(SoundType.STONE));
        }
    },

    NICKEL {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "blockNickel", provider)
                    .setParentFolder("metals/nickel")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
            
            CarvingUtils.getChiselRegistry().registerOre("blockNickel", "blockNickel");
        }
    },

    OBSIDIAN {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("obsidian", Blocks.OBSIDIAN.getDefaultState(), -1);

            CarvingUtils.getChiselRegistry().registerOre("obsidian", "obsidian");

            factory.newBlock(Material.ROCK, "obsidian", provider)
                    .newVariation("pillar")
                    .next("pillar-quartz")
                    .next("chiseled")
                    .next("panel-shiny")
                    .next("panel")
                    .next("chunks")
                    .next("growth")
                    .next("crystal")
                    .next("map-a")
                    .next("map-b")
                    .next("panel-light")
                    .next("blocks")
                    .next("tiles")
                    .next("greek")
                    .next("crate")
                    .build(b -> b.setHardness(50.0F).setResistance(2000.0F).setSoundType(SoundType.STONE));
        }
    },

    PAPER {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.PLANTS, "paper", provider)
                    .newVariation("box")
                    .next("throughMiddle")
                    .next("cross")
                    .next("sixSections")
                    .next("vertical")
                    .next("horizontal")
                    .next("floral")
                    .next("plain")
                    .next("door")
                    .build(b -> b.setSoundType(SoundType.PLANT)
                            .setHardness(1.5f));
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.paper, 32), "ppp", "psp", "ppp", 'p', Items.PAPER, 's', "stickWood"));
        }
    },

    PLANKS {
        @SuppressWarnings("null")
        @Override
        void addBlocks(ChiselBlockFactory factory)
        {
            IBlockState planks = Blocks.PLANKS.getDefaultState();
            IProperty<BlockPlanks.EnumType> prop = BlockPlanks.VARIANT;

            for (int c = 0; c < plank_names.length; c++)
            {
                Carving.chisel.addVariation("planks-" + plank_names[c], planks.withProperty(prop, BlockPlanks.EnumType.byMetadata(c)), -1);

                factory.newBlock(Material.WOOD, "planks-" + plank_names[c], provider)
                        .newVariation("clean")
                        .next("short")
                        .next("fancy")
                        .next("panel-nails")
                        .next("double")
                        .next("crate")
                        .next("crate-fancy")
                        .next("large")
                        .next("vertical")
                        .next("vertical-uneven")
                        .next("parquet")
                        .next("blinds")
                        .next("crateex")
                        .next("chaotic-hor")
                        .next("chaotic")
                        .build(b -> b.setHardness(2.0F).setResistance(5.0F).setSoundType(SoundType.WOOD));

            }
        }
    },

    PLATINUM {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.IRON, "blockPlatinum", provider)
                    .setParentFolder("metals/platinum")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build(b-> b.setSoundType(SoundType.METAL).setHardness(5.0f));
            
            CarvingUtils.getChiselRegistry().registerOre("blockPlatinum", "blockPlatinum");
        }
    },

    PRISMARINE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            IBlockState prismarine = Blocks.PRISMARINE.getDefaultState();
            IProperty<BlockPrismarine.EnumType> prop = BlockPrismarine.VARIANT;
            Carving.chisel.addVariation("prismarine", prismarine.withProperty(prop, BlockPrismarine.EnumType.ROUGH), -3);
            Carving.chisel.addVariation("prismarine", prismarine.withProperty(prop, BlockPrismarine.EnumType.BRICKS), -2);
            Carving.chisel.addVariation("prismarine", prismarine.withProperty(prop, BlockPrismarine.EnumType.DARK), -1);

            CarvingUtils.getChiselRegistry().registerOre("prismarine", "prismarine");

            factory.newBlock(Material.ROCK, "prismarine", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "prismarineextra", provider)
                    .setGroup("prismarine")
                    .setParentFolder("prismarine")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    QUARTZ {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState quartzBlock = Blocks.QUARTZ_BLOCK.getDefaultState();
            IProperty<BlockQuartz.EnumType> prop = BlockQuartz.VARIANT;
            Carving.chisel.addVariation("quartz", quartzBlock.withProperty(prop, BlockQuartz.EnumType.DEFAULT), -25);
            Carving.chisel.addVariation("quartz", quartzBlock.withProperty(prop, BlockQuartz.EnumType.CHISELED), -24);
            //Carving.chisel.addVariation("quartz", quartzBlock.withProperty(prop, BlockQuartz.EnumType.LINES_X), -23);
            Carving.chisel.addVariation("quartz", quartzBlock.withProperty(prop, BlockQuartz.EnumType.LINES_Y), -22);
            //Carving.chisel.addVariation("quartz", quartzBlock.withProperty(prop, BlockQuartz.EnumType.LINES_Z), -21);

            CarvingUtils.getChiselRegistry().registerOre("quartz", "blockQuartz");

            factory.newBlock(Material.ROCK, "quartz", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    //.next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(0.8F).setResistance(4.0F).setSoundType(SoundType.STONE));
        }
    },

    REDSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            Carving.chisel.addVariation("redstone", Blocks.REDSTONE_BLOCK.getDefaultState(), -20);

            CarvingUtils.getChiselRegistry().registerOre("redstone", "blockRedstone");

            factory.newBlock(Material.ROCK, "redstone", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b->b.setRedstoneLevel(15).setHardness(5.0F).setResistance(10.0F).setSoundType(SoundType.METAL));
        }
    },

    SANDSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState ss = Blocks.SANDSTONE.getDefaultState();
            IProperty<BlockSandStone.EnumType> prop = BlockSandStone.TYPE;
            Carving.chisel.addVariation("sandstoneyellow", ss.withProperty(prop, BlockSandStone.EnumType.DEFAULT), -3);
            Carving.chisel.addVariation("sandstoneyellow", ss.withProperty(prop, BlockSandStone.EnumType.SMOOTH), -2);
            Carving.chisel.addVariation("sandstoneyellow", ss.withProperty(prop, BlockSandStone.EnumType.CHISELED), -1);

            factory.newBlock(Material.ROCK, "sandstoneyellow", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(0.8F));

            factory.newBlock(Material.ROCK, "sandstoneyellowextra", provider)
                    .setGroup("sandstoneyellow")
                    .setParentFolder("sandstoneyellow")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(0.8F));
        }
    },

    SANDSTONE_RED {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            IBlockState ss = Blocks.RED_SANDSTONE.getDefaultState();
            IProperty<BlockRedSandstone.EnumType> prop = BlockRedSandstone.TYPE;

            Carving.chisel.addVariation("sandstonered", ss.withProperty(prop, BlockRedSandstone.EnumType.DEFAULT), -3);
            Carving.chisel.addVariation("sandstonered", ss.withProperty(prop, BlockRedSandstone.EnumType.SMOOTH), -2);
            Carving.chisel.addVariation("sandstonered", ss.withProperty(prop, BlockRedSandstone.EnumType.CHISELED), -1);

            factory.newBlock(Material.ROCK, "sandstonered", provider)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(0.8F));

            factory.newBlock(Material.ROCK, "sandstoneredextra", provider)
                    .setGroup("sandstonered")
                    .setParentFolder("sandstonered")
                    .newVariation("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(0.8F));
        }
    },

    SANDSTONE_SCRIBBLES {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "sandstone-scribbles", provider)
                    .setGroup("sandstoneyellow")
                    .newVariation("scribbles-0")
                    .next("scribbles-1")
                    .next("scribbles-2")
                    .next("scribbles-3")
                    .next("scribbles-4")
                    .next("scribbles-5")
                    .next("scribbles-6")
                    .next("scribbles-7")
                    .next("scribbles-8")
                    .next("scribbles-9")
                    .next("scribbles-10")
                    .next("scribbles-11")
                    .next("scribbles-12")
                    .next("scribbles-13")
                    .next("scribbles-14")
                    .next("scribbles-15")
                    .build(b -> b.setSoundType(SoundType.STONE).setHardness(0.8F));
        }
    },

    SILVER {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "blockSilver", provider)
                    .setParentFolder("metals/silver")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build();
            
            CarvingUtils.getChiselRegistry().registerOre("blockSilver", "blockSilver");
        }
    },

    STEEL {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "blockSteel", provider)
                    .setParentFolder("metals/steel")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build();

            CarvingUtils.getChiselRegistry().registerOre("blockSteel", "blockSteel");
        }
    },

    STONEBRICK {
        @Override
        void addBlocks(ChiselBlockFactory factory)
        {
            IBlockState stoneBricks = Blocks.STONEBRICK.getDefaultState();
            IProperty<BlockStoneBrick.EnumType> prop = BlockStoneBrick.VARIANT;
            Carving.chisel.addVariation("stonebrick", stoneBricks.withProperty(prop, BlockStoneBrick.EnumType.DEFAULT), -26);
            Carving.chisel.addVariation("stonebrick", stoneBricks.withProperty(prop, BlockStoneBrick.EnumType.MOSSY), -25);
            Carving.chisel.addVariation("stonebrick", stoneBricks.withProperty(prop, BlockStoneBrick.EnumType.CRACKED), -24);
            Carving.chisel.addVariation("stonebrick", stoneBricks.withProperty(prop, BlockStoneBrick.EnumType.CHISELED), -23);

            Carving.chisel.addVariation("stonebrick", Blocks.STONE.getDefaultState(), -22);
            // Carving.chisel.addVariation("stonebrick", Blocks.double_stone_slab.getDefaultState().withProperty(BlockDoubleStoneSlab.VARIANT, BlockDoubleStoneSlab.EnumType.STONE), -21);

            CarvingUtils.getChiselRegistry().registerOre("stonebrick", "stone");

            factory.newBlock(Material.ROCK, "stonebrick", provider)
                    .setParentFolder("stone")
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "stonebrickextra", provider)
                    .setGroup("stonebrick")
                    .setParentFolder("stone")
                    .newVariation("bricks-small")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("largeornate")
                    .next("poison")
                    .next("sunken")
                    .next("mason-plain")
                    .next("mason-felsic")
                    .next("mason-mafic")
                    .next("mason-mixed")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }
    },

    TECHNICAL {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.IRON, "technical", provider)
                    .setGroup("factory")
                    .newVariation("scaffold").opaque(false)
                    .next("cautiontape")
                    .next("industrialrelic")
                    .next("pipesLarge")
                    .next("fanFast")
                    .next("pipesSmall")
                    .next("fanStill")
                    .next("vent")
                    .next("ventGlowing")
                    .next("insulationv2")
                    .next("spinningStuffAnim")
                    .next("cables")
                    .next("rustyBoltedPlates")
                    .next("grate")
                    .next("malfunctionFan")
                    .next("grateRusty")
                    .next("scaffoldTransparent").opaque(false)
                    .next("fanFastTransparent").opaque(false)
                    .next("fanStillTransparent").opaque(false)
                    .next("massiveFan")
                    .next("massiveHexPlating")
                    .build();

            factory.newBlock(Material.IRON, "technicalNew", provider)
                    .setGroup("factory")
                    .setParentFolder("technical/new")
                    .newVariation("weatheredGreenPanels")
                    .next("weatheredOrangePanels")
                    .next("Sturdy")
                    .next("MegaCell")
                    .next("ExhaustPlating")
                    .next("MakeshiftPanels")
                    .next("engineering")
                    .next("scaffoldLarge")
                    .next("Piping")
                    //TODO Retexture .next("TapeDrive")
                    .build();
        }
    },

    TEMPLE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "temple", provider)
                    .newVariation("cobble")
                    .next("ornate")
                    .next("plate")
                    .next("plate-cracked")
                    .next("bricks")
                    .next("bricks-large")
                    .next("bricks-weared")
                    .next("bricks-disarray")
                    .next("column")
                    .next("stand")
                    .next("tiles")
                    .next("smalltiles")
                    .next("tiles-light")
                    .next("smalltiles-light")
                    .next("stand-creeper")
                    .next("stand-mosaic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));

            factory.newBlock(Material.ROCK, "templemossy", provider)
                    .setGroup("temple")
                    .newVariation("cobble")
                    .next("ornate")
                    .next("plate")
                    .next("plate-cracked")
                    .next("bricks")
                    .next("bricks-large")
                    .next("bricks-weared")
                    .next("bricks-disarray")
                    .next("column")
                    .next("stand")
                    .next("tiles")
                    .next("smalltiles")
                    .next("tiles-light")
                    .next("smalltiles-light")
                    .next("stand-creeper")
                    .next("stand-mosaic")
                    .build(b -> b.setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE));
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.temple, 8), "***", "*X*", "***",
                    '*', new ItemStack(Blocks.STONE, 1),
                    'X', new ItemStack(Items.DYE, 1, 6)));
        }
    },

    TIN {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "blockTin", provider)
                    .setParentFolder("metals/tin")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build();
            
            CarvingUtils.getChiselRegistry().registerOre("blockTin", "blockTin");
        }
    },

    TYRIAN {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.IRON, "tyrian", provider)
                    .newVariation("shining")
                    .next("tyrian")
                    .next("chaotic")
                    .next("softplate")
                    .next("rust")
                    .next("elaborate")
                    .next("routes")
                    .next("platform")
                    .next("platetiles")
                    .next("diagonal")
                    .next("dent")
                    .next("blueplating")
                    .next("black")
                    .next("black2")
                    .next("opening")
                    .next("plate")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.tyrian, 32, 0), "SXS", "X X", "SXS",
                    'S', new ItemStack(Blocks.STONE, 1),
                    'X', new ItemStack(Items.IRON_INGOT, 1));
        }
    },

    URANIUM {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            factory.newBlock(Material.ROCK, "blockUranium", provider)
                    .setParentFolder("metals/uranium")
                    .newVariation("caution")
                    .next("crate")
                    .next("thermal")
                    .next("machine")
                    .next("badGreggy")
                    .next("bolted")
                    .next("scaffold")
                    .build();
            
            CarvingUtils.getChiselRegistry().registerOre("blockUranium", "blockUranium");
        }
    },

    VALENTINES {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "valentines", provider)
                    .newVariation("1")
                    .next("2")
                    .next("3")
                    .next("4")
                    .next("5")
                    .next("6")
                    .next("7")
                    .next("8")
                    .next("9")
                    .next("companion")
                    .build(b -> b.setHardness(1.5F).setResistance(20.0F).setSoundType(SoundType.STONE));
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.valentines, 4), "***", "*X*", "***",
                    '*', "stone",
                    'X', new ItemStack(Items.DYE, 1, 9)));

            // Companion Cube, woo!
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ChiselBlocks.valentines, 32, 9), "***", "*X*", "***",
                    '*', "stone",
                    'X', new ItemStack(Items.SKULL, 1, OreDictionary.WILDCARD_VALUE)));
        }
    },

    VOIDSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "voidstone", provider)
                    .newVariation("raw")
                    .next("quarters")
                    .next("smooth")
                    .next("skulls")
                    .next("rune")
                    .next("metalborder")
                    .next("eye")
                    .next("bevel")
                    .build();

            factory.newBlock(Material.ROCK, "energizedVoidstone", provider)
                    .setGroup("voidstone")
                    .setParentFolder("voidstone/animated")
                    .newVariation("raw")
                    .next("quarters")
                    .next("smooth")
                    .next("skulls")
                    .next("rune")
                    .next("metalborder")
                    .next("eye")
                    .next("bevel")
                    .build();

            factory.newBlock(Material.ROCK, "voidstoneRunic", provider)
                    .setParentFolder("voidstone/runes")
                    .setGroup("voidstone")
                    .newVariation("black")
                    .next("red")
                    .next("green")
                    .next("brown")
                    .next("blue")
                    .next("purple")
                    .next("cyan")
                    .next("lightgray")
                    .next("gray")
                    .next("pink")
                    .next("lime")
                    .next("yellow")
                    .next("lightblue")
                    .next("magenta")
                    .next("orange")
                    //.next("white")
                    .build();
        }

        @Override
        void addRecipes()
        {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.voidstone, 16, 0), " E ", "OOO", " E ",
                    'E', new ItemStack(Items.ENDER_EYE),
                    'O', new ItemStack(Blocks.OBSIDIAN));

            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.voidstone, 48, 0), " P ", "PEP", " P ",
                    'E', new ItemStack(Items.ENDER_PEARL),
                    'P', new ItemStack(Blocks.PURPUR_BLOCK));
        }
    },

    WATERSTONE {
        @Override
        void addBlocks(ChiselBlockFactory factory) {
            factory.newBlock(Material.ROCK, "waterstone", provider).opaque(false)
                    .newVariation("cracked")
                    .next("bricks-soft")
                    .next("bricks-cracked")
                    .next("bricks-triple")
                    .next("bricks-encased")
                    .next("braid")
                    .next("array")
                    .next("tiles-large")
                    .next("tiles-small")
                    .next("chaotic-medium")
                    .next("chaotic-small")
                    .next("dent")
                    .next("french-1")
                    .next("french-2")
                    .next("jellybean")
                    .next("layers")
                    .next("mosaic")
                    .next("ornate")
                    .next("panel")
                    .next("road")
                    .next("slanted")
                    .next("zag")
                    .next("circularct")
                    .next("weaver")
                    .next("bricks-solid")
                    .next("bricks-small")
                    .next("circular")
                    .next("tiles-medium")
                    .next("pillar")
                    .next("twisted")
                    .next("prism")
                    .next("bricks-chaotic")
                    .build(b -> b.setHardness(4.0F).setResistance(50.0F).setSoundType(SoundType.STONE));
        }

        @Override
        void addRecipes() {
            GameRegistry.addRecipe(new ItemStack(ChiselBlocks.waterstone, 8, 0), "***", "*X*", "***",
                    '*', new ItemStack(Blocks.STONE, 1),
                    'X', new ItemStack(Items.WATER_BUCKET, 1));
        }
    },

    WOOL {
        @Override
        void addBlocks(ChiselBlockFactory factory) {

            IBlockState wool = Blocks.WOOL.getDefaultState();
            IProperty<EnumDyeColor> prop = BlockColored.COLOR;

            for(int c = 0; c < dyeColors.length; c++)
            {
                Carving.chisel.addVariation("wool_" + (dyeColors[c].toLowerCase()), wool.withProperty(prop, EnumDyeColor.byDyeDamage(c)), -1);

                //CarvingUtils.getChiselRegistry().registerOre("glassdyed" + (dyeColors[c].toLowerCase()), "blockGlass" + dyeColors[c]);

                factory.newBlock(Material.CLOTH, "wool_" + (dyeColors[c].toLowerCase()), provider)
                        .setParentFolder("wool")
                        .newVariation("legacy_"+(dyeColors[c].toLowerCase()))
                        .next("llama_"+(dyeColors[c].toLowerCase()))
                        .build(b -> b.setSoundType(SoundType.CLOTH).setHardness(0.8F));
            }
        }
    };

    private static final String[] dyeColors =
            {
                    "Black",
                    "Red",
                    "Green",
                    "Brown",
                    "Blue",
                    "Purple",
                    "Cyan",
                    "LightGray",
                    "Gray",
                    "Pink",
                    "Lime",
                    "Yellow",
                    "LightBlue",
                    "Magenta",
                    "Orange",
                    "White"
            };

    //@formatter:on

    private static final String[] dyeOres = { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow",
            "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite" };

    public static final String[] plank_names = { "oak", "spruce", "birch", "jungle", "acacia", "dark-oak" };

    private static final @Nonnull BlockCreator<BlockCarvable> creator = BlockCarvable::new;
    private static final @Nonnull ChiselBlockProvider<BlockCarvable> provider = new ChiselBlockProvider<>(creator, BlockCarvable.class);

    @RequiredArgsConstructor
    @ParametersAreNonnullByDefault
    private static class ChiselBlockProvider<T extends Block & ICarvable> implements BlockProvider<T> {

        private final BlockCreator<T> creator;
        @Getter(onMethod = @__(@Override))
        private final Class<T> blockClass;

        @Override public T createBlock(Material mat, int index, int maxVariation, VariationData... data) {
            return creator.createBlock(mat, index, maxVariation, data);
        }

        @Override
        public ItemBlock createItemBlock(T block) {
            return (ItemBlock) new ItemChiselBlock(block).setRegistryName(block.getRegistryName());
        }
    }

    ;

    static void init() {
        Chisel.logger.info("Starting init...");
        loadRecipes();
        Chisel.logger.info("Init finished.");
    }

    private static void loadBlocks() {
        Chisel.logger.info("Loading blocks...");
        int num = 0;
        ChiselBlockFactory factory = ChiselBlockFactory.newFactory(Chisel.MOD_ID);
        for (Features f : values()) {
            if (f.enabled()) {
                f.addBlocks(factory);
                ++num;
            } else {
                logDisabled(f);
            }
        }
        Chisel.logger.info(num + " Feature's blocks loaded.");
        Chisel.logger.info("Loading Tile Entities...");
        Chisel.proxy.registerTileEntities();
        Chisel.logger.info("Tile Entities loaded.");
    }

    private static void loadItems() {
        Chisel.logger.info("Loading items...");
        int num = 0;
        for (Features f : values()) {
            if (f.enabled()) {
                f.addItems();
                ++num;
            } else {
                logDisabled(f);
            }
        }
        Chisel.logger.info(num + " Feature's items loaded.");
    }

    private static void loadRecipes() {
        Chisel.logger.info("Loading recipes...");
        int num = 0;
        for (Features f : values()) {
            if (f.enabled()) {
                // if (f.needsMetaRecipes()) {
                // for (int i = 0; i < 16; i++) {
                // meta = i;
                // f.addRecipes();
                // }
                // meta = 0;
                // }
                // else {
                f.addRecipes();
                // }
                ++num;
            } else {
                logDisabled(f);
            }
        }
        Chisel.logger.info(num + " Feature's recipes loaded.");
    }

    private static void logDisabled(Features f) {
        if (!f.hasParentFeature() && f.parent != null) {
            Chisel.logger.info("Skipping feature {} as its parent feature {} was disabled.", Configurations.featureName(f), Configurations.featureName(f.parent));
        } else if (!f.hasRequiredMod() && f.getRequiredMod() != null) {
            Chisel.logger.info("Skipping feature {} as its required mod {} was missing.", Configurations.featureName(f), f.getRequiredMod());
        } else {
            Chisel.logger.info("Skipping feature {} as it was disabled in the config.", Configurations.featureName(f));
        }
    }

    public static boolean oneModdedFeatureLoaded() {
        for (Features f : values()) {
            if (f.hasRequiredMod()) {
                return true;
            }
        }
        return false;
    }

    static void preInit() {
        Chisel.logger.info("Starting pre-init...");
        loadBlocks();
        loadItems();
        Chisel.logger.info("Pre-init finished.");
    }

    private Features parent;

    private String requiredMod;

    private Features() {
        this(null, null);
    }

    private Features(Features parent) {
        this(null, parent);
    }

    private Features(String requiredMod) {
        this(requiredMod, null);
    }

    private Features(String requriedMod, Features parent) {
        this.requiredMod = requriedMod;
        this.parent = parent;
    }

    void addBlocks(ChiselBlockFactory factory) {
        ;
    }

    void addItems() {
        ;
    }

    void addRecipes() {
        ;
    }

    public boolean enabled() {
        return Configurations.featureEnabled(this) && hasRequiredMod() && hasParentFeature();
    }

    private final boolean hasParentFeature() {
        return parent == null || parent.enabled();
    }

    private final boolean hasRequiredMod() {
        return getRequiredMod() == null || Loader.isModLoaded(getRequiredMod());
    }

    private String getRequiredMod() {
        return requiredMod;
    }

    boolean needsMetaRecipes() {
        return false;
    }

    private static void registerSlabTop(@Nonnull Block bottom, Block top) {
        ResourceLocation block = Block.REGISTRY.getNameForObject(bottom);
        String name = block.getResourcePath() + "_top";
        // GameRegistry.registerBlock(top, ItemCarvableSlab.class, name); TODO
    }
}