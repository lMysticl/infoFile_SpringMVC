<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Files List</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"/>
</head>

<body>

<div class="generic-container">

    <div class="panel panel-default">
        <div class="panel-heading color">
            <span class="lead">List of files </span>
            <div class="filter-group">
                <div class="col-sm-6 col-md-3">
                    <label for="filters">Filters</label>
                    <select id="filters" class="form-control" mame="filters" onchange="getFilesByCondition(this.options[this.selectedIndex].value)">
                        <option selected disabled hidden>Filter by...</option>
                        <option value="moreTenLines">Files with more than 10 lines</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="tablecontainer">
            <table class="table table-hover table-bordered" style="margin-bottom:0">
                <thead>
                <tr>
                    <th>File Name</th>
                    <th>Content</th>
                    <th width="200"></th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="statisticsFiles" scope="request" type="java.util.List"/>
                <c:forEach items="${statisticsFiles}" var="statFile">
                    <tr>
                        <td>${statFile.name}</td>
                        <td>${statFile.content}</td>
                        <td><a href="<c:url value='/get-statistics-${statFile.id}' />" class="btn btn-success custom-width">show statistics</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading color"><span class="lead">Upload text</span></div>
        <div class="uploadcontainer">
            <form:form method="POST" action="/upload-text" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm" placeholder="Enter file name" cssStyle="width: 250px; font-size: 16px!important; margin-bottom: 10px"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                            <form:textarea type="text" path="content" id="content" class="form-control input-sm" placeholder="Enter text"  cssStyle="min-height: 100px;font-size: 16px!important"/>
                            <div class="has-error">
                                <form:errors path="content" class="help-inline"/>
                            </div>
                            <div class="form-actions floatRight">
                                <input type="submit"  value="Upload" class="btn btn-primary btn-sm custom-width">
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

   <div class="well">
       <a href="<c:url value='/upload-file'/>">Upload file</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>