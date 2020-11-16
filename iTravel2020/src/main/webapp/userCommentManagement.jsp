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
    <script type="text/javascript" src="resources/js/_PostMnAjax.js"></script>

</head>
<body>
<%@include file="userMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="userLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>COMMENT MANAGEMENT</h1>
            <hr/>
            <div>
                <div>Search: <input type="text" id="myInput"/></div>
                <hr/>
                <div id="updCommentForm">
                    <form>
                        <table>
                            <tr><td><label for="id">ID</label></td><td><input type="text" id="id" name="id"></td></tr>
                            <tr><td><label for="postId">Post ID</label></td><td><input type="text" id="postId" name="postId"></td></tr>
                            <tr><td><label for="userId">User ID</label></td><td><input type="text" id="userId" name="userId"></td></tr>
                            <tr><td><label for="content">Content</label></td><td><input type="text" id="content" name="content"></td></tr>
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
                    <table id="comments" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>POST ID</th>
                            <th>USER ID</th>
                            <th>CONTENT</th>
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
        <%@include file="userRContent.jsp"%>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
