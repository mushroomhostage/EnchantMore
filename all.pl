#!/usr/bin/perl
use strict;
use warnings;

use Data::Dumper;

my %all;

my $ARMOR = [qw(Helmet Chestplate Leggings Boots)];
my $WEAPON = [qw(Sword Bow)];
my $TOOL = [qw(Pickaxe Shovel Axe)];

my %valid = (
    Protection => $ARMOR,
    Fire_Protection => $ARMOR,
    Feather_Falling => ["Boots"],
    Blast_Protection => $ARMOR,
    Respiration => ["Helmet"],
    Aqua_Affinity => ["Helmet"],

    Sharpness => ["Sword"],
    Smite => ["Sword"],
    Bane_of_Arthropods => ["Sword"],
    Knockback => ["Sword"],
    Fire_Aspect => ["Sword"],
    Looting => ["Sword"],

    Power => ["Bow"],
    Punch => ["Bow"],
    Flame => ["Bow"],
    Infinity => ["Bow"],

    Efficiency => $TOOL,
    Silk_Touch => $TOOL,
    Unbreaking => $TOOL,
    Fortune => $TOOL
    );

my @items = (@$ARMOR, @$WEAPON, @$TOOL, "Fishing_Rod", "Shears", "Hoe", "Flint_&_Steel");

# Part of the unmodified game
for my $ench (keys %valid) {
    my ($ench_name);
    ($ench_name = $ench) =~ tr/_/ /;
    for my $item (@items) {
        $all{"$item + $ench_name"} = "?";  # nothing
    }

    my @valids = @{$valid{$ench}};
    for my $item (@valids) {
        $all{"$item + $ench_name"} = "(vanilla)";
    }
}

# EnchantMore stuff
my @defined = map { 
        my ($item, $ench, $effect) = m/^\s*([^+]+)\s*[+]([^=]+)\s*[=]\s*(.*)/; 
        $item =~ s/^\s+//; $item =~ s/\s+$//;
        $ench =~ s/^\s+//; $ench =~ s/\s+$//;
        $effect =~ s/^\s+//; $effect =~ s/\s+$//;
        { ITEM => $item, ENCH => $ench, EFFECT => $effect } 
    } map { s/^[*] //g; $_ } `./list.sh`;

for my $d (@defined) {
    my ($item) = $d->{ITEM};
    my ($ench) = $d->{ENCH};
    my ($effect) = $d->{EFFECT};
    $all{"$item + $ench"} = $effect;
}


for my $ie (sort keys %all) {
    my $effect = $all{$ie};
    print "$ie = $effect\n";
}
