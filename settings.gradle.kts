include(":base_theme")

val snapshotVersion : String? = System.getenv("COMPOSE_SNAPSHOT_ID")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.therouter.cn:8443/repository/maven-public/")
    }
}
rootProject.name = "TheRouterCompose"
include(":app")
include(":compose")
include(":compose-stub")
