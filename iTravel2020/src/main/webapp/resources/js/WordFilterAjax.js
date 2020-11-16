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
    $.post("WordFilterServlet",
        {cmdType: $cmdType},
        dispWordFilterList);
}

function onAdd() {
    // Prepare parameters
    let $cmdType = "add";
    let $id = $("#id").val();
    let $value = $("#value").val();
    // Check validate
    checkValidate();
    if ($('#value').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id, value:$value},
        dispWordFilterList);
}

function onUpd() {
    // Prepare parameters
    let $cmdType = "upd";
    let $id = $("#id").val();
    let $value = $("#value").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id, value:$value},
        dispWordFilterList);
}

function onDel() {
    // Prepare parameters
    let $cmdType = "del";
    let $id = $("#id").val();
    // Check validate
    checkValidate();
    if ($('#isValid').val() === "false")
        return;
    // post and receive data
    $.post("WordFilterServlet",
        {cmdType: $cmdType, id:$id},
        dispWordFilterList);
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

function dispWordFilterList(respJson) {
    // Remove old Data
    let $table = $('#wordfilters');
    $table.find($('.wordfilter')).remove();
    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        let $row = "<tr class=\"wordfilter\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.value + "</td>"
            + "</tr>";
        $("#wordfilters").append($row);
    });
}
