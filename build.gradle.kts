plugins {
  id("java-library")
  alias(libs.plugins.kotlin) apply false
  alias(libs.plugins.nexusPlugin)
}
tasks.withType<Javadoc>().configureEach {
  (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

apply("$rootDir/gradle/java_base.gradle")
apply("$rootDir/gradle/java_publish.gradle")
group = properties["PROJ_GROUP"].toString()
version = properties["PROJ_VERSION"].toString()
nexusPublishing {
  repositories {
    create("Nexus") {
      nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
      snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
      username.set(properties["ossrhUsername"].toString())
      password.set(properties["ossrhPassword"].toString())
    }
  }
}
repositories {
  mavenCentral()

}


dependencies {
}
