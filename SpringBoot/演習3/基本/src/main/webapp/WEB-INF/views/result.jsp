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
      データを取得しました。<br>
      product_id：${product.product_name}<br>
      product_name：${product.id}<br>
      price：${product.price}
    </c:if>
  </p>
  <a href="top">戻る</a>
</body>
