val detekt by configurations.creating

dependencies {
    detekt("io.gitlab.arturbosch.detekt:detekt-cli:1.18.1") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}

val detektVerification by tasks.creating(JavaExec::class) {
    description = "Check Kotlin code smells, code complexity based on detekt-config.yml."
    mainClass.set("io.gitlab.arturbosch.detekt.cli.Main")
    classpath = detekt
    val input = "$projectDir"
    val dir = "$rootDir/config/detekt"
    val config = "$dir/detekt-config.yml"
    val report = "xml:$buildDir/reports/detekt/detekt-checkstyle.xml"
    val params = listOf("-i", input, "-c", config, "-r", report)
    args = params
}