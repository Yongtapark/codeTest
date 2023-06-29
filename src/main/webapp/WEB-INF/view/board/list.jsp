<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<style>
		.pageInfo{
			list-style : none;
			display: inline-block;
			margin: 50px 0 0 100px;
		}
		.pageInfo li{
			float: left;
			font-size: 20px;
			margin-left: 18px;
			padding: 7px;
			font-weight: 500;
		}
		.pagination-container {
			display: flex;
			justify-content: center;
			width: 100%;
		}
		a:link {color:black; text-decoration: none;}
		a:visited {color:black; text-decoration: none;}
		a:hover {color:black; text-decoration: underline;}
	</style>
</head>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	</head>
	<body>
	<div class="wrap">
   		<div class="row">
   			<div class="col-xs-12 col-sm-12 col-md-12">
               	<div class="card card-with-border">
               		<div class="card-header">
               			<h5>게시판 목록</h5>
               		</div>
               		<div class="card-body">
               			<div class="form-inline">
   							<div class="form-group form-row">
   								
   							</div>
   							<div class="form-group form-row">
   								<div class="input-group">
   									<input class="form-control" type="text" name="keyword" placeholder="제목 또는 내용 검색" />
   								</div>
   								<div class="pl10">
   									<button type="button" data-role="btnSearch" class="btn btn-primary">검색</button>
   								</div>
   							</div>
               			</div>
   					</div>
               	</div>
   			</div>
   			<div class="col-12">
   				<div class="card card-with-border">
             		<div class="card-body">
             			<div class="row mb-3">
	          				<div class="col-3">
               					<select class="form-control" id="pageSize" onchange="page(${searchDto.page})">
									<option value="10"<c:if test="${searchDto.pageSize == 10}">selected="selected"</c:if>> 10개씩 보기</option>
									<option value="20"<c:if test="${searchDto.pageSize == 20}">selected="selected"</c:if>> 20개씩 보기</option>
									<option value="30"<c:if test="${searchDto.pageSize == 30}">selected="selected"</c:if>> 30개씩 보기</option>
									<option value="40"<c:if test="${searchDto.pageSize == 40}">selected="selected"</c:if>> 40개씩 보기</option>
									<option value="50"<c:if test="${searchDto.pageSize == 50}">selected="selected"</c:if>> 50개씩 보기</option>
								</select>
               				</div>
               			</div>
   						<div class="table-responsive">
   							<table class="table text-center">
   								<thead>
   									<tr>
   										<th>No</th>
   										<th>제목</th>
   										<th>조회수</th>
   										<th>등록일시</th>
   									</tr>
   								</thead>
   								<tbody>
								<c:forEach var="board" items="${boards}">
									<tr>
										<td>${board.boardNo}</td>
										<td><a href="/board/detail/${board.boardNo}">${board.title}</a></td>
										<td>${board.hits}</td>
										<td>${board.regDttm}</td>
										<%--<td>${board.content}</td>--%>
									</tr>
								</c:forEach>
   								</tbody>
   							</table>
   						</div>
   						<div class="row">
   							<div class="col-3">
   								<a href="/board" class="btn btn-primary">글쓰기</a>
   							</div>
   						</div>
						<div class="pagination-container">
							<ul id="pageInfo" class="pageInfo">
								<c:if test="${pagination.existPrevPage}">
									<li class="pageInfo_btn previous"><a href="/board/list?page=${searchDto.page-1}&search=${searchDto.search}&pageSize=${searchDto.pageSize}">previous</a></li>
								</c:if>

								<c:forEach var="num" begin="${pagination.startPage}" end="${pagination.endPage}">
									<li class="pageInfo_btn"><a href="/board/list?page=${num}&search=${searchDto.search}&pageSize=${searchDto.pageSize}">${num+1}</a></li>
								</c:forEach>

								<c:if test="${pagination.existNextPage}">
									<li class="pageInfo_btn next"><a href="/board/list?page=${searchDto.page+1}&search=${searchDto.search}&pageSize=${searchDto.pageSize}">next</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
   			</div>
   		</div>
	</div>
	</body>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('[data-role="btnSearch"]').click(function(){
				var page = ${searchDto.page};
				var pageSize = ${searchDto.pageSize};
				var search = $('input[name="keyword"]').val();
				window.location.href = '${pageContext.request.contextPath}/board/list?page='+ page+'&search='+search+'&pageSize='+pageSize;
			});
		});

		/*한페이지당 게시물 */
		function page(idx){
			var page = idx;
			var pageSize = $("#pageSize option:selected").val();
			var search = $('input[name="keyword"]').val();

			if(pageSize == 10){
				location.href="${pageContext.request.contextPath}/board/list?search="+search+"&page="+page+"&pageSize="+pageSize

			}else if(pageSize == 20){
				location.href="${pageContext.request.contextPath}/board/list?search="+search+"&page="+page+"&pageSize="+pageSize

			}else if(pageSize == 30){
				location.href="${pageContext.request.contextPath}/board/list?search="+search+"&page="+page+"&pageSize="+pageSize

			}else if(pageSize == 40){
				location.href="${pageContext.request.contextPath}/board/list?search="+search+"&page="+page+"&pageSize="+pageSize

			}else if(pageSize == 50){
				location.href="${pageContext.request.contextPath}/board/list?search="+search+"&page="+page+"&pageSize="+pageSize

			}
		}

	</script>
</html>