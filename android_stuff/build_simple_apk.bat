@echo off
echo ========================================
echo Simple APK Builder - Multiple Methods
echo ========================================
echo.

REM Check if running as administrator
net session >nul 2>&1
if %errorLevel% == 0 (
    echo Running as Administrator - Good!
) else (
    echo WARNING: Not running as Administrator
    echo This might cause permission issues
    echo.
)

echo Trying multiple build methods...
echo.

REM Method 1: Try with custom Gradle home
echo Method 1: Custom Gradle Home
set GRADLE_USER_HOME=C:\gradle-home
call gradlew.bat assembleDebug
if %ERRORLEVEL% equ 0 goto success

echo Method 1 failed, trying Method 2...
echo.

REM Method 2: Try with different Gradle version
echo Method 2: Different Gradle Version
set GRADLE_USER_HOME=C:\gradle-home-alt
if not exist "C:\gradle-home-alt" mkdir "C:\gradle-home-alt"
call gradlew.bat assembleDebug
if %ERRORLEVEL% equ 0 goto success

echo Method 2 failed, trying Method 3...
echo.

REM Method 3: Try with offline mode
echo Method 3: Offline Mode
set GRADLE_USER_HOME=C:\gradle-home
call gradlew.bat assembleDebug --offline
if %ERRORLEVEL% equ 0 goto success

echo Method 3 failed, trying Method 4...
echo.

REM Method 4: Try with no daemon
echo Method 4: No Daemon
set GRADLE_USER_HOME=C:\gradle-home
call gradlew.bat assembleDebug --no-daemon
if %ERRORLEVEL% equ 0 goto success

echo.
echo ========================================
echo All methods failed!
echo ========================================
echo.
echo The Gradle permission issues are persistent.
echo.
echo Recommended solutions:
echo 1. Use GitHub Actions (free, online build)
echo 2. Try on a different computer
echo 3. Use Android Studio with different settings
echo 4. Contact a local developer for help
echo.
echo See EMERGENCY_BUILD_SOLUTION.md for more options.
echo.
pause
exit /b 1

:success
echo.
echo ========================================
echo BUILD SUCCESSFUL!
echo ========================================
echo.
echo APK location: app\build\outputs\apk\debug\app-debug.apk
echo.
echo You can now install this APK on your Android device.
echo Make sure to enable "Unknown Sources" in your device settings.
echo.
echo Your Tetris game with "VISWA'S CREATION" splash screen is ready!
echo.
pause 