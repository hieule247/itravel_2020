$(document).ready(function () {
    // console.log("Document is ready!!!");
    onLoadInitData();
    $('#add').click(onAdd);
    $('#upd').click(onUpd);
    $('#del').click(onDel);
});

function onLoadInitData() {
    // Prepare parameters
    let $cmdType = "init";
    $.post("_PostMnServlet",
        {cmdType: $cmdType},
        disp_PostList);
}

function onAdd() {
    alert("ddddd");
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $image = $("#image").val();
    let $title = $("#title").val();
    let $content = $("#content").val();
    let $category = $("#category").val();
    let $tags = $("#tags").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("_PostMnServlet",
        {cmdType: $cmdType, id:$id, image:$image, title:$title, content:$content, category:$category, tags:$tags},
        disp_PostList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $image = $("#image").val();
    let $title = $("#title").val();
    let $content = $("#content").val();
    let $category = $("#category").val();
    let $tags = $("#tags").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("_PostMnServlet",
        {cmdType: $cmdType, id:$id, image:$image, title:$title, content:$content, category:$category, tags:$tags},
        disp_PostList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // post and receive data
    $.post("_PostMnServlet",
        {cmdType: $cmdType, id:$id},
        disp_PostList);
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

function disp_PostList(respJson) {
    // Remove old Data
    let $table = $('#_posts');
    $table.find($('._post')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = "<tr class=\"_post\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.image + "</td>"
            + "<td>" + item.title + "</td>"
            + "<td>" + item.content + "</td>"
            + "<td>" + item.category + "</td>"
            + "<td>" + item.tags + "</td>"
            + "</tr>";
        $("#_posts").append($row);
    });
}
