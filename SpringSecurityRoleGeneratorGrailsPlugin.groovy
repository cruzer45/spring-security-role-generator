class SpringSecurityRoleGeneratorGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def title = "Spring Security Role Generator Plugin"
    def author = "Maurice Rogers"
    def authorEmail = "maurice@mauricerogers.com"
    def description = '''\
This plugin facilitates easier implementation of the spring security core plugin's annotated controllers.
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

    def documentation = "http://grails.org/plugin/spring-security-role-generator"

    def license = "APACHE"
    def organization = [ name: "InfoWorks", url: "http://mauricerogers.com/" ]
    def issueManagement = [ system: "GitHub", url: "https://github.com/cruzer45/spring-security-role-generator/issues" ]
    def scm = [ url: "https://github.com/cruzer45/spring-security-role-generator" ]
}
