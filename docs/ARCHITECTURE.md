# POC Architecture — Splash Expenses POC

Runnable Compose POC generated from your brief (3 screen(s): splash, expenses, analytics).

**Figma:** https://www.figma.com/design/Ysn4BBvXbVvpBmmMC7nxBz/poc

**Requirements:** AI Finance App with Splash Screen for 3 sec , Add Expenses Screen  , Analytics Screen , History Screen and navigation in them


## Screens (executed)


- **Splash** (`splash`) — Splash screen from brief

- **Expenses** (`expenses`) — Expenses screen from brief

- **Analytics** (`analytics`) — Analytics screen from brief


## Design system (V3)

- Primary: `#8B5CF6`
- Spacing unit: 8dp
- Corner radius: 16dp
- Notes: Imported from Figma file_content

Shared components live in `core:ui` (`PocTopBar`, `PocListCard`, loading/empty/error).

## Modules


- `app` (app) — Shell + navigation

- `core/common` (core) — Shared primitives

- `core/ui` (core) — Design system

- `features/splash` (feature) — Splash screen from brief

- `features/expenses` (feature) — Expenses screen from brief

- `features/analytics` (feature) — Analytics screen from brief


## Data flow

```mermaid
flowchart LR
  UI-->VM
  VM-->UC
  UC-->Repo
  Repo-->Local
```

## Tech


- **di:** Hilt

- **ui:** Jetpack Compose+Material3

- **navigation:** Navigation Compose

- **async:** Coroutines+StateFlow

- **planning:** brief-driven (no LLM)
