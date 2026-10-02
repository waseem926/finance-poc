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
rootProject.name = "ai-finance-poc"
include(
    ":app",
    ":core:common",
    ":core:network",
    ":core:database",
    ":core:ui",
    ":features:addexpense",
    ":features:analytics",
)