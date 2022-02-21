
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/assets/vendor" />
<spring:url var="css1" value="/assets/css" />
<spring:url var="js" value="/assets/js" />
<spring:url var="images" value="/assets/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>${title}</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${css}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
<link href="${css}/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${css}/quill/quill.snow.css" rel="stylesheet">
<link href="${css}/quill/quill.bubble.css" rel="stylesheet">
<link href="${css}/remixicon/remixicon.css" rel="stylesheet">
<link href="${css}/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="${css1}/style.css" rel="stylesheet">


</head>

<body>

  <main>
    <div class="container">

      <section class="section error-404 min-vh-100 d-flex flex-column align-items-center justify-content-center">
        <h1>404</h1>
        <h2>${error}</h2>
        <a class="btn" href="${contextRoot}/page-login.html">Back to home</a>
        <img src="assets/img/not-found.svg" class="img-fluid py-5" alt="Page Not Found">
        <div class="credits">
           Designed by <a href="#">Sagar Jate</a>
        </div>
      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

</body>

</html>