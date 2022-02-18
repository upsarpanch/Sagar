
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
		<h1>Customer</h1>
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
						<h5 class="card-title">Customer Details</h5>

						<div class="table-responsive">

							<!-- Table with stripped rows -->
							<table class="table datatable">
								<thead>
									<tr>
										<th>Firstname</th>
										<th>Lastname</th>
										<th>email</th>
										<th>Contact</th>
										<th>Pincode</th>
										<th>Branch name</th>
										<th>Status</th>
										<th>delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="user">
										<tr>
											<td>${user.firstName}</td>
											<td>${user.lastName}</td>
											<td>${user.email}</td>
											<td>${user.mobileNumber}</td>
											<td>${user.pinCode}</td>
											<td>${user.branch[0].branchName}</td>

											<c:if test="${user.status==1}">
												<td><a
													href="${window.contextRoot}/admin/manage/${user.userId}/activation"
													class="btn btn-success rounded-pill">Accepted</a></td>

											</c:if>

											<c:if test="${user.status==0}">
												<td><a
													href="${window.contextRoot}/admin/manage/${user.userId}/activation"
													class="btn btn-danger rounded-pill">Rejected</a></td>

											</c:if>

											<td><a
												href="${window.contextRoot}/admin/${user.userId}/delete"
												class="btn btn-warning rounded-pill">delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- End Table with stripped rows -->

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
