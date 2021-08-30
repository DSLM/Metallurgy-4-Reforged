#priority 99
#modloaded metallurgy crafttweaker

import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.oredict.IOreDict;

print("-------------------------------------------------------------------------------------------------------------");
print("These scripts are licensed under GNU GPLv3.");
print("-------------------------------------------------------------------------------------------------------------");
//	Special thanks to "Zook" & "democat" for helping me with the global variables.

static snakeMetals as string[] = ["adamantine","alduorite","amordrine","angmallen","astral_silver","atlarus","black_steel","brass","bronze","carmot","celenegil","ceruclase","copper","deep_iron","desichalkos","damascus_steel","electrum","etherium","eximite","haderoth","hepatizon","ignatius","infuscolium","inolashite","kalendrite","krik","lemurite","lutetium","manganese","meutoite","midasium","mithril","orichalcum","osmium","oureclase","platinum","prometheum","quicksilver","rubracium","sanguinite","shadow_iron","shadow_steel","silver","steel","tartarite","tin","vulcanite","vyroxeres","zinc"] as string[];
static pascalMetals as string[] = ["Adamantine","Alduorite","Amordrine","Angmallen","AstralSilver","Atlarus","BlackSteel","Brass","Bronze","Carmot","Celenegil","Ceruclase","Copper","DeepIron","Desichalkos","DamascusSteel","Electrum","Etherium","Eximite","Haderoth","Hepatizon","Ignatius","Infuscolium","Inolashite","Kalendrite","Krik","Lemurite","Lutetium","Manganese","Meutoite","Midasium","Mithril","Orichalcum","Osmium","Oureclase","Platinum","Prometheum","Quicksilver","Rubracium","Sanguinite","ShadowIron","ShadowSteel","Silver","Steel","Tartarite","Tin","Vulcanite","Vyroxeres","Zinc"] as string[];
static toolMetals as string[] = ["amordrine","haderoth","platinum","vulcanite","ignatius","etherium","quicksilver","brass","astral_silver","hepatizon","bronze","sanguinite","eximite","silver","desichalkos","celenegil","shadowIron","steel","carmot","mithril","ceruclase","deepIron","angmallen","kalendrite","damascus_steel","prometheum","copper","adamantine","electrum","tartarite","atlarus","blackSteel","vyroxeres","oureclase","inolashite","orichalcum","shadow_steel","midasium","krik"] as string[];

