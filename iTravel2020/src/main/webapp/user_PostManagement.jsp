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
    <script src="resources/js/userTravelInfo.js" type="text/javascript"></script>
    <%--    <script src="resources/js/UserPostMn.js" type="text/javascript"></script>--%>

</head>
<body>
<%@include file="userMenuBar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <%@include file="userLContent.jsp"%>
        <!-- Main content -->
        <div class="col-md-8 text-left">
            <h1>POST MANAGEMENT</h1>
            <hr/>
            <div>
                <tr><td><label for="userId">User ID</label></td><td><span id="userId"></span></td></tr>
                <tr><td><label for="name">Name</label></td><td><span id="name"></span></td></tr>
<%--                <div>Search: <input type="text" id="myInput"/></div>--%>
                <hr/>
                <div id="upd_PostForm">
                    <form>
                        <table>
                            <%--                            <tr><td><label for="id">Post ID</label></td><td><input type="text" id="id" name="id"></td></tr>--%>
                            <tr><td><label for="image">Image</label></td><td><input type="text" id="image" name="image"></td></tr>
                            <tr><td><label for="title">Title</label></td><td><input type="text" id="title" name="title"></td></tr>
                            <tr><td><label for="content">Content</label></td><td><input type="text" id="content" name="content"></td></tr>
                            <tr><td><label for="category">Category</label></td><td><input type="text" id="category" name="category"></td></tr>
                            <tr><td><label for="tags">Tags</label></td><td><input type="text" id="tags" name="tags"></td></tr>
                            <tr><td><label for="time">Time</label></td><td><input type="text" id="time" name="time"></td></tr>
                            <tr><td><label for="location">Tags</label></td><td><input type="text" id="location" name="location"></td></tr>

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
                    <table id="_posts" class="table">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>IMAGE P</th>
                            <th>TITLE</th>
                            <th>CONTENT</th>
                            <th>CATEGORY</th>
                            <th>TAGS</th>
                            <th>TIME</th>
                            <th>LOCATION</th>
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
