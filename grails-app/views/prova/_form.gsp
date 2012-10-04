<%@ page import="algosbase.Prova" %>



<div class="fieldcontain ${hasErrors(bean: provaInstance, field: 'testo3', 'error')} required">
	<label for="testo3">
		<g:message code="prova.testo3.label" default="Testo3" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="testo3" required="" value="${provaInstance?.testo3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: provaInstance, field: 'testo', 'error')} ">
	<label for="testo">
		<g:message code="prova.testo.label" default="Testo" />
		
	</label>
	<g:textField name="testo" value="${provaInstance?.testo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: provaInstance, field: 'testo2', 'error')} ">
	<label for="testo2">
		<g:message code="prova.testo2.label" default="Testo2" />
		
	</label>
	<g:textField name="testo2" value="${provaInstance?.testo2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: provaInstance, field: 'testo4', 'error')} ">
	<label for="testo4">
		<g:message code="prova.testo4.label" default="Testo4" />
		
	</label>
	<g:textField name="testo4" value="${provaInstance?.testo4}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: provaInstance, field: 'testo5', 'error')} ">
	<label for="testo5">
		<g:message code="prova.testo5.label" default="Testo5" />
		
	</label>
	<g:textField name="testo5" value="${provaInstance?.testo5}"/>
</div>