print("Creating global variables...");
static ingots as IItemStack[] = [<ore:ingotAmordrine>.firstItem,<ore:ingotHaderoth>.firstItem,<ore:ingotAlduorite>.firstItem,<ore:ingotPlatinum>.firstItem,<ore:ingotTin>.firstItem,<ore:ingotVulcanite>.firstItem,<ore:ingotIgnatius>.firstItem,<ore:ingotZinc>.firstItem,<ore:ingotEtherium>.firstItem,<ore:ingotQuicksilver>.firstItem,<ore:ingotBrass>.firstItem,<ore:ingotAstralSilver>.firstItem,<ore:ingotHepatizon>.firstItem,<ore:ingotBronze>.firstItem,<ore:ingotLemurite>.firstItem,<ore:ingotEximite>.firstItem,<ore:ingotSanguinite>.firstItem,<ore:ingotSilver>.firstItem,<ore:ingotDesichalkos>.firstItem,<ore:ingotCelenegil>.firstItem,<ore:ingotShadowIron>.firstItem,<ore:ingotSteel>.firstItem,<ore:ingotCarmot>.firstItem,<ore:ingotMithril>.firstItem,<ore:ingotCeruclase>.firstItem,<ore:ingotDeepIron>.firstItem,<ore:ingotAngmallen>.firstItem,<ore:ingotKalendrite>.firstItem,<ore:ingotManganese>.firstItem,<ore:ingotDamascusSteel>.firstItem,<ore:ingotPrometheum>.firstItem,<ore:ingotCopper>.firstItem,<ore:ingotAdamantine>.firstItem,<ore:ingotElectrum>.firstItem,<ore:ingotTartarite>.firstItem,<ore:ingotAtlarus>.firstItem,<ore:ingotBlackSteel>.firstItem,<ore:ingotVyroxeres>.firstItem,<ore:ingotLutetium>.firstItem,<ore:ingotOsmium>.firstItem,<ore:ingotOureclase>.firstItem,<ore:ingotInolashite>.firstItem,<ore:ingotMeutoite>.firstItem,<ore:ingotOrichalcum>.firstItem,<ore:ingotInfuscolium>.firstItem,<ore:ingotMidasium>.firstItem,<ore:ingotShadowSteel>.firstItem,<ore:ingotKrik>.firstItem,<ore:ingotRubracium>.firstItem] as IItemStack[];
static metalBlocks as IItemStack[] = [<metallurgy:amordrine_block>,<metallurgy:haderoth_block>,<metallurgy:alduorite_block>,<metallurgy:platinum_block>,<metallurgy:vulcanite_block>,<metallurgy:tin_block>,<metallurgy:ignatius_block>,<metallurgy:zinc_block>,<metallurgy:etherium_block>,<metallurgy:quicksilver_block>,<metallurgy:brass_block>,<metallurgy:astral_silver_block>,<metallurgy:hepatizon_block>,<metallurgy:bronze_block>,<metallurgy:lemurite_block>,<metallurgy:sanguinite_block>,<metallurgy:eximite_block>,<metallurgy:silver_block>,<metallurgy:desichalkos_block>,<metallurgy:celenegil_block>,<metallurgy:steel_block>,<metallurgy:shadow_iron_block>,<metallurgy:carmot_block>,<metallurgy:mithril_block>,<metallurgy:ceruclase_block>,<metallurgy:deep_iron_block>,<metallurgy:angmallen_block>,<metallurgy:manganese_block>,<metallurgy:kalendrite_block>,<metallurgy:damascus_steel_block>,<metallurgy:prometheum_block>,<metallurgy:copper_block>,<metallurgy:adamantine_block>,<metallurgy:electrum_block>,<metallurgy:tartarite_block>,<metallurgy:atlarus_block>,<metallurgy:black_steel_block>,<metallurgy:vyroxeres_block>,<metallurgy:lutetium_block>,<metallurgy:osmium_block>,<metallurgy:oureclase_block>,<metallurgy:inolashite_block>,<metallurgy:meutoite_block>,<metallurgy:orichalcum_block>,<metallurgy:infuscolium_block>,<metallurgy:midasium_block>,<metallurgy:shadow_steel_block>,<metallurgy:rubracium_block>] as IItemStack[];
static decoBlocks as IOreDictEntry[] = [<ore:decorAmordrine>,<ore:decorHaderoth>,<ore:decorAlduorite>,<ore:decorPlatinum>,<ore:decorTin>,<ore:decorVulcanite>,<ore:decorIgnatius>,<ore:decorZinc>,<ore:decorEtherium>,<ore:decorQuicksilver>,<ore:decorBrass>,<ore:decorAstralSilver>,<ore:decorHepatizon>,<ore:decorBronze>,<ore:decorLemurite>,<ore:decorEximite>,<ore:decorSanguinite>,<ore:decorSilver>,<ore:decorDesichalkos>,<ore:decorCelenegil>,<ore:decorShadowIron>,<ore:decorSteel>,<ore:decorCarmot>,<ore:decorMithril>,<ore:decorCeruclase>,<ore:decorDeepIron>,<ore:decorAngmallen>,<ore:decorKalendrite>,<ore:decorManganese>,<ore:decorDamascusSteel>,<ore:decorPrometheum>,<ore:decorCopper>,<ore:decorAdamantine>,<ore:decorElectrum>,<ore:decorTartarite>,<ore:decorAtlarus>,<ore:decorBlackSteel>,<ore:decorVyroxeres>,<ore:decorLutetium>,<ore:decorOsmium>,<ore:decorOureclase>,<ore:decorInolashite>,<ore:decorMeutoite>,<ore:decorOrichalcum>,<ore:decorInfuscolium>,<ore:decorMidasium>,<ore:decorShadowSteel>,<ore:decorKrik>,<ore:decorRubracium>] as IOreDictEntry[];
static nuggets as IItemStack[] = [<ore:nuggetAmordrine>.firstItem,<ore:nuggetHaderoth>.firstItem,<ore:nuggetAlduorite>.firstItem,<ore:nuggetPlatinum>.firstItem,<ore:nuggetTin>.firstItem,<ore:nuggetVulcanite>.firstItem,<ore:nuggetIgnatius>.firstItem,<ore:nuggetZinc>.firstItem,<ore:nuggetEtherium>.firstItem,<ore:nuggetQuicksilver>.firstItem,<ore:nuggetBrass>.firstItem,<ore:nuggetAstralSilver>.firstItem,<ore:nuggetHepatizon>.firstItem,<ore:nuggetBronze>.firstItem,<ore:nuggetLemurite>.firstItem,<ore:nuggetEximite>.firstItem,<ore:nuggetSanguinite>.firstItem,<ore:nuggetSilver>.firstItem,<ore:nuggetDesichalkos>.firstItem,<ore:nuggetCelenegil>.firstItem,<ore:nuggetShadowIron>.firstItem,<ore:nuggetSteel>.firstItem,<ore:nuggetCarmot>.firstItem,<ore:nuggetMithril>.firstItem,<ore:nuggetCeruclase>.firstItem,<ore:nuggetDeepIron>.firstItem,<ore:nuggetAngmallen>.firstItem,<ore:nuggetKalendrite>.firstItem,<ore:nuggetManganese>.firstItem,<ore:nuggetDamascusSteel>.firstItem,<ore:nuggetPrometheum>.firstItem,<ore:nuggetCopper>.firstItem,<ore:nuggetAdamantine>.firstItem,<ore:nuggetElectrum>.firstItem,<ore:nuggetTartarite>.firstItem,<ore:nuggetAtlarus>.firstItem,<ore:nuggetBlackSteel>.firstItem,<ore:nuggetVyroxeres>.firstItem,<ore:nuggetLutetium>.firstItem,<ore:nuggetOsmium>.firstItem,<ore:nuggetOureclase>.firstItem,<ore:nuggetInolashite>.firstItem,<ore:nuggetMeutoite>.firstItem,<ore:nuggetOrichalcum>.firstItem,<ore:nuggetInfuscolium>.firstItem,<ore:nuggetMidasium>.firstItem,<ore:nuggetShadowSteel>.firstItem,<ore:nuggetKrik>.firstItem,<ore:nuggetRubracium>.firstItem] as IItemStack[];
static ores as IItemStack[] = [<ore:oreAmordrine>.firstItem,<ore:oreHaderoth>.firstItem,<ore:oreAlduorite>.firstItem,<ore:orePlatinum>.firstItem,<ore:oreTin>.firstItem,<ore:oreVulcanite>.firstItem,<ore:oreIgnatius>.firstItem,<ore:oreZinc>.firstItem,<ore:oreEtherium>.firstItem,<ore:oreQuicksilver>.firstItem,<ore:oreBrass>.firstItem,<ore:oreAstralSilver>.firstItem,<ore:oreHepatizon>.firstItem,<ore:oreBronze>.firstItem,<ore:oreLemurite>.firstItem,<ore:oreEximite>.firstItem,<ore:oreSanguinite>.firstItem,<ore:oreSilver>.firstItem,<ore:oreDesichalkos>.firstItem,<ore:oreCelenegil>.firstItem,<ore:oreShadowIron>.firstItem,<ore:oreSteel>.firstItem,<ore:oreCarmot>.firstItem,<ore:oreMithril>.firstItem,<ore:oreCeruclase>.firstItem,<ore:oreDeepIron>.firstItem,<ore:oreAngmallen>.firstItem,<ore:oreKalendrite>.firstItem,<ore:oreManganese>.firstItem,<ore:oreDamascusSteel>.firstItem,<ore:orePrometheum>.firstItem,<ore:oreCopper>.firstItem,<ore:oreAdamantine>.firstItem,<ore:oreElectrum>.firstItem,<ore:oreTartarite>.firstItem,<ore:oreAtlarus>.firstItem,<ore:oreBlackSteel>.firstItem,<ore:oreVyroxeres>.firstItem,<ore:oreLutetium>.firstItem,<ore:oreOsmium>.firstItem,<ore:oreOureclase>.firstItem,<ore:oreInolashite>.firstItem,<ore:oreMeutoite>.firstItem,<ore:oreOrichalcum>.firstItem,<ore:oreInfuscolium>.firstItem,<ore:oreMidasium>.firstItem,<ore:oreShadowSteel>.firstItem,<ore:oreKrik>.firstItem,<ore:oreRubracium>.firstItem] as IItemStack[];
static liquids as ILiquidStack[] = [<liquid:amordrine>,<liquid:haderoth>,<liquid:alduorite>,<liquid:platinum>,<liquid:tin>,<liquid:vulcanite>,<liquid:ignatius>,<liquid:zinc>,<liquid:etherium>,<liquid:quicksilver>,<liquid:brass>,<liquid:astral_silver>,<liquid:hepatizon>,           <liquid:bronze>,<liquid:lemurite>,<liquid:eximite>,<liquid:sanguinite>,<liquid:silver>,<liquid:desichalkos>,<liquid:celenegil>,<liquid:shadow_iron>,           <liquid:steel>,<liquid:carmot>,<liquid:mithril>,<liquid:ceruclase>,<liquid:deep_iron>,           <liquid:angmallen>,<liquid:kalendrite>,<liquid:manganese>,<liquid:damascus_steel>,           <liquid:prometheum>,<liquid:copper>,<liquid:adamantine>,<liquid:electrum>,<liquid:tartarite>,<liquid:atlarus>,<liquid:black_steel>,           <liquid:vyroxeres>,<liquid:lutetium>,<liquid:osmium>,<liquid:oureclase>,<liquid:inolashite>,<liquid:meutoite>,<liquid:orichalcum>,<liquid:infuscolium>,<liquid:midasium>,<liquid:shadow_steel>,<liquid:krik>,<liquid:rubracium>] as ILiquidStack[];

