<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>演習3</title>
</head>
<body>
  <form:form action="result" modelAttribute="index" method="post">
    <div>
      <label>product_id:</label> <form:input path="product_id" />
    </div>
    <form:button>検索</form:button>
  </form:form>
</body>
