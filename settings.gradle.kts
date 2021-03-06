dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "Android-EX"

include(":app")
include(":commons")
include(":features:featureA")
include(":features:featureB")
include(":navigation")
include(":network")
