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
              <h5 class="card-title">Product Details</h5>
              
              
            
            </div>
            
            <c:if test="${not empty productCheckouts}">
            
      
            
            <h2 style="color:red;">Selected Item for Order</h2>
            
              <div class="table-responsive">
            <!-- Table with stripped rows -->
						<table class="table datatable" id="tableID">
							<thead>
								<tr>
									<th>Item</th>
									<th>Quantity</th>
									<th>Unit</th>
									<th>Net Amount</th>
									<th>Remove</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="productCheckout" items="${productCheckouts}">
									<tr>
									<td>${productCheckout.item}</td>
									<td>${productCheckout.quantity}</td>
									<td>${productCheckout.unit}</td>
									<td>${productCheckout.netAmount}</td>
									<td><a href="${window.contextRoot}/customer/product/${productCheckout.requirementId}/delete" class="btn btn-warning rounded-pill">delete</a></td>
								</tr>
									
								</c:forEach>
 
							</tbody>
							
							
							
						</table>
						</div>
						<h3 style="text-align:right;color:blue;"><span>Net Amount : ${netAmount}</span></h3>
						
          </div>
          
          <form action="${window.contextRoot}/customer/payment-request.htm" method="post">
            <input type="hidden" name="redirect_url" value="${redirect_url}" />
			<input type="hidden" name="cancel_url" value="${cancel_url}" />
			<input type="hidden" name="merchant_id" value="${merchant_id}" />
			<input type="hidden" name="order_id" value="${order_id}" />
			<input type="hidden" name="language" value="${language}" />
			<input type="hidden" name="currency" value="${currency}" />
			<input type="hidden" name="amount" value="${netAmount}" />
			<input type="hidden" name="currency" value="${currency}" />
			<input type="hidden" name="customer_identifier" value="" />
			<input type="hidden" name="tid" value="" />
            <input name="netAmount" type="hidden" value="${netAmount}" />
           
            <div class="col-md-4">
                  <label for="inputState" class="form-label"><span style="color:red;">Payment Mode</span></label>
                  
                   <select class="form-select" id="validationDefault04" name="paymentMode" required>
                    <option selected disabled value="">Choose...</option>
                    <option>Online</option><option>Cash on delivery</option>
                  </select>
                </div>
           <br/>
           <button class="btn btn-primary w-100" type="submit">Place the order</button>
          </form>
          
          <br/>
          
          <hr/>
          
          </c:if>
          
          
            <div class="table-responsive">
              
              <!-- Table with stripped rows -->
              	<table  class="table datatable">
                <thead>
                  <tr>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Unit</th>
                    <th>Price</th>
                    <th>Order</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                  <tr>
                    <td>${product.item}</td>
                    <td>${product.quantity}</td>
                    <td>${product.unit}</td>
                    <td>${product.unitPrice}</td>
                     <td><a href="${window.contextRoot}/customer/product/${product.productId}" class="btn btn-success rounded-pill">order now</a></td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

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
