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
                            <tr><td><label for="id">Book ID</label></td><td><input type="text" id="id" name="id"></td></tr>
                            <tr><td><label for="title">Title</label></td><td><input type="text" id="title" name="title"></td></tr>
                            <tr><td><label for="author">Author</label></td><td><input type="text" id="author" name="author"></td></tr>
                            <tr><td><label for="subject">Subject</label></td><td><input type="text" id="subject" name="subject"></td></tr>
                            <tr><td><label for="isbn">ISBN</label></td><td><input type="text" id="isbn" name="isbn"></td></tr>
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
                    <table id="books" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>TITLE</th>
                            <th>AUTHOR</th>
                            <th>SUBJECT</th>
                            <th>ISBN</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
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
