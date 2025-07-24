# Windows Build Guide - Android Tetris Game

## 🚨 Current Issue
The build is failing because the required development environment is not set up. Here's how to fix it:

## 📋 Prerequisites Installation

### 1. Install Java Development Kit (JDK)

**Option A: Download from Adoptium (Recommended)**
1. Go to: https://adoptium.net/
2. Download "Eclipse Temurin" for Windows x64
3. Run the installer and follow the setup
4. **Important**: Check "Add to PATH" during installation

**Option B: Download from Oracle**
1. Go to: https://www.oracle.com/java/technologies/downloads/
2. Download JDK 8 or higher for Windows
3. Run the installer

**Verify Java Installation:**
```cmd
java -version
javac -version
```

### 2. Install Android Studio

1. **Download Android Studio:**
   - Go to: https://developer.android.com/studio
   - Download the latest version for Windows

2. **Install Android Studio:**
   - Run the installer
   - Choose "Standard" installation
   - Let it install Android SDK automatically

3. **First Launch Setup:**
   - Open Android Studio
   - Complete the setup wizard
   - Install any additional SDK components it suggests

## 🔧 Environment Setup

### Set Environment Variables

1. **Open System Properties:**
   - Right-click on "This PC" → Properties
   - Click "Advanced system settings"
   - Click "Environment Variables"

2. **Set JAVA_HOME:**
   - Under "System Variables" click "New"
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Eclipse Adoptium\jdk-8.0.xxx-hotspot` (or your Java installation path)

3. **Set ANDROID_HOME:**
   - Under "System Variables" click "New"
   - Variable name: `ANDROID_HOME`
   - Variable value: `C:\Users\YourUsername\AppData\Local\Android\Sdk` (or your Android SDK path)

4. **Add to PATH:**
   - Edit the "Path" variable under "System Variables"
   - Add: `%JAVA_HOME%\bin`
   - Add: `%ANDROID_HOME%\platform-tools`

5. **Restart Command Prompt/PowerShell** after setting variables

## 🏗️ Building the APK

### Method 1: Using Android Studio (Easiest)

1. **Open the Project:**
   - Launch Android Studio
   - Click "Open an existing Android Studio project"
   - Navigate to your `android_stuff` folder and select it
   - Wait for the project to sync

2. **Build the APK:**
   - Go to `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
   - Or press `Ctrl + F9` to build the project

3. **Find the APK:**
   - The APK will be at: `app\build\outputs\apk\debug\app-debug.apk`
   - Android Studio will show a notification when done

### Method 2: Using Command Line

1. **Open Command Prompt as Administrator:**
   - Right-click on Command Prompt
   - Select "Run as administrator"

2. **Navigate to your project:**
   ```cmd
   cd C:\Ddrive\BitBucket\android_stuff
   ```

3. **Run the build script:**
   ```cmd
   build_with_admin.bat
   ```

### Method 3: Manual Gradle Build

1. **Open Command Prompt as Administrator**

2. **Navigate to project:**
   ```cmd
   cd C:\Ddrive\BitBucket\android_stuff
   ```

3. **Build the APK:**
   ```cmd
   gradlew.bat assembleDebug
   ```

## 📱 Installing the APK

1. **Enable Unknown Sources:**
   - Go to Settings → Security → Unknown Sources
   - Enable "Allow installation of apps from unknown sources"

2. **Transfer APK to Device:**
   - Copy `app-debug.apk` to your Android device
   - Or use ADB: `adb install app-debug.apk`

3. **Install the APK:**
   - Open the APK file on your device
   - Follow the installation prompts

## 🎮 Game Features

Once installed, you'll see:
- **"VISWA'S CREATION"** splash screen with animations
- **Classic Tetris gameplay** with all 7 pieces
- **Touch controls** for movement and rotation
- **Scoring system** with progressive difficulty
- **Pause/resume** functionality

## 🔧 Troubleshooting

### Common Issues:

1. **"JAVA_HOME not set"**
   - Install Java JDK 8 or higher
   - Set JAVA_HOME environment variable
   - Restart command prompt

2. **"ANDROID_HOME not set"**
   - Install Android Studio and Android SDK
   - Set ANDROID_HOME environment variable
   - Restart command prompt

3. **"Permission denied"**
   - Run command prompt as Administrator
   - Check file permissions

4. **"Gradle wrapper issues"**
   - Use Android Studio instead
   - Or run as Administrator

5. **"Build failed"**
   - Check that all project files are present
   - Try cleaning and rebuilding
   - Use Android Studio for better error messages

### Quick Test:

After setting up the environment, test with:
```cmd
java -version
echo %JAVA_HOME%
echo %ANDROID_HOME%
```

## 🎯 Recommended Approach

**For the easiest experience:**
1. Install Android Studio
2. Open the project in Android Studio
3. Build using the IDE
4. Install the APK on your device

This avoids command line issues and provides better error reporting.

## 📞 Support

If you still have issues:
1. Make sure Java 8+ is installed and JAVA_HOME is set
2. Make sure Android Studio and SDK are installed
3. Try running as Administrator
4. Use Android Studio for the most reliable build experience

Happy building! 🎮 