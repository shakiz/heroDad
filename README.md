# Baby Kick Count Tracker

A calm, privacy-respectful, and father-first mobile application built with **Jetpack Compose** to help expectant parents track baby movements, reflect on patterns, and build confidence during pregnancy—without medical interpretation or alerts.

---

## Product Vision

Baby Kick Count Tracker is designed to be:

- Fast during active sessions  
- Emotionally calming and non-alarming  
- Accessible with one hand  
- Medically respectful and non-diagnostic  
- Scalable toward health-adjacent compliance  

The app emphasizes trust, clarity, and pattern awareness rather than medical conclusions.

---

## Core Features

### Kick Counting Sessions
- Start and end timed kick-count sessions  
- One-tap kick recording (thumb-reachable)  
- Live counter and elapsed session timer  
- Optional haptic feedback  
- Accidental navigation prevention during sessions  

### Session Summary
- Total kicks  
- Session duration  
- Average kicks per minute  
- Optional notes (reflection-based, non-medical)  

### Home Screen
- Primary “Start Session” CTA  
- Recent session list (latest first)  
- Empty state with gentle guidance  
- Quick visual context for last activity  

### Dashboard & Insights
- Session history with filters:
  - Date range  
  - Kick count range  
  - Duration  
- Visualizations:
  - Line chart (kicks over time)  
  - Bar chart (sessions per day/week)  
- Pattern-based consistency insights (non-diagnostic)  
- Optional CSV export  

### Authentication
- Google Sign-In  
- Secure user profile initialization  
- Designed for Firebase or custom backend  

### Accessibility & Usability
- Dark mode  
- Large text / accessibility mode  
- Large touch targets  
- Offline support for active sessions  
- Daily reminder toggle  
- Auto-pause warning for unusually long sessions  

### Supportive Content (Father-Focused)
- Pregnancy movement guidelines (non-clinical)  
- Helpful tips and educational materials  
- Calm, supportive language throughout  

---

## Technical Architecture

### Architecture Pattern
- Single-Activity architecture  
- MVVM  
- Unidirectional Data Flow  
- State hoisting


---

## Tech Stack

| Layer | Technology |
|------|-----------|
| UI | Jetpack Compose + Material 3 |
| Navigation | Compose Navigation |
| State Management | ViewModel + StateFlow |
| Authentication | Google Sign-In |
| Charts | Compose-friendly chart library |
| Persistence | Room (local), Firebase-ready |
| Theming | Material 3 + custom design tokens |
| Build System | Kotlin + Gradle |

---

## Navigation Structure

### Top-Level Destinations
- Home  
- Dashboard  
- Settings (optional but recommended)  

Navigation is managed using **Jetpack Compose Navigation** within a single activity.

---

## Screen Overview

### Home Screen
- Start Session CTA  
- Recent sessions list  
- Empty state guidance  

### Active Session Screen
- Large “Add Kick” button  
- Live kick counter  
- Elapsed session timer  
- End Session CTA  
- Navigation lock enabled  

### Session Summary Screen
- Post-session recap  
- Optional note input  
- “Back to Home” CTA  

### Dashboard Screen
- Charts and filters  
- Session history  
- Pattern-based insights (non-medical)  

### Settings Screen
- Dark mode toggle  
- Reminder toggle  
- Accessibility options  
- Data export  

