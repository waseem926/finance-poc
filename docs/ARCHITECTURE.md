# POC Architecture — Splash Dashboard POC

Runnable Compose POC generated from your brief (3 screen(s): splash, dashboard, expenses).

**Figma:** https://www.figma.com/design/Ysn4BBvXbVvpBmmMC7nxBz/poc

**Requirements:** AI Finance app , create , Splash screen show for 3 sex then create Dashboard , Expenses and Analytics screens with proper navigation


## Screens (executed)


- **Splash** (`splash`) — Splash screen from brief

- **Dashboard** (`dashboard`) — Dashboard screen from brief

- **Expenses** (`expenses`) — Expenses screen from brief


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

- `features/dashboard` (feature) — Dashboard screen from brief

- `features/expenses` (feature) — Expenses screen from brief


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
