/*==============================================================================
 = Class: EffectsConfig
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2021.
 =============================================================================*/

package it.hurts.metallurgy_reforged.config;

import it.hurts.metallurgy_reforged.Metallurgy;
import net.minecraftforge.common.config.Config;

//Variables are accessed through reflections most of the times
@SuppressWarnings("unused")
@Config.LangKey("config.metallurgy.category.effects")
@Config(modid = Metallurgy.MODID, name = "metallurgy_reforged/effects", category = "effect_roster")
@Config.RequiresMcRestart
public class EffectsConfig {

    @Config.Name("Symbiosis I")
    @Config.Comment("Starving consumes equipment while eating restores it")
    public static boolean adamantineEffectAll = true;
    @Config.Name("Symbiosis II")
    @Config.Comment("When taking lethal damage you have a chance (based on how many armor pieces you wear) to survive the hit and lose a piece of armor")
    public static boolean adamantineEffectArmor = true;

    @Config.Name("Sky-High")
    @Config.Comment("Grants extra jumps (from 1 to 4) depending on how many armor pieces the player is wearing")
    public static boolean amordrineEffectArmor = true;
    @Config.Name("Sky-High")
    @Config.Comment("Grants extra jumps (from 1 to 4) depending on how many armor pieces the player is wearing")
    public static boolean amordrineEffectAll = true;
    @Config.Name("Coup de grâce")
    @Config.Comment("Bonus Damage depending on target's health,the more the target has the less health the more damage the weapon does (up to 200% damage boost)")
    public static boolean amordrineEffectWeapon = true;

    @Config.Name("Reactive II")
    @Config.Comment("Deal more damage to armored enemies")
    public static boolean angmallenEffectWeapon = true;
    @Config.Name("Transmute")
    @Config.Comment("Mining an ore  sometimes drops another ore of +1/-1/+0 harvest level (50% chance)")
    public static boolean angmallenEffectPickaxe = true;
    @Config.Name("Reactive III")
    @Config.Comment("Plays a sound sometimes when you're near some rare ore, every armor piece increases the chance to detect rare ores")
    public static boolean angmallenEffectArmor = true;

    @Config.Name("Starlight")
    @Config.Comment("Gives Night Vision and Speed during night time or in the End if the player has the sky above their head depending on how many armor pieces are worn")
    public static boolean astralSilverEffectArmor = true;
    @Config.Name("Extraterrestrial I")
    @Config.Comment("45% more damage if the player is in another dimension")
    public static boolean astralSilverEffectWeapon = true;
    @Config.Name("Extraterrestrial II")
    @Config.Comment("Increased speed when breaking blocks in dimensions that aren't the Overworld")
    public static boolean astralSilverEffectTool = true;

    @Config.Name("Whirlwind")
    @Config.Comment("A whirlwind will save you from taking fall damage pushing you in a random direction")
    public static boolean atlarusEffectArmor = true;
    @Config.Name("Gust of Wind")
    @Config.Comment("A strong gust of wind pushes enemies away from you and breaks leaves and vines in a range of 5 blocks around you")
    public static boolean atlarusEffectWeapon = true;
    @Config.Name("Wind Scythe")
    @Config.Comment("Wind helps you removes bushes and crops around you")
    public static boolean atlarusEffectHoe = true;

    @Config.Name("Mountain I")
    @Config.Comment("Receiving damage sometimes grants resistance but also slowness, at the same time. ( Repeated strikes stack the effect, aka slowness I and resistance I become slowness II and resistance II. Can stack up to 3 times, chance based.)")
    public static boolean blackSteelEffectArmor = true;
    @Config.Name("Mountain II")
    @Config.Comment("Tools & weapons act like armor, for example holding a black steel sword while getting attacked will damage the sword but absorb a small portion of the damage.")
    public static boolean blackSteelEffectWeapon = true;

