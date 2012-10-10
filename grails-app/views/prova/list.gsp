
<%@ page import="algosbase.Prova" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prova.label', default: 'Prova')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-prova" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-prova" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="id" title="${message(code: 'prova.id.label', default: 'Id')}" />
					
						<g:sortableColumn property="testo3" title="${message(code: 'prova.testo3.label', default: 'Testo3')}" />
					
						<g:sortableColumn property="testo" title="${message(code: 'prova.testo.label', default: 'Testo')}" />
					
						<g:sortableColumn property="testo2" title="${message(code: 'prova.testo2.label', default: 'Testo2')}" />
					
						<g:sortableColumn property="testo4" title="${message(code: 'prova.testo4.label', default: 'Testo4')}" />
					
						<g:sortableColumn property="testo5" title="${message(code: 'prova.testo5.label', default: 'Testo5')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${provaInstanceList}" status="i" var="provaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "id")}</g:link></td>
					
                        <td><g:link action="show"
                                    id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "testo3")}</g:link></td>
                        
                        <td><g:link action="show"
                                    id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "testo")}</g:link></td>
                        
                        <td><g:link action="show"
                                    id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "testo2")}</g:link></td>
                        
                        <td><g:link action="show"
                                    id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "testo4")}</g:link></td>
                        
                        <td><g:link action="show"
                                    id="${provaInstance.id}">${fieldValue(bean: provaInstance, field: "testo5")}</g:link></td>
                        
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${provaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
