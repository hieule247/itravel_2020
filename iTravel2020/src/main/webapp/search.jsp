<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
    <script type="text/javascript" src="resources/js/lib.js"></script>
</head>
<body>
    <div class="container">
        <h1>Search Form</h1>
        <p><label for="name">Enter some text: </label><input id='name' type='text' name='name'/>
            <button id='btnBook' type='button' value='book'>Search Book</button>
            <button id='btnMember' type='button' value='member'>Search Member</button>
            <a href="index.jsp">Back Home</a>
        </p>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th id="id"></th>
                <th id="f1"></th>
                <th id="f2"></th>
                <th id="f3"></th>
            </tr>
            </thead>
            <tbody id="list">
            </tbody>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination pg-blue" id="pagination">
            </ul>
        </nav>
    </div>
</body>
</html>
