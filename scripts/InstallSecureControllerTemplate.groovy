includeTargets << grailsScript("_GrailsInit")

boolean confirmAll = false

target(installSecureControllerTemplate: "Install the secure controller template.") {
	depends(checkVersion, parseArguments)

    // copy scaffolding files into project
    sourceDir = "${springSecurityRoleGeneratorPluginDir}/src/templates/"
    targetDir = "${basedir}/src/templates/"
    copy(sourceDir, targetDir, "scaffolding templates")
}

setDefaultTarget(installSecureControllerTemplate)

copy = {String source, String target, String confirmText ->
	boolean overwrite = confirmAll
	String input = ""

	// only if dir already exists in, ask to overwrite it
	if (new File(target).exists()) {
		// TODO: copy existing files / dirs into a "trash" directory
		if (isInteractive && !overwrite){
			input = grailsConsole.userInput('Overwrite '+confirmText+'? ', ["y","n","a"] as String[])
		}

		if (!isInteractive || input == "y" || input == "a" ){
			overwrite = true
		}

		if (input == "a"){
			confirmAll = true
		}
	}

	else {
		ant.mkdir(dir: target)
		overwrite = true	// nothing to overwrite but will be copied (state this in the event message)
	}

	if (new File(source).isDirectory()) {
		ant.copy(todir: "$target", overwrite: overwrite) {
			fileset dir:  "$source"
		}
	}
	else{
		ant.copy(todir: "$target", overwrite: overwrite)
		{ fileset file: "$source" }
	}

	event "StatusUpdate", ["... ${confirmText} ${overwrite ? '' : 'not '}installed!"]
}
