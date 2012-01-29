#!/usr/bin/perl
use strict;
use warnings;

my $ARMOR = [qw(Helmet Chestplate Leggings Boots)];
my $SWORD = ["Sword"];
my $BOW = ["Bow"];
my $TOOL = [qw(Pickaxe Shovel Axe)];
my %valid = (
    Protection => $ARMOR,
    Fire_Protection => $ARMOR,
    Feather_Falling => ["Boots"],
    Blast_Protection => $ARMOR,
    Respiration => ["Helmet"],
    Aqua_Affinity => ["Helmet"],

    Sharpness => $SWORD,
    Smite => $SWORD,
    Bane_of_Arthropods => $SWORD,
    Knockback => $SWORD,
    Fire_Aspect => $SWORD,
    Looting => $SWORD,

    Power => $BOW,
    Punch => $BOW,
    Flame => $BOW,
    Infinity => $BOW,

    Efficiency => $TOOL,
    Silk_Touch => $TOOL,
    Unbreaking => $TOOL,
    Fortune => $TOOL
    );


