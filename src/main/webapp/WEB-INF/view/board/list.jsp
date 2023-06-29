<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	</head>
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
   									<input class="form-control" type="text" name="searchText" placeholder="제목 또는 내용 검색" />
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
               					<select class="form-control" name="pageSize">
									<option value="10">10개씩 보기</option>
									<option value="20">20개씩 보기</option>
									<option value="30">30개씩 보기</option>
									<option value="40">40개씩 보기</option>
									<option value="50">50개씩 보기</option>
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
   									<tr>
   										<td>1</td>
   										<td><a href="/board/detail/1">제목입니다.</a></td>
   										<td>0</td>
   										<td>2021-06-15 10:00</td>
   									</tr>
   								</tbody>
   							</table>
   						</div>
   						<div class="row">
   							<div class="col-3">
   								<a href="#" class="btn btn-primary">글쓰기</a>
   							</div>
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
	</div>
</html>