    @Config.Name("Cadence")
    @Config.Comment("Mining  a block will mine surrounding blocks of the same type in a spheric range")
    public static boolean carmotEffectTool = true;
    @Config.Name("Power User")
    @Config.Comment("You can comsume and use items faster depending on how many armor pieces you wear; if you wear a full set you also get a Haste III buff")
    public static boolean carmotEffectArmor = true;
    @Config.Name("Abattoir")
    @Config.Comment("Attacking a mob will also attack mobs of the same type in a radius around the initial strike")
    public static boolean carmotEffectWeapon = true;

    @Config.Name("Escalation")
    @Config.Comment("Continuously breaking blocks without stopping doesn't use durability and increases mining speed. (Resets after pausing for more than a second, the unbreakable effect is enabled after 5 blocks mined)")
    public static boolean celenegilEffectTool = true;
    @Config.Name("Perseverance")
    @Config.Comment("After being attacked five times over a short period, all the enemies are knocked back away from the player and the player receives a very short regen buff and all negative effects are cleared.")
    public static boolean celenegilEffectArmor = true;
    @Config.Name("Glory Seeker")
    @Config.Comment("On right click, Grants a small damage buff to the weapon damage but when you damage an entity without killing it, it'll go on a short cooldown while it will give the player some short speed and strength buff if they manage to kill the entity")
    public static boolean celenegilEffectWeapon = true;

    @Config.Name("Flash Freeze")
    @Config.Comment("Has a chance to completely freeze an enemy in place on hit.")
    public static boolean ceruclaseEffectWeapon = true;
    @Config.Name("Blizzard")
    @Config.Comment("Mobs are slowed, fatigued and weakened depending on how much armor you wear, both players and entities are extinguished if they were on fire.")
    public static boolean ceruclaseEffectArmor = true;
    @Config.Name("Cold Snap")
    @Config.Comment("Blocks with harvest level of 0 are harvested instantly. (Dirt, sand, Wood)")
    public static boolean ceruclaseEffectTool = true;

    @Config.Name("Royal Blood")
    @Config.Comment("A minion will be spawned to aid you in your fights against enemies as soon as you take damage (minion health will scale with the armor count)")
    public static boolean damascusSteelEffectArmor = true;
    @Config.Name("Brilliance I")
    @Config.Comment("Mobs drop significantly more experience.")
    public static boolean damascusSteelEffectWeapon = true;
    @Config.Name("Brilliance II")
    @Config.Comment("Mining ores sometimes grants a bit of experience depending on the harvest level.")
    public static boolean damascusSteelEffectPickaxe = true;

    @Config.Name("Aquatic")
    @Config.Comment("Grants Water Breathing and improved Mobility in water depending on how many armor pieces are worn (it also grants night vision with 2 or more armor pieces).")
    public static boolean deepIronEffectArmor = true;
    @Config.Name("Diver")
    @Config.Comment("Improved tool harvest speed when underwater (3 times the normal underwater speed)")
    public static boolean deepIronEffectTool = true;
    @Config.Name("Diver")
    @Config.Comment("Enhanced weapon damage when underwater (+3 hearts of damage)")
    public static boolean deepIronEffectWeapon = true;

    @Config.Name("Wormhole")
    @Config.Comment("Tool Reach is 3 blocks higher than normal (can't be disabled here) - block drops are teleported to the player inventory directly")
    public static boolean desichalkosEffectTool = true;
    @Config.Name("Nullifier")
    @Config.Comment("When attacking, the damage is dealt straight to the opponent's health bar, unaffected by armor or any resistance the opponent might have. ")
    public static boolean desichalkosEffectWeapon = true;
    @Config.Name("Orb")
    @Config.Comment("The wearer can fully absorb X instances of damage (X scales with armor) without taking damage, the \"Layers\" regenerate one at a time every 7 seconds after the last time the wearer took damage.")
    public static boolean desichalkosEffectArmor = true;

    @Config.Name("Magnet")
    @Config.Comment("Activating the effect with a right click on the weapon will cause entities in line of sight of the player to be moved towards the player.")
    public static boolean electrumEffectWeapon = true;
    @Config.Name("Voltage Control")
    @Config.Comment("Harvesting blocks while the effect is active (right-click) will make the tool use 10x durability but mine significantly faster and gain a higher harvest level.")
    public static boolean electrumEffectTool = true;
    @Config.Name("Static")
    @Config.Comment("Receiving damages charges items in the player inventory with Energy. Energy is distributed equally among all items. Energy value scales based on damage received prior to armor reduction calculations.")
    public static boolean electrumEffectArmor = true;

