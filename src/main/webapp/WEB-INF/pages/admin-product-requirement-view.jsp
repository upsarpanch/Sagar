
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
						<h5 class="card-title">Product Details</h5>

						<div class="table-responsive">

							<!-- Table with stripped rows -->
							<table class="table datatable" id="tableID">
								<thead>
									<tr>
										<th>Item</th>
										<th>Quantity</th>
										<th>Unit</th>
										<th>Net amount</th>
										<th>Requested date</th>
										<th>Status</th>
										<th>Payment Mode</th>
										<th>Acceptant</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="product" items="${products}">
										<tr>
											<td>${product.item}</td>
											<td>${product.quantity}</td>
											<td>${product.unit}</td>
											<td>${product.netAmount}</td>
											<td>${product.createdDate}</td>
											<td>${product.status}</td>
											<td>${product.paymentMode}</td>
											<td><a
												href="${window.contextRoot}/admin/${user_id}/product-requirement-view-accept.html"
												class="btn btn-success rounded-pill">accept</a></td>
										</tr>

									</c:forEach>

								</tbody>



							</table>

						</div>

						<h3 style="text-align: right; color: blue;">
							<span>Net Amount : ${netAmount}</span>
						</h3>

						<form
							action="${window.contextRoot}/admin/${user_id}/product-requirement-view-accept-all.html"
							method="post">
							<button class="btn btn-primary w-100" type="submit">All
								order accept</button>
						</form>


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
