Spring Security Role Generator
==============================

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


The controller template
-----------------------

The plugin provides a custom controller template with the annotations already in place.
you  can install it by running:

		install-secure-controller-template

This will copy the template into your src/templates folder.
You can further customize it from there.

For people that already have a custom controller template, you can easily add the annotations to your template. 
Following the same conventions you simply add the import:

		import grails.plugins.springsecurity.Secured

Then add the appropriate annotations to your methods from the list below.
		
		@Secured('ROLE_CREATE_${className.toUpperCase()}')
		@Secured('ROLE_VIEW_${className.toUpperCase()}')
		@Secured('ROLE_EDIT_${className.toUpperCase()}')
		@Secured('ROLE_DELETE_${className.toUpperCase()}')

Thats all it takes to secure your applications.
