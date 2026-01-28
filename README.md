# Health Tracker Android App

An Android application for tracking daily health metrics including steps, water intake, and sleep hours. Built with modern Android development tools and architectural patterns.

## Overview

This app provides a simple interface for logging and monitoring daily health activities. All data is stored locally using Room database, ensuring privacy and offline functionality. The UI is built entirely with Jetpack Compose, following Material Design 3 guidelines.

## Features

- Track daily step count
- Log water consumption in liters
- Record sleep duration in hours
- View current day's metrics on dashboard
- Persistent local storage
- Clean, intuitive interface

## Technical Stack

**Language:** Kotlin

**UI:** Jetpack Compose with Material Design 3

**Architecture:** MVVM (Model-View-ViewModel)

**Database:** Room (SQLite)

**Async:** Kotlin Coroutines and Flow

**Navigation:** Navigation Compose

**Minimum SDK:** API 24 (Android 7.0)

**Target SDK:** API 36

## Project Structure

The project follows standard Android architecture patterns:
```
app/src/main/java/com/sourav/healthtracker/
├── data/
│   ├── local/          - Room database setup, entities, and DAO
│   ├── remote/         - Placeholder for future API integration
│   └── repository/     - Data access layer
├── ui/
│   ├── screens/        - Compose UI screens
│   ├── viewmodel/      - ViewModels for business logic
│   ├── navigation/     - Navigation configuration
│   └── theme/          - Material Design theming
└── MainActivity.kt     - Application entry point
```

## Architecture Details

The app implements MVVM architecture with the following components:

- **Data Layer:** Room database with DAO pattern for data access
- **Repository:** Mediates between data sources and ViewModels
- **ViewModel:** Manages UI state using StateFlow
- **UI Layer:** Compose screens that observe ViewModel state

Data flows unidirectionally from the database through the repository and ViewModel to the UI. User actions trigger ViewModel methods that update the database, which then emits new state to the UI through Flow.

## Setup and Installation

### Requirements

- Android Studio Ladybug (2024.2.1) or newer
- JDK 11 or higher
- Android SDK with API 24 or higher

### Build Instructions

1. Clone the repository:
```bash
git clone https://github.com/sorv2k/HealthTrackerApp.git
```

2. Open the project in Android Studio

3. Wait for Gradle sync to complete

4. Connect an Android device or start an emulator

5. Click Run or use Shift+F10

The app should build and install on your device.

## Usage

The app opens to a dashboard showing today's metrics. Tap any metric card to enter or update values. Changes are saved immediately to the local database. Data persists between app sessions.

## Implementation Notes

**Database Schema:** Single table storing daily metrics with auto-generated primary keys and timestamps. Each date has one record that gets updated when new values are entered.

**State Management:** ViewModels expose StateFlow that UI screens collect. This provides reactive updates when data changes.

**Compose UI:** All screens built with Compose functions. No XML layouts. Material Design 3 components used throughout for consistency.

**Coroutines:** Database operations run on background threads using Kotlin coroutines with proper exception handling.

## Possible Improvements

- Add charts to visualize trends over time
- Implement weekly and monthly statistics
- Add goals and progress tracking
- Support for multiple users
- Data export functionality
- Cloud backup with REST API
- Widget for home screen
- Dark theme support

## Testing

The project structure supports unit testing for ViewModels and repositories, and UI testing with Compose testing library. Tests can be added in the `test/` and `androidTest/` directories.

## Dependencies

Key dependencies used:
- Jetpack Compose BOM 2024.12.01
- Room 2.6.1
- Navigation Compose 2.8.5
- Lifecycle ViewModel Compose 2.8.7
- Kotlin Coroutines 1.9.0
- Material Icons Extended

## License

MIT License - see LICENSE file for details