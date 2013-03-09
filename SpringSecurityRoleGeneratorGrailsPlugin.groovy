class SpringSecurityRoleGeneratorGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Spring Security Role Generator Plugin" // Headline display name of the plugin
    def author = "Maurice Rogers"
    def authorEmail = "maurice@mauricerogers.com"
    def description = '''\
This plugin facilitates easier implementation of the spring security core plugin\'s annotated controllers.
It does this in two ways:

1.  It provides a controller template that can be used during scaffolding.
    This controller comes preconfigured with CREATE VIEW EDIT and DELETE annotations for the given class.

2.  To tie into the controller above a generate-roles script is provided that will generate the 
    statements to create the roles for each class.

    For each class supplied it will generate a CREATE, VIEW, EDIT and DELETE role.
    You can generate for all classes by passing "*" as the parameter following the grails convention.

        generate-roles "*"
        generate-roles com.sample.MyClass

    You can then take the generated statements and add it to your bootstrap for example.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/spring-security-role-generator"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "InfoWorks", url: "http://mauricerogers.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub", url: "https://github.com/cruzer45/spring-security-role-generator/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/cruzer45/spring-security-role-generator" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
