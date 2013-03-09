import org.codehaus.groovy.grails.scaffolding.*
import grails.util.GrailsNameUtils

includeTargets << grailsScript("Init")
includeTargets << grailsScript("_GrailsBootstrap")
includeTargets << grailsScript("_GrailsCreateArtifacts")

generateForName = null

target(main: "This script will generate the security roles for all of your classes.") {
	depends(checkVersion, parseArguments, packageApp)
	promptForName(type: "Domain Class") 
	generateSecurityRoles()
}

setDefaultTarget(main)

target (generateSecurityRoles:"Generate the appropriate roles"){
	try {
		def name = argsMap["params"][0]
		if (!name || name == "*") {
			uberGenerate()
		}
		else {
			generateForName = name
			generateForOne()
		}
	}
	catch (Exception e) {
		logError("Error running generate-roles", e)
		exit(1)
	}
}


target(generateForOne: "Generates security roles for only one domain class") {
    depends(loadApp)

    def name = generateForName
    name = name.indexOf('.') > -1 ? name : GrailsNameUtils.getClassNameRepresentation(name)
    def domainClass = grailsApp.getDomainClass(name)

    if (!domainClass) {
        println "Domain class not found in grails-app/domain, trying hibernate mapped classes..."
        bootstrap()
        domainClass = grailsApp.getDomainClass(name)
    }

    if (domainClass) {
        generateForDomainClass(domainClass)
        event("StatusFinal", ["Finished generation for domain class ${domainClass.fullName}. Copy security roles to appropriate bootstrap file."])
    }
    else {
        event("StatusFinal", ["No domain class found for name ${name}. Please try again and enter a valid domain class name"])
    }
}

target(uberGenerate: "Generates security roles for all domain classes") {
    depends(loadApp)

    def domainClasses = grailsApp.domainClasses

    if (!domainClasses) {
        println "No domain classes found in grails-app/domain, trying hibernate mapped classes..."
        bootstrap()
        domainClasses = grailsApp.domainClasses
    }

   if (domainClasses) {
        domainClasses.each { domainClass ->
            generateForDomainClass(domainClass)
        }
        event("StatusFinal", ["Finished generation for domain classes. Copy security roles to appropriate bootstrap file."])
    }
    else {
        event("StatusFinal", ["No domain classes found"])
    }
}


def generateForDomainClass(domainClass) {
	def roleClass = grailsApp.config.grails.plugins.springsecurity.authority.className
    // print generic messages for this domain class
    println "// ${domainClass.shortName} security roles"
    println "println \"Building security roles for ${domainClass.fullName}\""
    println "new ${roleClass}(authority: 'ROLE_VIEW_${domainClass.shortName.toUpperCase()}').save(failOnError: true)"
    println "new ${roleClass}(authority: 'ROLE_CREATE_${domainClass.shortName.toUpperCase()}').save(failOnError: true)"
    println "new ${roleClass}(authority: 'ROLE_EDIT_${domainClass.shortName.toUpperCase()}').save(failOnError: true)"
    println "new ${roleClass}(authority: 'ROLE_DELETE_${domainClass.shortName.toUpperCase()}').save(failOnError: true)"
    println ""
}

