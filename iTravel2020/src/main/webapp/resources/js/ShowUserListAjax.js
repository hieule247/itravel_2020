$(document).ready(function () {//可以把$(document).ready写成$
    console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
    $('#toexcel').click(ExportToExcel);
    $('#showDeactiveUser').click(onDisplyShowDeactiveUserOnPage);
    $('#prePage').click(onPreviousPage);
    $('#nextPage').click(onNextPage);
    // Search local
    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});

$(document).on("click",".deactiveUser",function(){
    onUpdStatus();
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("AdminServlet",
        {cmdType: $cmdType},//没有action的名字，就直接到post方法，通过验证，再选择执行哪个
        //onDisplyShowDeactiveUser

        onDisplyShowDeactiveUserOnPage
    );
    alert("init");
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();//从用户界面输入的东西
    let $gender = $("#title").val();
    let $author = $("#author").val();
    let $subject = $("#subject").val();
    let $isbn = $("#isbn").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id, title:$title, author:$author, subject:$subject, isbn:$isbn},
        dispBookList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $activType = $("#title").val();

    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id, activType:$activType},
        displayDeactiveUser);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        dispBookList);
}

function checkValidate() {
    // Prepare parameters
    let $id = $("#id").val();
    // Check validate
    if ($id.trim().length == 0) {
        alert("ID is required!");
        $("#id").focus();
        $('#isValid').val("false");
        return;
    }
    $('#isValid').val("true");
}

function dispBookList(respJson) {
    // Remove old Data
    //let $table = $('#books');
    //$table.find($('.book')).remove();
    // Update new data
    $.each(respJson, function(i, book){
        // New Row
        // let $aCheckOut = "<a href=bookCheckout.jsp?bookId=" + book.id + ">Checkout</a>";
        // let $aCheckOut = "<input type ='button' value=" + book.id + ">Checkout</a>";
        // let $aCheckOut = "<input type ='button' value=" + book.id + ">Checkout</a>";
        let $book = "<tr class=\"book\"><td>" + book.id + "</td><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.subject + "</td><td>" + book.isbn + "</td><td>" + $aCheckOut + "</td></tr>";
        $("#books").append($book);
    });
}

function ExportToExcel(mytblId){
    var htmltable= document.getElementById('books');
    var html = htmltable.outerHTML;
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}

/*
function onDisplyShowDeactiveUser() {
    alert("onDisplyShowDeactiveUser");
    let $cmdType = "showDeactiveUser";
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType},
        displayDeactiveUser);//服务器上showDeactiveUser，返回json
}

function displayDeactiveUser(data){
    alert("displayDeactiveUser");
    //Remove old Data
    let $table = $('#users');
    $table.find($('.user')).remove();//remove all .user from users table
    //Update new data
    $.each(data, function(i, user){

        let $aStatus = '<button class="deactiveUser" value=' + user.id + '>ChangeActiveStatus</button>'
        let $user = "<tr class=\"user\">" +
            "<td>"+ user.id + "</td>" +
            "<td>"+ user.FullName + "</td>" +
            "<td>" + user.email + "</td>" +
            "<td>" + user.userType + "</td>" +
            "<td>" + user.activType+ "</td>" +
            "<td>" + $aStatus + "</td>" +
            "</tr>";
        $("#users").append($user);



    });

}

*/
function onDisplyShowDeactiveUserOnPage() {
     alert("onDisplyShowDeactiveUserOnPage");
    let $cmdType = "ShowOnPage";
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, },//json数据格式

        displayDeactiveUserOnPage);
    alert("onDisplyShowDeactiveUserOnPage2");
}

function displayDeactiveUserOnPage(data){
    alert("displayDeactiveUserOnPage");
    //Remove old Data
    let $table = $('#users');
    $table.find($('.user')).remove();//remove all .user from users table
    //Update new data
    $.each(data, function(i, user){

        let $aStatus = '<button class="deactiveUser" value=' + user.id + '>ChangeActiveStatus</button>'
        let $user = "<tr class=\"user\">" +
            "<td>"+ user.id + "</td>" +
            "<td>"+ user.FullName + "</td>" +
            "<td>" + user.email + "</td>" +
            "<td>" + user.userType + "</td>" +
            "<td>" + user.activType+ "</td>" +
            "<td>" + $aStatus + "</td>" +
            "</tr>";
        $("#users").append($user);

    });



}



function onUpdStatus(){//因为是动态的，要用anonymous function或 $(document).on
    // Prepare parameters
    let $cmdType = "updActType";
    let $id = $(".deactiveUser").val();
    // post and receive data
    $.post("AdminServlet",
        {cmdType: $cmdType, id:$id},
        //displayDeactiveUser
        onDisplyShowDeactiveUserOnPage
    );
    alert("The use is actived!");
}

function onNextPage(){
    // Prepare parameters
    let $cmdType = "nextPage";
    $.post("AdminServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("nextpage");
}

function onPreviousPage(){
    alert("prepage");
    // Prepare parameters
    let $cmdType = "prePage";
    $.post("AdminServlet",
        {cmdType: $cmdType},
        onDisplyShowDeactiveUserOnPage
    );
    alert("prepage");
}
function onHello(){
    alert("Hello");
}