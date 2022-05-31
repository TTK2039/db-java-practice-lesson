<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
  <p>検索結果</p>
  <p>
    <c:if test="${not empty product}">
      ${userName}さんが下記の商品を選択しました。<br>
      商品：${product.productname}<br>
      金額：${product.price}
    </c:if>
  </p>
  <a href="index">戻る</a>
</body>
