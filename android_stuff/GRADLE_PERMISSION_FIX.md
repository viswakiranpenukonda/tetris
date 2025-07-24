# Fix Gradle Permission Issues on Windows

## 🚨 Problem
```
Could not install Gradle distribution from 'https://services.gradle.org/distributions/gradle-7.3.3-bin.zip'.
Reason: java.lang.RuntimeException: Could not create parent directory for lock file 
C:\Users\Viswakiran Penukonda\.gradle\wrapper\dists\gradle-7.3.3-bin\6a41zxkdtcxs8rphpq6y0069z\gradle-7.3.3-bin.zip.lck
```

## 🔧 Solutions (Try in Order)

### Solution 1: Run Permission Fix Script (Recommended)

1. **Right-click** on `fix_gradle_permissions.bat`
2. **Select "Run as administrator"**
3. **Follow the prompts**
4. **Try building again**: `.\gradlew.bat assembleDebug`

### Solution 2: Use Custom Gradle Home Directory

1. **Run the custom setup script**:
   ```cmd
   .\setup_custom_gradle.bat
   ```

2. **Then build the project**:
   ```cmd
   .\gradlew.bat assembleDebug
   ```

### Solution 3: Manual Permission Fix

1. **Open Command Prompt as Administrator**

2. **Create Gradle directories manually**:
   ```cmd
   mkdir "%USERPROFILE%\.gradle"
   mkdir "%USERPROFILE%\.gradle\wrapper"
   mkdir "%USERPROFILE%\.gradle\wrapper\dists"
   ```

3. **Set permissions**:
   ```cmd
   icacls "%USERPROFILE%\.gradle" /grant "%USERNAME%":(OI)(CI)F /T
   ```

4. **Clean lock files**:
   ```cmd
   del /q "%USERPROFILE%\.gradle\wrapper\dists\*.lck"
   ```

5. **Try building again**:
   ```cmd
   .\gradlew.bat assembleDebug
   ```

### Solution 4: Use Android Studio (Easiest)

1. **Open Android Studio**
2. **Open the project** (File → Open → select your `android_stuff` folder)
3. **Let it sync** (this will handle Gradle setup automatically)
4. **Build the APK** (Build → Build Bundle(s) / APK(s) → Build APK(s))

### Solution 5: Change Gradle Home Directory

1. **Set environment variable**:
   ```cmd
   set GRADLE_USER_HOME=C:\gradle-home
   ```

2. **Create the directory**:
   ```cmd
   mkdir C:\gradle-home
   ```

3. **Try building**:
   ```cmd
   .\gradlew.bat assembleDebug
   ```

## 🎯 Quick Fix Commands

### Option A: Run as Administrator
```cmd
# Right-click Command Prompt → Run as Administrator
cd C:\Ddrive\BitBucket\android_stuff
.\fix_gradle_permissions.bat
.\gradlew.bat assembleDebug
```

### Option B: Use Custom Gradle Home
```cmd
cd C:\Ddrive\BitBucket\android_stuff
.\setup_custom_gradle.bat
.\gradlew.bat assembleDebug
```

### Option C: Manual Fix
```cmd
# Run as Administrator
cd C:\Ddrive\BitBucket\android_stuff
mkdir "%USERPROFILE%\.gradle\wrapper\dists" 2>nul
del /q "%USERPROFILE%\.gradle\wrapper\dists\*.lck" 2>nul
.\gradlew.bat assembleDebug
```

## 🔍 Troubleshooting

### If still getting permission errors:

1. **Check antivirus software** - It might be blocking Gradle
2. **Disable Windows Defender** temporarily
3. **Run as Administrator** - Always try this first
4. **Use a different directory** - Set GRADLE_USER_HOME to C:\gradle-home
5. **Use Android Studio** - It handles these issues automatically

### Common Windows Issues:

1. **User Account Control (UAC)** - Run as Administrator
2. **Antivirus blocking** - Add exception for Gradle
3. **File system permissions** - Check folder permissions
4. **Network restrictions** - Check firewall/proxy settings

## 📱 Alternative: Use Android Studio

**This is the easiest solution:**

1. **Download Android Studio**: https://developer.android.com/studio
2. **Install it** (includes Java and Android SDK)
3. **Open the project** in Android Studio
4. **Build the APK** using the IDE

Android Studio handles all Gradle setup automatically and avoids these permission issues.

## ✅ Success Indicators

When the fix works, you should see:
```
BUILD SUCCESSFUL in X seconds
APK location: app\build\outputs\apk\debug\app-debug.apk
```

## 🆘 Still Having Issues?

If none of the above solutions work:

1. **Use Android Studio** (recommended)
2. **Check Windows Event Viewer** for permission errors
3. **Try on a different Windows user account**
4. **Contact system administrator** for permission issues

## 🎮 After Building

Once you have the APK:
1. **Transfer to Android device**
2. **Enable "Unknown Sources"** in device settings
3. **Install the APK**
4. **Enjoy your Tetris game with "VISWA'S CREATION" splash screen!**

Happy building! 🚀 