import com.android.build.api.dsl.LibraryBuildType
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Properties

private fun gradleSecretProperties(projectRootDir: File, fileName: String): Properties {
    val properties = Properties()
    val localProperties = File(projectRootDir, fileName)
    if (localProperties.isFile) {
        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    }
    return properties
}

fun LibraryBuildType.setBuildConfigSecurityKeyApiTmDb(rootDir: File, fileName: String = "secrets.properties") {
    val value = gradleSecretProperties(rootDir, fileName).getProperty("PROP_API_KEY_TMDB")
    buildConfigField("String", "API_KEY_TMDB", "\"$value\"")
}

fun LibraryBuildType.setBuildConfigBaseUrlApiTmDb() {
    buildConfigField("String", "BASE_URL_TMDB", "\"https://api.themoviedb.org/3/\"")
}