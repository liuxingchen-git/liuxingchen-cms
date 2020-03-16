<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>今日头条</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/resource/images/aa.ico" />
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resource/css/index.css">


</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px; padding-top: 5px; font-size: 14px">
				<a href="#"><font color="white">下载APP</font></a>
				<div style="float: right">
					<!-- 如果没有登录则显示登录注册按钮 -->
					<c:if test="${null==sessionScope.user}">

						<button type="button" onclick="reg()" class="btn btn-link btn-sm"
							data-toggle="modal" data-target="#exampleModal">
							<font color="white">注册</font>
						</button>
						<button type="button" onclick="login()"
							class="btn btn-link btn-sm" data-toggle="modal"
							data-target="#exampleModal">
							<font color="white">登录</font>
						</button>
					</c:if>
					<c:if test="${null!=sessionScope.user}">
						<%-- 	<font color="white">${sessionScope.user.username }</font>
						<button type="button" onclick="logout()"
							class="btn btn-link btn-sm" data-toggle="modal"
							data-target="#exampleModal">
							<font color="white">注销</font>
						</button> --%>
						<div class="btn-group dropleft">
							<button type="button"
								class="btn btn-sm btn-secondary dropdown-toggle"
								style="background: #222222; border: 0px; padding-bottom: 0px"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">${sessionScope.user.username }</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/my">个人中心</a></a> <a
									class="dropdown-item" href="/passport/logout">注销</a>
							</div>
						</div>


					</c:if>



				</div>
			</div>

		</div>
		
		<!--  搜索框 -->
		<div class="card offset-2"
			style="width: 18rem; margin-bottom: 5px; border: 0px;margin-top: 20px;margin-bottom: 20px;">
			<div class="form-inline">
				<input type="text" placeholder="请输入要搜索的内容" id="keyword" value="${keyword }" class="form-control"	style="width: 14rem; margin-right: 5px">
				<button class="btn btn-info" type="button" onclick="search();">搜索</button>
			</div>

		</div>

		<div class="row" style="margin-top: 5px">
			<!-- 中间区域 -->
			<div class="col-md-7 offset-2">
				<div>

					<c:forEach items="${pageInfo.list }" var="item">
						<div class="media">
							<img src="/pic/${item.picture }"
								class="align-self-center mr-3 rounded" alt="..." width="156px"
								height="101.8">
							<div class="media-body">
								<h5 class="mt-0">
									<a href="/articleDetail?id=${item.id }" target="_blank">${item.title }</a>
								</h5>
							</div>
						</div>
						<hr>
					</c:forEach>
					<%-- ${pageInfo } --%>
					<div>
						<nav aria-label="Page navigation example">
						<ul class="pagination">
							<c:if test="${pageInfo.pageNum!=1 }">
								<li class="page-item">
									<a class="page-link" href="javascript:goPage(${pageInfo.prePage==0?1:pageInfo.prePage })"
										aria-label="Previous"> <span aria-hidden="true">上一页</span>
									</a>
								</li>
							</c:if>
							<c:if test="${pageInfo.pages!=pageInfo.pageNum }">
								<li class="page-item"><a class="page-link" href="javascript:goPage(${pageInfo.pageNum+1})"
									aria-label="Next"> <span aria-hidden="true">下一页</span>
								</a></li>
							</c:if>
						</ul>
					</nav>
				
				</div>

				</div>

			</div>
			<!-- 右侧区域 -->
			<div class="col-md-3"></div>











		</div>
		<!-- 引入js -->
		<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
		<!-- 引入js -->
		<script type="text/javascript" src="/resource/js/popper.min.js"></script>
		<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>

		<script type="text/javascript">
		
			function search() {
				window.location.href = "/search?keyword="+$("#keyword").val();
			}
		
		
			function goPage(page) {
				console.log(page);
				window.location.href = "/search?keyword="+$("#keyword").val()+"&pageNum="+page;
			}

			//注册

			function reg() {
				$("#myTitle").text("用户注册");
				$("#myModal").load("/passport/reg");
			}

			//登录
			function login() {
				$("#myTitle").text("用户登录");
				$("#myModal").load("/passport/login");
			}

			//注销
			function logout() {
				location.href = "/passport/logout";
			}
		</script>
</body>
</html>