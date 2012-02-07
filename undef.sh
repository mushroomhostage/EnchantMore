#!/bin/sh
perl all.pl|fgrep "?"|perl -pe's/_/ /g'|perl -pe's/^/* /'

