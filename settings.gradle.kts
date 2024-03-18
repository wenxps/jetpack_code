pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/google")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/google")
        }
        maven {
            url = uri("https://maven.aliyun.com/nexus/content/repositories/gradle-plugin")
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "JetPack_code"
include(":app")

include(":common")
include(":study")
include(":login")
include(":home")
include(":course")
include(":mine")
