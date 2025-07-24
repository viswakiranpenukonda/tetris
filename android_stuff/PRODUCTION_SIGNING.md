# Production APK Signing Guide

## 🔐 **Production Signing Setup**

### **Why Production Signing?**
- 🔒 **Security:** Prevents APK tampering
- 📱 **Installation:** Required for app stores
- 🔄 **Updates:** Enables app updates
- 🛡️ **Trust:** Users trust signed apps

## 📋 **Step-by-Step Production Signing**

### **Step 1: Generate Production Keystore**
```bash
# Generate a production keystore
keytool -genkey -v \
  -keystore tetris-release-key.keystore \
  -alias tetris-key \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -storepass YOUR_STRONG_PASSWORD \
  -keypass YOUR_STRONG_PASSWORD \
  -dname "CN=Tetris Game, OU=Development, O=Your Company, L=Your City, S=Your State, C=US"
```

### **Step 2: Update build.gradle**
```gradle
android {
    signingConfigs {
        release {
            storeFile file('tetris-release-key.keystore')
            storePassword 'YOUR_STRONG_PASSWORD'
            keyAlias 'tetris-key'
            keyPassword 'YOUR_STRONG_PASSWORD'
        }
    }
    
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

### **Step 3: Secure Keystore Storage**
```bash
# Store keystore securely
# Option 1: Local secure location
mkdir -p ~/.android/keystores/
cp tetris-release-key.keystore ~/.android/keystores/

# Option 2: Use environment variables
export TETRIS_KEYSTORE_PASSWORD="your_password"
export TETRIS_KEY_PASSWORD="your_password"
```

## 🔒 **GitHub Actions Production Signing**

### **Using GitHub Secrets:**
1. Go to your repository **Settings** → **Secrets and variables** → **Actions**
2. Add these secrets:
   - `KEYSTORE_FILE` (base64 encoded keystore)
   - `KEYSTORE_PASSWORD`
   - `KEY_ALIAS`
   - `KEY_PASSWORD`

### **Updated Workflow:**
```yaml
- name: Setup Production Signing
  run: |
    echo "${{ secrets.KEYSTORE_FILE }}" | base64 -d > android_stuff/app/release-key.keystore
    
- name: Build Release APK
  run: |
    cd android_stuff
    ./gradlew assembleRelease \
      -PstorePassword="${{ secrets.KEYSTORE_PASSWORD }}" \
      -PkeyAlias="${{ secrets.KEY_ALIAS }}" \
      -PkeyPassword="${{ secrets.KEY_PASSWORD }}"
```

## 📊 **Signature Verification Commands**

### **Verify Production APK:**
```bash
# Basic verification
jarsigner -verify -verbose -certs app-release.apk

# Detailed verification
apksigner verify --verbose app-release.apk

# Certificate details
keytool -printcert -jarfile app-release.apk
```

### **Expected Output:**
```
Verifies
Verified using v1 scheme (JAR signing): true
Verified using v2 scheme (APK Signature Scheme v2): true
Verified using v3 scheme (APK Signature Scheme v3): true
Number of signers: 1
```

## 🛡️ **Security Best Practices**

### **Keystore Security:**
- 🔐 **Strong passwords** (16+ characters)
- 📍 **Secure storage** (encrypted location)
- 🔄 **Regular backups** (multiple locations)
- 🚫 **Never commit** keystore to git

### **Password Requirements:**
- **Uppercase letters:** A-Z
- **Lowercase letters:** a-z
- **Numbers:** 0-9
- **Special characters:** !@#$%^&*
- **Length:** 16+ characters

## 📱 **App Store Requirements**

### **Google Play Store:**
- ✅ **Production signing** required
- ✅ **App Bundle** recommended (AAB format)
- ✅ **Google Play App Signing** (optional but recommended)

### **Other Stores:**
- ✅ **Production signing** required
- ✅ **APK format** accepted
- ✅ **Signature verification** performed

## 🔧 **Current vs Production Signing**

### **Current (Debug):**
- 🔓 **Debug certificate**
- ⚠️ **Less secure**
- 🧪 **For testing only**
- 📱 **Works on all devices**

### **Production:**
- 🔒 **Release certificate**
- 🛡️ **Highly secure**
- 🏪 **Store-ready**
- 📱 **Works on all devices**

## 📋 **Migration Checklist**

### **Before Production:**
- [ ] Generate production keystore
- [ ] Update build.gradle
- [ ] Test signing process
- [ ] Verify APK signature
- [ ] Store keystore securely
- [ ] Document passwords safely

### **After Production:**
- [ ] Build release APK
- [ ] Verify signature
- [ ] Test installation
- [ ] Upload to store
- [ ] Monitor for issues

## 🚨 **Important Warnings**

### **Never:**
- ❌ Share keystore passwords
- ❌ Commit keystore to git
- ❌ Use debug signing for production
- ❌ Lose keystore backup

### **Always:**
- ✅ Keep keystore secure
- ✅ Use strong passwords
- ✅ Backup keystore
- ✅ Test before release

---

**Your APK will be production-ready with proper signing! 🔐** 