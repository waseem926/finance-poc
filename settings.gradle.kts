pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "splash-analytics-poc"
include(
    ":app",
    ":core:common",
    ":core:network",
    ":core:database",
    ":core:ui",
    ":features:splash",
    ":features:analytics",
)