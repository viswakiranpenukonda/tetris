# Build APK Using Android Studio - Step by Step Guide

## 🎯 Why Android Studio?
Android Studio handles all Gradle setup automatically and avoids the permission issues you're experiencing. It's the most reliable way to build Android APKs.

## 📥 Step 1: Download Android Studio

1. **Go to**: https://developer.android.com/studio
2. **Click "Download Android Studio"**
3. **Choose Windows version** (64-bit recommended)
4. **Download the installer** (~1GB)

## 🔧 Step 2: Install Android Studio

1. **Run the installer** as Administrator
2. **Choose "Standard" installation** (recommended)
3. **Let it install**:
   - Android Studio
   - Android SDK
   - Android SDK Platform-Tools
   - Android Virtual Device
   - Performance (Intel HAXM)
4. **Click "Finish"** when done

## 🚀 Step 3: First Launch Setup

1. **Launch Android Studio**
2. **Complete the setup wizard**:
   - Choose "Standard" setup
   - Let it download additional components
   - Wait for all downloads to complete
3. **Click "Finish"** when setup is complete

## 📂 Step 4: Open Your Tetris Project

1. **In Android Studio**, click **"Open an existing Android Studio project"**
2. **Navigate to**: `C:\Ddrive\BitBucket\android_stuff`
3. **Select the folder** and click **"OK"**
4. **Wait for the project to sync** (this may take a few minutes)
5. **Click "Trust Project"** if prompted

## 🏗️ Step 5: Build the APK

### Method A: Build APK
1. **Go to menu**: `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
2. **Wait for build to complete**
3. **Click "locate"** in the notification when done

### Method B: Build and Run (if you have an Android device connected)
1. **Connect your Android device** via USB
2. **Enable USB debugging** on your device
3. **Click the green "Run" button** (▶️) in the toolbar
4. **Select your device** and click "OK"

## 📱 Step 6: Find Your APK

The APK will be located at:
```
C:\Ddrive\BitBucket\android_stuff\app\build\outputs\apk\debug\app-debug.apk
```

## 📲 Step 7: Install on Your Device

1. **Transfer the APK** to your Android device
2. **Enable "Unknown Sources"**:
   - Go to Settings → Security → Unknown Sources
   - Enable "Allow installation of apps from unknown sources"
3. **Open the APK file** on your device
4. **Follow installation prompts**

## 🎮 Step 8: Enjoy Your Game!

Launch the app and you'll see:
- **"VISWA'S CREATION"** splash screen with animations
- **Classic Tetris gameplay** with all 7 pieces
- **Touch controls** for movement and rotation
- **Scoring system** with progressive difficulty

## 🔧 Troubleshooting Android Studio

### If project sync fails:
1. **Check internet connection**
2. **Go to**: File → Invalidate Caches / Restart
3. **Click "Invalidate and Restart"**

### If build fails:
1. **Check the "Build" tab** at the bottom for error messages
2. **Try**: Build → Clean Project, then Build → Rebuild Project
3. **Make sure all files are present** in the project

### If device not detected:
1. **Enable Developer Options** on your device
2. **Enable USB Debugging**
3. **Install device drivers** if needed

## 📋 Project Features You'll See

- ✅ **Splash Screen**: "VISWA'S CREATION" with animations
- ✅ **Tetris Game**: All 7 classic pieces (I, O, T, S, Z, J, L)
- ✅ **Touch Controls**: Easy-to-use buttons
- ✅ **Scoring System**: Points and level progression
- ✅ **Pause/Resume**: Game control features
- ✅ **Modern UI**: Material Design interface

## 🎯 Alternative: Quick Build Commands

If you prefer command line, after installing Android Studio:

```cmd
# Set environment variables (Android Studio sets these automatically)
set ANDROID_HOME=C:\Users\YourUsername\AppData\Local\Android\Sdk
set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr

# Navigate to project
cd C:\Ddrive\BitBucket\android_stuff

# Build APK
.\gradlew.bat assembleDebug
```

## 🆘 Still Having Issues?

1. **Use Android Studio** (most reliable)
2. **Check Android Studio logs** for specific errors
3. **Make sure you have enough disk space** (at least 5GB free)
4. **Try on a different computer** if possible

## 🎉 Success!

Once you have the APK installed, you'll have a fully functional Tetris game with your "VISWA'S CREATION" branding!

Happy gaming! 🎮✨ 