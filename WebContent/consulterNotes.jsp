<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Les notes</title>
<meta charset="utf-8">
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<link rel="stylesheet" href="nv/bootstrap/css/bootstrap.min.css" type="text/css" />
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<script src="nv/js/lumino.glyphs.js"></script>
<script src="nv/js/lumino.glyphs.js"></script>
</head>
<c:if test="${empty login && empty password }">
      <c:redirect url = "Login.jsp"/>
      </c:if>
      <c:if test="${!empty login && !empty password }"> 
<body>
<%@ include file="listeMenu.jsp" %>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main"> 
<br><br><br>
<div class="col-lg-12">
				<div class="panel panel-default" style=" box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);">
					<div class="panel-heading">Les notes</div>
					<div class="panel-body">
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th width="40%">Le module</th>
								<th >La note</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="grades" items="${notes}">
                                <tr>
                                    <td>
                                    <c:out value="${grades.nomMod}" />
                                    </td>
                                    
									 <td>
									<c:out value="${grades.grade}" />
                                    </td>                                 
								 </tr>
						</c:forEach>
                        </tbody>
                    </table>
               <br><br>
				</div>
				</div>
			</div>
		</div>

</body>
</c:if>
</html>