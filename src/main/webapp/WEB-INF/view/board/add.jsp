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
               			<h5>게시판 상세</h5>
               		</div>
               	</div>
   			</div>
   			<div class="col-12">
   				<div class="card card-with-border">
             		<div class="card-body">
   						<div class="table-responsive">
							<form action="/board" method="post">
   							<table class="table text-center">
   								<tbody>
   									<tr>
   										<td>제목</td>
   									</tr>
									<tr>
										<td><input type="text" name="title" value="${boardModel.title}"></td>
									</tr>
									<tr>
										<td>글쓴이</td><br>
									</tr>
									<tr>
										<td><input type="text" name="regName" value="${boardModel.regName}"></td>
									</tr>

   									<tr>
										<td>내용</td><br>
   									</tr>
								<tr>
									<td colspan="2"><textarea name="content" value="${boardModel.content}"></textarea></td>
								</tr>

   								</tbody>
   							</table>
										<div class="col-3">
										<input type="submit" class="btn btn-primary" value="등록하기">   <a href="/board/list" class="btn btn-primary">목록으로</a>
										</div>
							</form>
							<div class="row">

							</div>
						</div>
   					</div>
   				</div>
   			</div>
   		</div>
	</div>
</html>