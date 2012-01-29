#!/usr/bin/perl
use strict;
use warnings;

our %enchs = (
    Armor => [qw(Protection Fire_Protection Feather_Falling Blast_Protection Projectile_Protection Respiration Aqua_Affinity)],
    Sword => [qw(Sharpness Smite Bane_of_Arthropods Knockback Fire_Aspect Looting)],
    Bow => [qw(Power Punch Flame Infinity)],
    Tool => [qw(Efficiency Silk_Touch Unbreaking Fortune)]);

our %items = (
    Armor => [qw(Helmet Chestplate Leggings Boots)],
    Sword => ["Sword"],
    Bow => ["Bow"],
    Tool => [qw(Axe