static decoMap as IItemStack[][string] = {} as IItemStack[][string];
for i in 0 .. snakeMetals.length {
    decoMap[pascalMetals[i]] = [
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_engraved_block"),
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_large_bricks"),
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_bricks"),
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_crystals"),
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_hazard_block"),
        itemUtils.getItem("metallurgy:" + snakeMetals[i] + "_reinforced_glass")
    ] as IItemStack[];
}

static toolsMap as IItemStack[][string] = {} as IItemStack[][string];
for toolMetal in toolMetals {
    toolsMap[toolMetal] = [
        itemUtils.getItem("metallurgy:" + toolMetal + "_axe"),
        itemUtils.getItem("metallurgy:" + toolMetal + "_hoe"),
        itemUtils.getItem("metallurgy:" + toolMetal + "_pickaxe"),
        itemUtils.getItem("metallurgy:" + toolMetal + "_shovel"),
        itemUtils.getItem("metallurgy:" + toolMetal + "_sword")
    ] as IItemStack[];
}

static ironDecorBlocks as IItemStack[] = [<metallurgy:iron_large_bricks>,<metallurgy:iron_bricks>,<metallurgy:iron_crystals>,<metallurgy:iron_hazard_block>,<metallurgy:iron_reinforced_glass>] as IItemStack[];
static goldDecorBlocks as IItemStack[] = [<metallurgy:gold_large_bricks>,<metallurgy:gold_bricks>,<metallurgy:gold_crystals>,<metallurgy:gold_hazard_block>,<metallurgy:gold_reinforced_glass>] as IItemStack[];

print("All the global variables are created! proceeding to modifying the ore dictionary!");