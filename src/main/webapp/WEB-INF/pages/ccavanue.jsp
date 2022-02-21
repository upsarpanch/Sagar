 <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

     <%@include file="./shared/logo.jsp"%>

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

       <!-- Navigation -->
		<%@include file="./shared/message1.jsp"%>
		
		<!-- Navigation -->
		<%-- <%@include file="./shared/message2.jsp"%> --%>
     
     <!-- Navigation -->
		<%@include file="./shared/menu.jsp"%>
       
      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

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
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">CCAvanue Details</h5>
              
              <form method="post" name="customerData" action="${ccavanue}">
		<table width="40%" height="100" border='1' align="center">
			<caption>
				<font size="4" color="blue"><b>Integration Kit</b></font>
			</caption>
		</table>
		<table width="40%" height="100" border='1' align="center">
			<tr>
				<td>Parameter Name:</td>
				<td>Parameter Value:</td>
			</tr>
			<tr>
				<td colspan="2">Compulsory information</td>
			</tr>
			<tr>
				<td>TID	:</td><td><input type="text" name="tid" id="tid" readonly /></td>
			</tr>
			<tr>
				<td>Merchant Id</td>
				<td><input type="text" name="merchant_id" id="merchant_id" value="770309" /></td>
			</tr>
			<tr>
				<td>Order Id</td>
				<td><input type="text" name="order_id" value="" /></td>
			</tr>
			<tr>
				<td>Currency</td>
				<td><input type="text" name="currency" value="INR" /></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" value="1.00" /></td>
			</tr>
			<tr>
				<td>Redirect URL</td>
				<td><input type="text" name="redirect_url"
					value="http://3.82.225.118:9090/customer/ccavanue-request.htm" />
				</td>
			</tr>
			<tr>
				<td>Cancel URL</td>
				<td><input type="text" name="cancel_url"
					value="http://3.82.225.118:9090/customer/ccavanue-response.htm" />
				</td>
			</tr>
			<tr>
				<td>Language</td>
				<td><input type="text" name="language" id="language" value="EN" /></td>
			</tr>
			
			<tr>
				<td><INPUT TYPE="submit" value="Checkout"></td>
			</tr>
		</table>
	</form>
             
            </div>
           
            
           </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->
 
 
 
  <!-- Navigation -->
		<%@include file="./shared/footer.jsp"%>

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
