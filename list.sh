#!/bin/sh
fgrep "// " EnchantMore.java |fgrep "+"|egrep -v '(BLOCKED|TODO)'|perl -pe's(^\s*/*\s*)()'|sort
