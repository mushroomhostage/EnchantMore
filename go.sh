#!/bin/sh -x
CLASSPATH=../craftbukkit-1.1-R4.jar javac *.java -Xlint:deprecation -Xlint:unchecked
rm -rf me
mkdir -p me/exphc/EnchantMore
mv *.class me/exphc/EnchantMore/
jar cf EnchantMore.jar me/ *.yml *.java *.dat README.md ChangeLog LICENSE
cp EnchantMore.jar ../plugins/
