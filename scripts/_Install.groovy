//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//
event "StatusFinal", ["To install Spring Security Role Generator run the script 'generate-roles' \n
						(e.g., on command line 'grails generate-roles')!\n
						Copy the output to your Bootstrap file."]