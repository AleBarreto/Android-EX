val ktlint by configurations.creating

dependencies {
    ktlint("com.pinterest:ktlint:0.42.1") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}

val ktlintVerification by tasks.creating(JavaExec::class){
    description = "Check Kotlin code style."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("!src/androidTest/**", "!src/test/**", "src/**/*.kt", "--reporter=plain", "--reporter=checkstyle,output=${buildDir}/reports/ktlint/ktlint-checkstyle.xml")
}