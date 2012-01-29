#!/bin/sh
fgrep "// " EnchantMore.java |fgrep "+"|egrep -v '(BLOCKED|TODO|secondary)'|perl -pe's(^\s*/*\s*)()'|sort|perl -pe's/^/* /'
