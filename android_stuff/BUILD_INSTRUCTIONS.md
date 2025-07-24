# Android Tetris Game - Build Instructions

## Prerequisites

Before building the APK, you need to install the following:

### 1. Java Development Kit (JDK)
- Download and install Java 8 or higher from: https://adoptium.net/
- Set JAVA_HOME environment variable to point to your JDK installation

### 2. Android Studio
- Download and install Android Studio from: https://developer.android.com/studio
- During installation, make sure to install:
  - Android SDK
  - Android SDK Platform-Tools
  - Android SDK Build-Tools

### 3. Set Environment Variables
Set the following environment variables:
- `JAVA_HOME`: Path to your JDK installation
- `ANDROID_HOME`: Path to your Android SDK installation

## Building the APK

### Method 1: Using Android Studio (Recommended)

1. **Open Android Studio**
2. **Open the Project**:
   - Click "Open an existing Android Studio project"
   - Navigate to the `android_stuff` folder and select it
   - Wait for the project to sync and index

3. **Build the APK**:
   - Go to `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
   - Or use the shortcut: `Ctrl + F9` to build the project

4. **Locate the APK**:
   - The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`
   - Android Studio will show a notification when the build is complete

### Method 2: Using Command Line (Alternative)

If you have the Android SDK and Java installed, you can try:

```bash
# On Windows
.\gradlew.bat assembleDebug

# On Unix/Linux/macOS
./gradlew assembleDebug
```

### Method 3: Using the Build Scripts

We've provided build scripts for convenience:

```bash
# On Windows
.\build_apk.bat

# On Unix/Linux/macOS
./build_apk.sh
```

## Troubleshooting

### Common Issues:

1. **Gradle Wrapper Issues**:
   - If you get permission errors, try running as Administrator
   - Make sure the `gradle-wrapper.jar` file exists in `gradle/wrapper/`

2. **Java Not Found**:
   - Install Java 8 or higher
   - Set JAVA_HOME environment variable
   - Add Java to your PATH

3. **Android SDK Issues**:
   - Install Android Studio and Android SDK
   - Set ANDROID_HOME environment variable
   - Make sure you have the required SDK platforms installed

4. **Build Failures**:
   - Clean the project: `Build` → `Clean Project`
   - Rebuild: `Build` → `Rebuild Project`
   - Check the build output for specific error messages

## Installation

Once you have the APK file:

1. **Enable Unknown Sources**:
   - Go to Settings → Security → Unknown Sources
   - Enable "Allow installation of apps from unknown sources"

2. **Install the APK**:
   - Transfer the APK to your Android device
   - Open the APK file on your device
   - Follow the installation prompts

3. **Launch the Game**:
   - Find "Tetris Game" in your app drawer
   - Tap to launch and start playing!

## Game Features

- **Classic Tetris Gameplay**: All 7 standard pieces
- **Touch Controls**: Easy-to-use buttons for movement and rotation
- **Scoring System**: Points based on lines cleared and level
- **Progressive Difficulty**: Speed increases with each level
- **Pause/Resume**: Stop and continue the game anytime
- **Game Over Detection**: Automatic restart option

## Support

If you encounter any issues:
1. Check the troubleshooting section above
2. Make sure all prerequisites are installed
3. Try building with Android Studio for the best experience
4. Check that your device runs Android 5.0 (API 21) or higher

Happy gaming! 🎮 