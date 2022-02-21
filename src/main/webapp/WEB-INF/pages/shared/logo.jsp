 
 <c:if test="${sessionScope.role==null}">
 
   <div class="d-flex align-items-center justify-content-between">
      <a href="${contextRoot}/about.html" class="logo d-flex align-items-center">
        <img src="${images}/logo.png" alt="">
        <span class="d-none d-lg-block">${companyName}</span>
      </a><i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->
    
 </c:if>   
 
 <c:if test="${sessionScope.role=='USER'}">
 
   <div class="d-flex align-items-center justify-content-between">
      <a href="${contextRoot}/customer/user-product.html" class="logo d-flex align-items-center">
        <img src="${images}/logo.png" alt="">
        <span class="d-none d-lg-block">${companyName}</span>
      </a><i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->
    
 </c:if>   
 
 <c:if test="${sessionScope.role=='ADMIN'}">
 
   <div class="d-flex align-items-center justify-content-between">
      <a href="${contextRoot}/admin/admin.html" class="logo d-flex align-items-center">
        <img src="${images}/logo.png" alt="">
        <span class="d-none d-lg-block">${companyName}</span>
      </a><i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->
    
 </c:if>   