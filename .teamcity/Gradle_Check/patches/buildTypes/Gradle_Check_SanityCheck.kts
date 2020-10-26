package Gradle_Check.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = 'Gradle_Check_SanityCheck' (id = 'Gradle_Check_SanityCheck')
accordingly, and delete the patch script.
*/
changeBuildType(uuid("Gradle_Check_SanityCheck")) {
    features {
        val feature1 = find<CommitStatusPublisher> {
            commitStatusPublisher {
                vcsRootExtId = "Gradle_Branches_GradlePersonalBranches"
                publisher = github {
                    githubUrl = "https://api.github.com"
                    authType = personalToken {
                        token = "%github.bot-gradle.token%"
                    }
                }
            }
        }
        feature1.apply {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:84268642-1010-4730-a7a7-a742f496b39b"
                }
            }
        }
        val feature2 = find<PullRequests> {
            pullRequests {
                vcsRootExtId = "Gradle_Branches_GradlePersonalBranches"
                provider = github {
                    authType = token {
                        token = "%github.bot-gradle.token%"
                    }
                    filterTargetBranch = """
                        +:*
                        -:<default>
                    """.trimIndent()
                    filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
                }
            }
        }
        feature2.apply {
            provider = github {
                serverUrl = ""
                authType = token {
                    token = "credentialsJSON:84268642-1010-4730-a7a7-a742f496b39b"
                }
                filterTargetBranch = """
                    +:*
                    -:<default>
                """.trimIndent()
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
}