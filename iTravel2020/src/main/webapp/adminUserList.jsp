<%--
  Created by IntelliJ IDEA.
  User: J&C
  Date: 11/12/2020
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/ShowUserListAjax.js"></script>
    <link href="resources/css/admin.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="resources/js/BookMnAjax.js"></script>

</head>
<body>
<%@include file="adminMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="adminLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>USER MANAGEMENT</h1>
            <hr/>
            <div>
                <div>Search: <input type="text" id="myInput"/></div>
                <hr/>
                <div id="updMemberForm">
                    <form>
                        <table>
                            <tr><td><label for="id">User ID</label></td><td><input type="text" id="id" name="id"></td></tr>
                            <tr><td><label for="title">User Name</label></td><td><input type="text" id="title" name="title"></td></tr>
                            <tr><td><label for="author">User Eail</label></td><td><input type="text" id="author" name="author"></td></tr>
                            <tr><td><label for="subject">User Type</label></td><td><input type="text" id="subject" name="subject"></td></tr>
                            <tr><td><label for="isbn">ActiveType</label></td><td><input type="text" id="isbn" name="isbn"></td></tr>
                            <tr><td></td><td>
                                <input type="hidden" value="false" id="isValid">
                                <input type="button" value="Add" id="add">
                                <input type="button" value="Update" id="upd">
                                <input type="button" value="Delete" id="del">

                            </td></tr>
                        </table>
                    </form>
                </div>
                <!-- List Display -->
                <hr/>
                <div>
                    <table class="changeHistory" id="users">
                        <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>User Eail</th>
                            <th>User Type</th>
                            <th>ActiveType</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        </tbody>
                    </table>
                    <div>
                        <input id="prePage" size=" "  name="prePageButton" type="button" value="Previous Page"/>
                        <input id="nextPage"  size=" " name="nextPage" type="button" value="Next Page"/>
                    </div>
                </div>

            </div>

        </div>
        <!-- End Main content -->
        <%@include file="adminRContent.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
