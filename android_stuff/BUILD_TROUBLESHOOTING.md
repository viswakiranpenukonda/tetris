# 🛠️ Build Troubleshooting Guide

This guide helps resolve common build issues in the GitHub Actions workflow.

## 🔍 **Common Build Issues & Solutions**

### **1. Android SDK 35 Not Available**
**Error:** `Failed to load resources table in APK '/usr/local/lib/android/sdk/platforms/android-35/android.jar'`

**Solution:** The workflow automatically falls back to SDK 34 if SDK 35 is not available.

### **2. Gradle Version Conflicts**
**Error:** `Unsupported class file major version 61`

**Solution:** 
- Updated Gradle wrapper to 8.4
- Updated Android Gradle Plugin to 8.3.0
- Updated Kotlin to 1.9.22

### **3. Dependency Resolution Issues**
**Error:** `Build was configured to prefer settings repositories over project repositories`

**Solution:**
- Repositories are now defined in `settings.gradle`
- Removed `allprojects` block from top-level `build.gradle`

### **4. Java Version Issues**
**Error:** `UnsupportedClassVersionError: class file version 61.0`

**Solution:**
- Using JDK 17 in GitHub Actions
- Updated all dependencies to latest versions

### **5. APK Signing Issues**
**Error:** `keytool error: java.security.KeyStoreException: Unrecognized keystore format`

**Solution:**
- Automatic debug keystore generation in workflow
- Proper keystore verification steps

## 🚀 **Build Process Steps**

### **Phase 1: Environment Setup**
1. ✅ Checkout code
2. ✅ Setup JDK 17
3. ✅ Setup Android SDK 34
4. ✅ Install Android SDK Platform 35 (with fallback)

### **Phase 2: Build Preparation**
1. ✅ Verify gradlew permissions
2. ✅ Clear Gradle cache
3. ✅ Update Gradle wrapper
4. ✅ Generate debug keystore
5. ✅ Check available SDK platforms
6. ✅ Check dependencies

### **Phase 3: Build Execution**
1. ✅ Clean project
2. ✅ Build Debug APK (with SDK 35 fallback)
3. ✅ Build Release APK (with SDK 35 fallback)
4. ✅ Verify APK signatures

### **Phase 4: Artifact Upload**
1. ✅ Upload Debug APK
2. ✅ Upload Release APK
3. ✅ Create GitHub Release (if on main branch)

## 🔧 **Manual Build Commands**

If you need to build locally:

```bash
# Navigate to android directory
cd android_stuff

# Clean project
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Check dependencies
./gradlew app:dependencies

# Update Gradle wrapper
./gradlew wrapper --gradle-version=8.4
```

## 📱 **Android 15 Compatibility**

The app is configured for Android 15 with:
- ✅ `compileSdk 35` and `targetSdk 35`
- ✅ `enableOnBackInvokedCallback="true"`
- ✅ Material3 themes
- ✅ Latest androidx dependencies
- ✅ Splash screen API integration

## 🛡️ **Fallback Mechanisms**

The workflow includes several fallback mechanisms:

1. **SDK Fallback:** If Android SDK 35 fails, automatically uses SDK 34
2. **Gradle Fallback:** If build fails, temporarily modifies build.gradle
3. **Dependency Fallback:** Uses latest stable versions with compatibility checks

## 📊 **Build Status Monitoring**

Monitor build status:
1. Go to GitHub repository
2. Click "Actions" tab
3. Check latest workflow run
4. Review logs for specific errors

## 🆘 **Getting Help**

If builds continue to fail:

1. **Check GitHub Actions logs** for specific error messages
2. **Verify Android SDK installation** in the workflow
3. **Check dependency versions** for conflicts
4. **Review Gradle configuration** for syntax errors
5. **Test locally** with the same environment

## 🔄 **Workflow Triggers**

The workflow runs on:
- ✅ Push to `main` or `master` branch
- ✅ Pull requests to `main` or `master` branch
- ✅ Manual trigger from Actions tab

## 📋 **Pre-Build Checklist**

Before pushing code:
- ✅ All dependencies are up to date
- ✅ AndroidManifest.xml has correct configurations
- ✅ build.gradle files are properly configured
- ✅ No syntax errors in Kotlin/Java files
- ✅ Resource files are valid
- ✅ Gradle wrapper is executable

---

**Last Updated:** $(date)
**Build Status:** ✅ Optimized for reliability 