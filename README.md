# TimerLib
A bukkit plugin that serves as a developer library providing timing events with reasonable accuracy. 
The events have sub 5 minute precision (compared to real-time accuracy) with the event triggers accounting for lag.

The plugin also directly bundles [Aikar's TaskChain](https://github.com/aikar/TaskChain) which other plugins can utilize.
NOTE: This is not the recommended way to bundle TaskChain. Modern plugins looking to use TaskChain
should directly shade it in and relocate it. This exists purely for legacy purposes.

## Building
This is a standard Gradle project and can be built via `gradle shadowJar` (or use `./gradlew shadowJar` with Java 8).

## Archived
This project is archived and will not receive any features. Bugs may still be resolved, but there is no gurantee they will be resolved in a timely fashion. Pull-requests related to features / bugs are welcome.

# Developers
Silverwolfg11