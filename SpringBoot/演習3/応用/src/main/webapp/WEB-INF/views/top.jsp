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
  <form:form  modelAttribute="index" method="post">
    <div>
      <label>商品名:</label> <form:input path="product_name" />
    </div>
    <div>
      <label>値段:</label> <form:input path="price" />
    </div>
    <form:button formaction="serch">検索</form:button>
    <form:button formaction="register">登録</form:button>
  </form:form>
</body>
