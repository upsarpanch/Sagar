<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url var="css" value="/assets/vendor" />
<spring:url var="css1" value="/assets/css" />
<spring:url var="js" value="/assets/js" />
<spring:url var="images" value="/assets/img" />
<spring:url var="client" value="/assets/client" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard - ${companyName}</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="${images}/favicon.png" rel="icon">
<link href="${images}/apple-touch-icon.png" rel="apple-touch-icon">
<link href="${client}/apple-touch-icon.png" rel="apple-touch-icon">

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

<script src="${js}/angular.min.js"></script>

<!-- Bootstrap DataTables -->
<link href="${css1}/dataTables.bootstrap.css" rel="stylesheet">




<!-- Template Main CSS File -->
<link href="${css1}/style.css" rel="stylesheet">

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
	window.role = '${sessionScope.role}'
	window.userID = '${sessionScope.userId}'
</script>


</head>



<body>



	<c:if test="${sessionScope.role==null}">
		<c:if test="${userClickUser==true}">
			<%@include file="page-login.jsp"%>
		</c:if>

		<c:if test="${userClickRegister==true}">
			<%@include file="page-register.jsp"%>
		</c:if>

		<c:if test="${userClickUserMainDashboard==true}">
			<%@include file="main-dashboard.jsp"%>
		</c:if>

		<c:if test="${userClickAdmin==true}">
			<%@include file="page-admin.jsp"%>
		</c:if>

		<c:if test="${userClickError==true}">
			<%@include file="page-error.jsp"%>
		</c:if>


		<c:if test="${userClickAboutUs==true}">
			<%@include file="page-about.jsp"%>
		</c:if>


		<c:if test="${userClickContactUs==true}">
			<%@include file="page-contact.jsp"%>
		</c:if>


	</c:if>


	<c:if test="${sessionScope.role=='USER'}">
		<c:if test="${userClickUserHome==true}">
			<%@include file="user.jsp"%>
		</c:if>
		<c:if test="${userClickUserProduct==true}">
			<%@include file="user-product.jsp"%>
		</c:if>
		<c:if test="${userClickSalesUser==true}">
			<%@include file="user-sales.jsp"%>
		</c:if>
		<c:if test="${userClickSalesDetailsUser==true}">
			<%@include file="user-sales-details.jsp"%>
		</c:if>
		<c:if test="${userClickUserBranch==true}">
			<%@include file="user-branch.jsp"%>
		</c:if>
		<c:if test="${userClickUserProductAddView==true}">
			<%@include file="user-product-view.jsp"%>
		</c:if>
		<c:if test="${userClickUserSuccess==true}">
			<%@include file="success.jsp"%>
		</c:if>
		<c:if test="${userClickUserPaymentFailure==true}">
			<%@include file="failure.jsp"%>
		</c:if>
		<c:if test="${userClickUserPaymentRequest==true}">
			<%@include file="payment-request.jsp"%>
		</c:if>
		<c:if test="${userClickProductRequirementHistory==true}">
			<%@include file="user-product-requirement-history.jsp"%>
		</c:if>
		<c:if test="${userClickSalesHistory==true}">
			<%@include file="user-sales-history.jsp"%>
		</c:if>
	</c:if>


	<c:if test="${sessionScope.role=='ADMIN'}">

		<c:if test="${userClickAdminHome==true}">
			<%@include file="admin.jsp"%>
		</c:if>

		<c:if test="${userClickAdminDashboardHome==true}">
			<%@include file="dashboard.jsp"%>
		</c:if>

		<c:if test="${userClickAdminProductHome==true}">
			<%@include file="admin-product.jsp"%>
		</c:if>

		<c:if test="${userClickAdminProductDetailsHome==true}">
			<%@include file="admin-product-view.jsp"%>
		</c:if>

		<c:if test="${userClickAdminProductRequirementHome==true}">
			<%@include file="admin-product-requirement.jsp"%>
		</c:if>


		<c:if test="${userClickAdminBranchDetails==true}">
			<%@include file="admin-branch-view.jsp"%>
		</c:if>

		<c:if test="${userClickSalesDetailsAdmin==true}">
			<%@include file="admin-sales-details.jsp"%>
		</c:if>

		<c:if test="${userClickAdminSuccess==true}">
			<%@include file="admin-success.jsp"%>
		</c:if>

		<c:if test="${userClickAdminProductRequirementHomeView==true}">
			<%@include file="admin-product-requirement-view.jsp"%>
		</c:if>



	</c:if>


</body>

</html>