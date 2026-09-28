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
rootProject.name = "splash-expenses-poc"
include(
    ":app",
    ":core:common",
    ":core:network",
    ":core:database",
    ":core:ui",
    ":features:splash",
    ":features:expenses",
    ":features:analytics",
)