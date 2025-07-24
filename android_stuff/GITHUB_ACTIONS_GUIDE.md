# Build APK Using GitHub Actions - Step by Step

## 🎯 Why GitHub Actions?
- **Free** - No cost for public repositories
- **No local setup** - Bypasses all Windows permission issues
- **Reliable** - Uses Linux environment with proper permissions
- **Automatic** - Builds on every code push

## 📋 Step 1: Create GitHub Repository

1. **Go to**: https://github.com
2. **Sign in** or create account
3. **Click "New repository"**
4. **Name it**: `tetris-game` or `android-tetris`
5. **Make it Public** (free GitHub Actions)
6. **Click "Create repository"**

## 📤 Step 2: Upload Your Project

### Option A: Using GitHub Desktop (Easiest)
1. **Download GitHub Desktop**: https://desktop.github.com/
2. **Clone your repository**
3. **Copy all project files** to the repository folder
4. **Commit and push** to GitHub

### Option B: Using Git Commands
```bash
# In your project directory
git init
git add .
git commit -m "Initial commit - Tetris game with VISWA'S CREATION splash screen"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
git push -u origin main
```

### Option C: Using GitHub Web Interface
1. **Upload files** directly through GitHub web interface
2. **Drag and drop** all project files
3. **Commit** the changes

## 🚀 Step 3: Trigger the Build

1. **The workflow will run automatically** when you push code
2. **Or manually trigger**:
   - Go to your repository on GitHub
   - Click "Actions" tab
   - Click "Build Android APK" workflow
   - Click "Run workflow"

## 📱 Step 4: Download Your APK

1. **Go to Actions tab** in your repository
2. **Click on the latest workflow run**
3. **Scroll down** to "Artifacts"
4. **Click "tetris-game-apk"** to download
5. **Extract the ZIP file** to get your APK

## 📲 Step 5: Install on Your Device

1. **Transfer APK** to your Android device
2. **Enable "Unknown Sources"** in device settings
3. **Install the APK**
4. **Enjoy your Tetris game!**

## 🔧 Troubleshooting

### If workflow fails:
1. **Check the Actions tab** for error messages
2. **Make sure all files** are uploaded correctly
3. **Check the workflow file** is in `.github/workflows/build.yml`

### If APK doesn't work:
1. **Check device compatibility** (Android 5.0+)
2. **Enable USB debugging** for better error messages
3. **Try on different device**

## 🎮 What You'll Get

Your APK will include:
- ✅ **"VISWA'S CREATION"** splash screen with animations
- ✅ **Classic Tetris gameplay** with all 7 pieces
- ✅ **Touch controls** and scoring system
- ✅ **Professional branding** throughout

## 📞 Need Help?

1. **Check GitHub Actions documentation**
2. **Post issues** in your repository
3. **Contact GitHub support** if needed

## 🎉 Success!

Once the workflow completes successfully, you'll have a working APK that you can install on any Android device!

## 🔄 Continuous Updates

Every time you push changes to your repository, GitHub Actions will automatically build a new APK with your updates.

Happy building! 🚀 