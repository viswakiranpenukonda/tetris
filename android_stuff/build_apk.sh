#!/bin/bash

echo "Building Android Tetris Game APK..."
echo

# Check if gradlew exists
if [ ! -f "gradlew" ]; then
    echo "Error: gradlew not found. Please run this script from the project root directory."
    exit 1
fi

# Make gradlew executable
chmod +x gradlew

# Clean previous builds
echo "Cleaning previous builds..."
./gradlew clean

# Build debug APK
echo "Building debug APK..."
./gradlew assembleDebug

# Check if build was successful
if [ $? -eq 0 ]; then
    echo
    echo "Build successful!"
    echo "APK location: app/build/outputs/apk/debug/app-debug.apk"
    echo
    echo "You can now install this APK on your Android device."
    echo "Make sure to enable 'Unknown Sources' in your device settings."
else
    echo
    echo "Build failed! Please check the error messages above."
    exit 1
fi 