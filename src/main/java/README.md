# QlockTwo Word Clock - Usage Guide

## Overview

This program simulates the iconic **QlockTwo** word clock that displays time using illuminated words instead of traditional digits. The clock updates every minute and rounds to the nearest 5-minute interval, with minute dots showing the precise time.

## Features

- **Bilingual Support**: English and German language modes
- **Real-time Display**: Automatically updates every minute
- **Word Highlighting**: Illuminated words shown in blue brackets
- **Minute Dots**: Four dots below the grid show minutes between 5-minute intervals
- **Continuous Operation**: Runs indefinitely until manually stopped

## How to Run

### Compile and Execute

Run the Week11Lab class in IntelliJ IDEA to see the clock.

### Language Selection
When the program starts, you'll see:
```
press 1 or 2 to choose language: 1 = English, 2 = German
```

- Press `1` for English
- Press `2` for German 

## Understanding the Display

### English Grid Layout
```
ITLISASAMPM
ACQUARTERDC
TWENTYFIVEX
HALFSTENFTO
PASTERUNINE
ONESIXTHREE
FOURFIVETWO
EIGHTELEVEN
SEVENTWELVE
TENSEO'CLOCK
```

### German Grid Layout
```
ESKISTLFÜNF
ZEHNZWANZIG
DREIVIERTEL
TGNACHVORJM
HALBQZWÖLFP
ZWEINSIEBEN
KDREIRHFÜNF
ELFNEUNVIER
WACHTZEHNRS
BSECHSFMUHR
```

### Example Output

**English - 10:17**
```
Current time: 10:17:34
[IT][IS]ASAMPM
ACQUARTERDC
[TWENTY]FIVEX
HALFSTENFTO
[PAST]ERUNINE
ONESIXTHREE
FOURFIVETWO
EIGHTELEVEN
SEVENTWELVE
[TEN]SEO'CLOCK

Minute dots: ● ● ○ ○
```
**Reading**: "IT IS TWENTY PAST TEN" + 2 dots = 10:17

**German - 15:28**
```
Current time: 15:28:45
[ES][IST]LFÜNF
ZEHNZWANZIG
DREIVIERTEL
TGNACHVORJM
[HALB]QZWÖLFP
ZWEINSIEBEN
KD[DREI]RHFÜNF
ELFNEUNVIER
WACHTZEHNRS
BSECHSFMUHR

Minute dots: ● ● ● ○
```
**Reading**: "ES IST HALB DREI" + 3 dots = 15:28 (half past two = 2:30, rounded from 2:28)

## How the Clock Works

### Time Rounding
- Minutes are rounded to the nearest 5-minute interval
- **Example**: 10:17 → 10:15 ("Twenty Past Ten") + 2 dots

### Hour Adjustment
- For times using "TO" (English) or "VOR" (German), the hour advances by one
- **Example**: 10:47 → "Quarter To Eleven" (rounds to 10:45)

### Minute Dots
Four dots represent exact minutes within the 5-minute interval:
- **●** = Filled dot (lit)
- **○** = Empty dot (unlit)

| Actual Time | Rounded | Dots |
|-------------|---------|------|
| 10:16 | 10:15 | ● ○ ○ ○ |
| 10:17 | 10:15 | ● ● ○ ○ |
| 10:18 | 10:20 | ● ● ● ○ |
| 10:19 | 10:20 | ● ● ● ● |

### Word Highlighting
Highlighted words representing the current time appear in **blue brackets**: `[WORD]`

## Technical Details

- **Update Frequency**: Every 60 seconds
- **Time Precision**: Displays actual time with minute dots
- **12-Hour Format**: Both languages use 12-hour display
- **Auto-refresh**: Grid resets and updates automatically

