<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.acme.business.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.acme.model.*"%>
<%@page import="br.com.acme.dao.*"%>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Dashboard">


	<jsp:attribute name="content">
		<section class="content">
			<div align="center" style="margin-top: 300px; color: red;">
				<h4><strong>Upsss !!! Página não encontrada, favor contactar o administrador do sistema. </strong></h4>
				<h2><a href="${pageContext.request.contextPath}/admin/usuarios?action=list">Voltar...</a></li></h2>
			</div>
		</section>
	</jsp:attribute>
</mt:admin_tamplate>
