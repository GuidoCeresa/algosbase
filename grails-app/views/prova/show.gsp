
<%@ page import="algosbase.Prova" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prova.label', default: 'Prova')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-prova" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-prova" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list prova">
			
				<g:if test="${provaInstance?.testo3}">
				<li class="fieldcontain">
					<span id="testo3-label" class="property-label"><g:message code="prova.testo3.label" default="Testo3" /></span>
					
						<span class="property-value" aria-labelledby="testo3-label"><g:fieldValue bean="${provaInstance}" field="testo3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${provaInstance?.testo}">
				<li class="fieldcontain">
					<span id="testo-label" class="property-label"><g:message code="prova.testo.label" default="Testo" /></span>
					
						<span class="property-value" aria-labelledby="testo-label"><g:fieldValue bean="${provaInstance}" field="testo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${provaInstance?.testo2}">
				<li class="fieldcontain">
					<span id="testo2-label" class="property-label"><g:message code="prova.testo2.label" default="Testo2" /></span>
					
						<span class="property-value" aria-labelledby="testo2-label"><g:fieldValue bean="${provaInstance}" field="testo2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${provaInstance?.testo4}">
				<li class="fieldcontain">
					<span id="testo4-label" class="property-label"><g:message code="prova.testo4.label" default="Testo4" /></span>
					
						<span class="property-value" aria-labelledby="testo4-label"><g:fieldValue bean="${provaInstance}" field="testo4"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${provaInstance?.testo5}">
				<li class="fieldcontain">
					<span id="testo5-label" class="property-label"><g:message code="prova.testo5.label" default="Testo5" /></span>
					
						<span class="property-value" aria-labelledby="testo5-label"><g:fieldValue bean="${provaInstance}" field="testo5"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${provaInstance?.id}" />
					<g:link class="edit" action="edit" id="${provaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
