#!/bin/bash

# Temizle
rm -rf bin
mkdir -p bin

# Derle
echo "Derleniyor..."
javac -d bin src/com/halukkilincer/adventure/launcher/Main.java

# Çalıştır
echo "Çalıştırılıyor..."
java -cp bin com.halukkilincer.adventure.launcher.Main 