 <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

     <%@include file="./shared/logo.jsp"%>
  

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

       
   
      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- Navigation -->
		<%@include file="./shared/sidebar.jsp"%>

 <main id="main" class="main">

    <div class="pagetitle">
      <h1>Profile</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Users</li>
          <li class="breadcrumb-item active">Profile</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <img src="assets/img/MB.jpeg" alt="Profile" class="rounded-circle">
              <h2>Milind Bhoite</h2>
              <h3>Chairman</h3>
              <div class="social-links mt-2">
                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
              </div>
              <br/>
              <span style="float:left;"><b>Our History and mission</b></span>
              We have started "Upsarpanch Gulacha chaha"   shop in year 2019 at Shrigonda, Dist. Ahmednagar, Maharashtra. Which is very popular Brand for special gulacha chaha and it is very useful for health.
Gulacha chaha gives many benefits to human body.
Within 3 years time, we have spread our business in all district of Maharashtra and in others states also.
Till Feb.2022, we have more than 210 branches.
This is good approtunity to all younger friends to start you business with "Upsarpanch Gulacha chaha" with minimum investment and more benefits.
We are very thankful to our all valuable customers who made "Upsarpanch gulacha Chaha" Brand is very popular within a short period of time.
<br/>
Thank you very much<br/>
Regards<br/>
Mr.Milind Bhoite<br/>
Chairman, Upsarpanch Gulacha Chaha.

            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                </li>

  <div class="table-responsive">
<table style="margin-left:auto;margin-right:auto;">
    
    <tbody>
    
    <tr>
    <td>  <img src="${client}/1.jpg" alt="" width="260" height="260"></td>
     <td>  <img src="${client}/3.jpg" alt=""width="260" height="260"></td>
    <td>  <img src="${client}/4.jpg" alt="" width="260" height="260"></td>
    
    </tr>
    
    <tr>
    <td>  <img src="${client}/5.jpg" alt="" width="260" height="260"></td>
     <td>  <img src="${client}/6.jpg" alt="" width="260" height="260"></td>
    <td>  <img src="${client}/7.jpg" alt="" width="260" height="260"></td>
    
    </tr>
    
    </tbody>
    
    </table>
</div>
              

              </ul>
            
            
            
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
