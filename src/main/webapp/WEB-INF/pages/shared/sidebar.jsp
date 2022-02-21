
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

	<c:if test="${sessionScope.role=='ADMIN'}">

		<ul class="sidebar-nav" id="sidebar-nav">

			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/admin/admin.html"> <i class="bi bi-grid"></i>
					<span>Customer Board</span>
			</a></li>
			<!-- End Dashboard Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-menu-button-wide"></i><span>Product</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="components-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<li><a href="${contextRoot}/admin/product.html"> <i
							class="bi bi-circle"></i><span>Product add</span>
					</a></li>
					<li><a href="${contextRoot}/admin/product-details.html"> <i
							class="bi bi-circle"></i><span>Product details</span>
					</a></li>
					<li><a href="${contextRoot}/admin/product-requirement.html">
							<i class="bi bi-circle"></i><span>Order approval</span>
					</a></li>
					<li><a href="${contextRoot}/admin/product-requirement-history.html">
							<i class="bi bi-circle"></i><span>History</span>
					</a></li>

				</ul></li>
			<!-- End Components Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-journal-text"></i><span>Branch</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="forms-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<li><a href="${contextRoot}/admin/branch-details.html"> <i
							class="bi bi-circle"></i><span>Branch Details</span>
					</a></li>

				</ul></li>
			<!-- End Forms Nav -->

			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-layout-text-window-reverse"></i><span>Sales</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="tables-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<%-- <li><a href="${contextRoot}/admin/sales.html"> <i
							class="bi bi-circle"></i><span>Sales Reports</span>
					</a></li> --%>
					<li><a href="${contextRoot}/admin/sales-details.html"> <i
							class="bi bi-circle"></i><span>Sales Details</span>
					</a></li>
					
				</ul></li>
			<!-- End Tables Nav -->

			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/admin/logout"> <i class="bi bi-grid"></i> <span>Logout</span>
			</a></li>



		</ul>

	</c:if>

	<c:if test="${sessionScope.role==null}">

		<ul class="sidebar-nav" id="sidebar-nav">



			<c:if test="${panelId==null}">

				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/about.html"> <i
						class="bi bi-grid"></i> <span>About Us</span>
				</a></li>


				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/contact.html"> <i
						class="bi bi-grid"></i> <span>Contact Us</span>
				</a></li>


				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/page-login.html"> <i
						class="bi bi-grid"></i> <span>User Login</span>
				</a></li>



			</c:if>


			<c:if test="${panelId==770309}">

				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/about.html?panelId=${panelId}"> <i
						class="bi bi-grid"></i> <span>About Us</span>
				</a></li>


				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/contact.html?panelId=${panelId}"> <i
						class="bi bi-grid"></i> <span>Contact Us</span>
				</a></li>


				<li class="nav-item"><a class="nav-link "
					href="${contextRoot}/page-admin.html?panelId=${panelId}"> <i
						class="bi bi-grid"></i> <span>Admin</span>
				</a></li>




			</c:if>


		</ul>

	</c:if>


	<c:if test="${sessionScope.role=='USER'}">

		<ul class="sidebar-nav" id="sidebar-nav">

			<%-- <li class="nav-item"><a class="nav-link "
				href="${contextRoot}/customer/index.html"> <i class="bi bi-grid"></i>
					<span>Customer Dashboard</span>
			</a></li> --%>
			<!-- End Dashboard Nav -->

			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/customer/user-product.html"> <i
					class="bi bi-grid"></i> <span>Product Request</span>
			</a></li>

			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/customer/user-daily-sales.html"> <i
					class="bi bi-grid"></i> <span>Daily Sales</span>
			</a></li>
			<%-- 
			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/customer/branch.html"> <i
					class="bi bi-grid"></i> <span>Branch</span>
			</a></li>
 --%>
			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#tables-nav" data-bs-toggle="collapse"
				href="${contextRoot}/customer/user-history.html"> <i
					class="bi bi-layout-text-window-reverse"></i><span>History</span><i
					class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="tables-nav" class="nav-content collapse "
					data-bs-parent="#sidebar-nav">
					<li><a
						href="${contextRoot}/customer/product_requirement_history.html">
							<i class="bi bi-circle"></i><span>Product Requirement
								History</span>
					</a></li>
					<li><a href="${contextRoot}/customer/sales-history.html">
							<i class="bi bi-circle"></i><span>Sales History</span>
					</a></li>

				</ul></li>

			<li class="nav-item"><a class="nav-link "
				href="${contextRoot}/logout"> <i class="bi bi-grid"></i> <span>Logout</span>
			</a></li>




		</ul>

	</c:if>

</aside>
<!-- End Sidebar-->