    @Config.Name("Ethereal")
    @Config.Comment("Allows the player to clip through walls when sneaking for at most 15 seconds after which the player remains stuck in the wall")
    public static boolean etheriumEffectArmor = true;
    @Config.Name("Siphon")
    @Config.Comment("When attacking, sometimes extra damage is dealt and the user regenerates health equal to the extra damage. If the player has full HP they gain an absorption buff for that amount of hp (Absorption doesn’t stack).")
    public static boolean etheriumEffectWeapon = true;

    @Config.Name("End Domestic")
    @Config.Comment("Shulkers become neutral, but you're not immune to the effect of lingering bullets.")
    public static boolean eximiteEffectArmor = true;
    @Config.Name("Outworlder")
    @Config.Comment("Grants bonus damage and a looting effect to mobs in the End.")
    public static boolean eximiteEffectWeapon = true;

    @Config.Name("Adaptability")
    @Config.Comment("Each armor piece gives has a different: \nhelmet: immunity to hunger effect, \nchestplate: fire resistence, \nleggings: immunity to slowness effect, \nboots: immunity to levitation effect")
    public static boolean haderothEffectArmor = true;
    @Config.Name("Apex")
    @Config.Comment("Killing the same mob over and over again grants bonus damage, but killing a different one resets it")
    public static boolean haderothEffectWeapon = true;
    @Config.Name("Metamorph")
    @Config.Comment("Items have a second life, once they reach 0 durability they're replaced by a new and better version of themselves; <NL> Armor pieces will be reborn with higher durability and protection and toughness values; <NL> All items will will be reborn higher durability and increased efficiency when breaking blocks, weapons also get a 1 heart permanent bonus damage.<NL> (all the other Haderoth effects are enabled after items are reborn, if you disable this the effects will work out of the box).")
    public static boolean haderothEffectAll = true;

    @Config.Name("Disarm")
    @Config.Comment("When attacking you have a chance to rob the enemy of some of their equipment.")
    public static boolean hepatizonEffectWeapon = true;
    @Config.Name("Cloak & Dagger")
    @Config.Comment("Grants AI invisibility outside of a certain radius depending on how much armor you're wearing.")
    public static boolean hepatizonEffectArmor = true;

    @Config.Name("Molten Core")
    @Config.Comment("Auto-smelts block drops if they can be smelted.<NL>Auto-smelt chance is based on the Fortune enchantment")
    public static boolean ignatiusEffectTool = true;
    @Config.Name("Molten Core")
    @Config.Comment("Auto-smelts entity loot if they can be smelted.<NL>Auto-smelt chance is based on the Fortune enchantment")
    public static boolean ignatiusEffectWeapon = true;
    @Config.Name("Hot-Blooded")
    @Config.Comment("Fire and lava heals you proportionally to the damage it would otherwise deal, but water and rain damages you as if it were lava and fire; <NL>The effect of Fire Protection is inverted, to protect water damage")
    public static boolean ignatiusEffectArmor = true;

    @Config.Name("Time Cleave")
    @Config.Comment("When attacking, sometimes an extra attack can occur, the player will swing his arm twice in quick succession.")
    public static boolean inolashiteEffectWeapon = true;
    @Config.Name("Time Blink")
    @Config.Comment("Upon activation, transports the player 7 blocks in the direction they are looking breaking all the blocks the tool can break that get in the way")
    public static boolean inolashiteEffectTool = true;

    @Config.Name("Weight-Controlled Flight")
    @Config.Comment("Makes you float at a certain height depending on how much filled your inventory is. You can press the UP arrow or the DOWN arrow to float respectively up and down.  You have a height limit you can't go over while floating, that limit depends on how full your inventory is (excluding the hotbar). There's also an HUD in the bottom-right corner of the screen that shows you, your height level and your limit.")
    public static boolean krikEffectArmor = true;

    private EffectsConfig()
    {
    }

}