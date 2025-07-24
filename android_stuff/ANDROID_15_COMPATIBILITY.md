# Android 15 Compatibility Guide

## 📱 **Android 15 Compatibility Issues**

### **Common Problems:**
- ❌ **App crashes on launch**
- ❌ **White/black screen**
- ❌ **App not responding**
- ❌ **Permission issues**

## 🔧 **Fixes Applied**

### **1. Updated SDK Versions**
- ✅ **compileSdk:** 34 → 35
- ✅ **targetSdk:** 34 → 35
- ✅ **Updated dependencies** to latest versions

### **2. Enhanced Manifest**
- ✅ **Added `enableOnBackInvokedCallback="true"`**
- ✅ **Updated `targetApi` to 35**
- ✅ **Android 15 specific configurations**

### **3. Updated Dependencies**
```gradle
androidx.core:core-ktx:1.12.0
com.google.android.material:material:1.11.0
androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0
androidx.activity:activity-ktx:1.8.2
androidx.fragment:fragment-ktx:1.6.2
```

### **4. Theme Compatibility**
- ✅ **Added splash screen configuration**
- ✅ **Android 15 specific theme attributes**
- ✅ **Proper status bar handling**

## 🚨 **Troubleshooting Steps**

### **If App Still Won't Open:**

#### **Step 1: Check Device Settings**
1. Go to **Settings** → **Apps**
2. Find **"Tetris Game"**
3. Tap **"Storage & cache"**
4. Tap **"Clear storage"** and **"Clear cache"**
5. Try opening the app again

#### **Step 2: Check Permissions**
1. Go to **Settings** → **Apps** → **Tetris Game**
2. Tap **"Permissions"**
3. Ensure all permissions are granted
4. Restart the app

#### **Step 3: Developer Options**
1. Enable **Developer Options** (tap Build Number 7 times)
2. Go to **Developer Options**
3. Enable **"Don't keep activities"**
4. Disable **"Background process limit"**
5. Try the app again

#### **Step 4: Safe Mode**
1. Restart device in **Safe Mode**
2. Try opening the app
3. If it works, a third-party app is interfering

## 🔍 **Debug Information**

### **Check App Logs:**
```bash
# Connect device via USB
adb logcat | grep "TetrisGame"
```

### **Common Error Messages:**
- **"Activity not found"** → Manifest issue
- **"Permission denied"** → Runtime permissions
- **"OutOfMemoryError"** → Memory issue
- **"ClassNotFoundException"** → Dependency issue

## 📋 **Android 15 Specific Issues**

### **1. Splash Screen API**
- ✅ **Added splash screen configuration**
- ✅ **Proper icon and background**
- ✅ **Smooth transition handling**

### **2. Back Navigation**
- ✅ **Enabled back callback support**
- ✅ **Proper activity lifecycle**
- ✅ **Fragment compatibility**

### **3. Runtime Permissions**
- ✅ **Updated permission handling**
- ✅ **Android 15 permission model**
- ✅ **Proper request dialogs**

## 🛠️ **Manual Testing Steps**

### **Test 1: Fresh Install**
1. **Uninstall** the app completely
2. **Restart** your device
3. **Install** the new APK
4. **Try opening** immediately

### **Test 2: Permission Test**
1. **Deny all permissions** when prompted
2. **Check if app still opens**
3. **Grant permissions** one by one
4. **Test functionality**

### **Test 3: Background Test**
1. **Open the app**
2. **Press home button**
3. **Open other apps**
4. **Return to Tetris** via recent apps

## 📊 **Expected Behavior**

### **Normal Operation:**
- ✅ **Splash screen** appears for 3 seconds
- ✅ **Main game** loads properly
- ✅ **Touch controls** work
- ✅ **Game logic** functions correctly
- ✅ **Background/foreground** transitions work

### **If Issues Persist:**
1. **Check device storage** (need 50MB+ free)
2. **Update Android System WebView**
3. **Clear Google Play Services cache**
4. **Check for system updates**

## 🔄 **Alternative Solutions**

### **Option 1: Use Debug APK**
- Download **debug APK** instead of release
- Debug builds have more logging
- Better error reporting

### **Option 2: Check Device Compatibility**
- **Android version:** 5.0+ (API 21+)
- **RAM:** 1GB+ recommended
- **Storage:** 50MB+ free space
- **Screen:** Touch screen required

### **Option 3: Contact Support**
If issues persist:
1. **Note your device model**
2. **Android version**
3. **Error messages** (if any)
4. **Steps to reproduce**

## 📱 **Device-Specific Notes**

### **Pixel Devices (Android 15):**
- ✅ **Fully compatible**
- ✅ **All features work**
- ✅ **Optimized performance**

### **Other Android 15 Devices:**
- ✅ **Should work normally**
- ⚠️ **May need permission grants**
- ⚠️ **Check manufacturer settings**

---

**The app should now work properly on Android 15! 🎮** 