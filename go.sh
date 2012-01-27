#!/bin/sh -x
CLASSPATH=../craftbukkit-1.1-R1.jar javac *.java -Xlint:deprecation -Xlint:unchecked
rm -rf me
mkdir -p me/exphc/EnchantMore
mv *.class me/exphc/EnchantMore/
jar cf EnchantMore.jar me/ *.yml
cp EnchantMore.jar ../plugins/
