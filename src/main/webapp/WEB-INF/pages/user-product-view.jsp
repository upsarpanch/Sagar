<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    $scope.totalAmount = "";
});
</script>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

	<%@include file="./shared/logo.jsp"%>

	<div class="search-bar">
		<form class="search-form d-flex align-items-center" method="POST"
			action="#">
			<input type="text" name="query" placeholder="Search"
				title="Enter search keyword">
			<button type="submit" title="Search">
				<i class="bi bi-search"></i>
			</button>
		</form>
	</div>
	<!-- End Search Bar -->

	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">

			<li class="nav-item d-block d-lg-none"><a
				class="nav-link nav-icon search-bar-toggle " href="#"> <i
					class="bi bi-search"></i>
			</a></li>
			<!-- End Search Icon-->

			<!-- Navigation -->
			<%@include file="./shared/message1.jsp"%>

			<!-- Navigation -->
			<%@include file="./shared/message2.jsp"%>

			<!-- Navigation -->
			<%@include file="./shared/menu.jsp"%>

		</ul>
	</nav>
	<!-- End Icons Navigation -->

</header>
<!-- End Header -->

<!-- Navigation -->
<%@include file="./shared/sidebar.jsp"%>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Product</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Home</a></li>
				<li class="breadcrumb-item">Tables</li>
				<li class="breadcrumb-item active">Data</li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-12">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Product Add</h5>

						<div ng-app="myApp" ng-controller="myCtrl">
							<form action="${action}" method="post"
								class="row g-3 needs-validation" novalidate>
								<div class="row mb-3">
									<label for="item" class="col-sm-2 col-form-label">Item</label>
									<div class="col-sm-10">${product.item}</div>
								</div>
								<div class="row mb-3">
									<label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
									<div class="col-sm-10">

										<input ng-model="totalAmount">
									
									</div>
								</div>
								<div class="row mb-3">
									<label for="unit" class="col-sm-2 col-form-label">Unit</label>
									<div class="col-sm-10">${product.unit}</div>
								</div>
								<div class="row mb-3">
									<label for="unitPrice" class="col-sm-2 col-form-label">Total
										Price</label>
									<div class="col-sm-10">

										{{totalAmount*${product.unitPrice}}}
										
										<input name="netAmount" type="hidden" value="{{totalAmount*${product.unitPrice}}}" />
										<input name="quantity" type="hidden" value="{{totalAmount}}" />
										<input name="item" type="hidden" value="${product.item}" />
										<input name="unit" type="hidden" value="${product.unit}" />
										</div>
								</div>


								<div class="text-center">
									<button type="submit" class="btn btn-primary">Add Item</button>
									<a href="${contextRoot}/customer/user-product.html">
									Back
									</a>
								</div>

							</form>
							
							<!-- End Horizontal Form -->

						</div>
						
						
					</div>

				</div>

			</div>
		</div>
	</section>

</main>
<!-- End #main -->



<!-- Navigation -->
<%@include file="./shared/footer.jsp"%>

<a href="#"
	class="back-to-top d-flex align-items-center justify-content-center"><i
	class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="${css}/apexcharts/apexcharts.min.js"></script>
<script src="${css}/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${css}/chart.js/chart.min.js"></script>
<script src="${css}/echarts/echarts.min.js"></script>
<script src="${css}/quill/quill.min.js"></script>
<script src="${css}/simple-datatables/simple-datatables.js"></script>
<script src="${css}/tinymce/tinymce.min.js"></script>
<script src="${css}/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${js}/main.js"></script>
