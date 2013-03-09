@artifact.package@

import grails.plugins.springsecurity.Secured

@Secured('IS_AUTHENTICATED_REMEMBERED')
class @artifact.name@ {

	@Secured('ROLE_VIEW_${className.toUpperCase()}')
    def index() { }
}
