# Android Tetris Game

A complete Android Tetris game implementation built with Kotlin and Android Jetpack components.

## Features

- **Splash Screen**: "VISWA'S CREATION" loading screen with animations
- Classic Tetris gameplay with all 7 standard pieces (I, O, T, S, Z, J, L)
- Smooth piece rotation and movement
- Line clearing with score calculation
- Progressive difficulty (speed increases with level)
- Pause/resume functionality
- Game over detection and restart
- Modern Material Design UI
- Portrait orientation optimized

## Game Controls

- **Left/Right Arrows**: Move piece horizontally
- **Rotate Button**: Rotate the current piece
- **Drop Button**: Instantly drop the piece to the bottom
- **Pause/Resume Button**: Pause or resume the game
- **New Game Button**: Start a new game after game over

## Scoring System

- 100 points per line cleared × current level
- Level increases every 10 lines cleared
- Game speed increases with each level

## Technical Details

### Architecture
- **MVVM Pattern**: Uses ViewModel and LiveData for state management
- **Custom View**: TetrisView for rendering the game board
- **Coroutines**: For game loop and timing management
- **View Binding**: For safe view access

### Key Components

1. **SplashActivity**: Loading screen with "VISWA'S CREATION" branding
2. **MainActivity**: Main game activity with UI controls
3. **GameViewModel**: Manages game state and logic
4. **TetrisView**: Custom view for rendering the game board
5. **TetrisPiece**: Data class representing Tetris pieces with rotation logic

## Building the Project

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 21 or higher
- Java 8 or higher

### Build Steps

1. **Clone or download the project**
2. **Open in Android Studio**
3. **Sync Gradle files**
4. **Build the project**: `Build > Make Project`
5. **Run on device/emulator**: `Run > Run 'app'`

### Command Line Build

```bash
# On Windows
gradlew.bat assembleDebug

# On Unix/Linux/macOS
./gradlew assembleDebug
```

The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

## Installation

1. Enable "Unknown Sources" in your Android device settings
2. Transfer the APK to your device
3. Install the APK file
4. Launch the Tetris game

## Project Structure

```
android_stuff/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/tetrisgame/
│   │   │   ├── MainActivity.kt
│   │   │   ├── GameViewModel.kt
│   │   │   ├── TetrisView.kt
│   │   │   └── TetrisPiece.kt
│   │   ├── res/
│   │   │   ├── layout/activity_main.xml
│   │   │   ├── values/colors.xml
│   │   │   ├── values/strings.xml
│   │   │   ├── values/themes.xml
│   │   │   └── drawable/button_background.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── README.md
```

## Customization

### Colors
Edit `app/src/main/res/values/colors.xml` to change the game's color scheme.

### Game Speed
Modify the `dropSpeed` variable in `GameViewModel.kt` to adjust initial game speed.

### Board Size
Change the board dimensions in `GameViewModel.kt` and `TetrisView.kt` (currently 20x10).

## Troubleshooting

### Build Issues
- Ensure Android SDK is properly installed
- Check that Gradle wrapper is executable (`chmod +x gradlew` on Unix systems)
- Clean and rebuild the project

### Runtime Issues
- Ensure device has Android 5.0 (API 21) or higher
- Check that device has sufficient memory for the game

## License

This project is open source and available under the MIT License.

## Contributing

Feel free to submit issues, feature requests, or pull requests to improve the game! 