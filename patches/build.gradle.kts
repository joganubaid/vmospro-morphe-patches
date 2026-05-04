group = "com.vmos.pro"

patches {
    about {
        name = "VMOS Pro Patches"
        description = "Patches to unlock VIP features in VMOS Pro"
        source = "git@github.com:joganubaid/vmospro-morphe-patches.git"
        author = "joganubaid"
        contact = "joganubaid@example.com"
        website = "https://github.com/joganubaid/vmospro-morphe-patches"
        license = "GPLv3"
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}

dependencies {
    implementation(libs.gson)
    implementation(libs.morphe.patches.library)
    compileOnly(project(":patches:stub"))
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("app.morphe.util.PatchListGeneratorKt")
    }
    publish {
        dependsOn("generatePatchesList")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}