$(document).ready(function () {
    onLoadInitData();
    $('#add').click(onAdd);
    uploadImage();
    uploadImage1();
    $('#upd').click(onUpdate);
    $('#del').click(onDelete);

    //show and hide edit form

    showHideForm();
    // $('#show').on('click', function () {
    //     $('.center').show();
    //     $(this).hide();
    // })
    //
    // $('#close').on('click', function () {
    //     $('.center').hide();
    //     $('#show').show();
    // })
});


function onLoadInitData(){
    //prepare parameters
    let $cmdType = "init";
    //checkValidate();
    $.post("UserPostServLet", {cmdType : $cmdType}, disPostList);
}
function disPostList() {

}
var time = new Date();
function onAdd(){
    let $cmdType = "add";
    // let $id = $('#id').html();
    // console.log($id);
    let $userId = $('#userId').html();
    let $title = $('#title').html();
    let $content = $('#content').text();
    console.log($content);
    let $category = $('#category').val();
    console.log($category);
    let $tags = $('#tags').val();
    console.log($tags);
    let $image = $('#image').val();
    console.log($image);
    //var time = new Date();
    let $time= time.getMonth()+"-"+time.getDate()+"-"+time.getFullYear();

    $.post("UserPostServlet",
        {
            cmdType: $cmdType, userId: $userId,  title:$title, content:$content, category:$category, tags:$tags, time:$time
        }, disPostList);
    $('#formAdd').submit();
    //uploadImage();

}

function onUpdate(){
    alert("on update");
    let $cmdType = "upd";
    let $id = $('#uid').html();
     console.log($id);
    let $userId = $('#userId').html();
    console.log($userId);
    let $title = $('#u-title').html();
    console.log($title);
    let $content = $('#u-content').text();
    console.log($content);
    let $category = $('#u-category').val();
    console.log($category);
    let $tags = $('#u-tags').val();
    console.log($tags);
    let $image = $('#u-image').val();
    console.log($image);

    let $time= time.getMonth()+","+time.getDate()+","+time.getFullYear();

    $.post("UserPostServlet",
        {
            cmdType: $cmdType, id:$id, userId: $userId, image:$image, title:$title, content:$content, category:$category, tags:$tags, time:$time
        }, disPostList);
    $('#formUpdate').submit();

}
function onDelete(){
    let $cmdType = "del";
    let $id = $('#id').val();
    $.post("UserPostServlet",
        {
            cmdType:$cmdType, id:$id
        }, disPostList())
    //$('#formAdd').submit();

}
function disPostList(respJson){
    let $table = $('#post');
    $table.find(($('.w3-container'))).append();
    $.each(respJson, function (i, item){
        // console.log(item.userId);
        // console.log(item.image);
         console.log(item.time);
        // console.log(item.content);
        // console.log(item.category);
        // console.log($('#userId').html());
        if(item.userId == $('#userId').html()){

                $("#uimage").html(item.image);
                $("#uid").html(item.id);
                $('#utitle').html(item.title);
                $('#ucontent').html(item.content);
                $('#ucategory').html(item.category);
                $('#utag').html(item.tags);
                $('#utime').html(item.time);
                console.log(item.time);
            //console.log(('#utime'));

        }


    })
}
function checkValidate() {
    // Prepare parameters
    let $id = $("#id").val();
    let $useId = $("#userId").html();
    // Check validate
    if ($useId == 0) {
        alert("Session expired. Please login again");
        return;
    }
    // if ($id==0){
    //     alert("Post Id is required");
    // }
}
//     $('#isValid').val("true");
// }
function uploadImage(){
    $('#formAdd').submit(function(event) {
        console.log("form submit 1");
        event.preventDefault();
        console.log("form submit 2");

        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                console.log(response);
                $('#image_frame').html(response);
                $('.center').hide();
                $('#show').show();
                console.log("i'm here to test");
            },
            beforeSend : function() {
                console.log("before send");
            }
        });

        return false;
    });

}
function uploadImage1(){
    $('#formUpdate').submit(function(event) {
        console.log("form submit 1");
        event.preventDefault();
        console.log("form submit 2");
        // let $imageName = $('#u-image').val();
        // $.post("ImageUploadServlet", {
        //     imageName: $imageName, data: new FormData(this)
        // }, function (response) {
        //     console.log(response);
        //     $('#image_frame').html(response);
        //     $('#center').hide();
        // })

        // Calling AJAX
        $.ajax({
            url : $(this).attr('action'),
            type : $(this).attr('method'),
            data : new FormData(this),
            contentType : false,
            cache : false,
            processData : false,
            success : function(response) {
                console.log(response);
                $('#image_frame').html(response);
                $('#center').hide();
            },
            beforeSend : function() {
                console.log("before send");
            }
        });

        return false;
    });

}
function ajax(){
    // Calling AJAX
    $.ajax({
        url : $(this).attr('action'),
        type : $(this).attr('method'),
        data : new FormData(this),
        contentType : false,
        cache : false,
        processData : false,
        success : function(response) {
            console.log(response);
            $('#image_frame').html(response);
            $('#center').hide();
        },
        beforeSend : function() {
            console.log("before send");
        }
    });
}
//show location

function initMap() {
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 8,
        center: { lat: 41.01347, lng: -91.9589057 },
    });
    const geocoder = new google.maps.Geocoder();
    const infowindow = new google.maps.InfoWindow();
    document.getElementById("submit").addEventListener("click", () => {
        geocodeLatLng(geocoder, map, infowindow);
    });
}

function geocodeLatLng(geocoder, map, infowindow) {
    const input = document.getElementById("latlng").value;
    const latlngStr = input.split(",", 2);
    const latlng = {
        lat: parseFloat(latlngStr[0]),
        lng: parseFloat(latlngStr[1]),
    };
    geocoder.geocode({ location: latlng }, (results, status) => {
        if (status === "OK") {
            if (results[0]) {
                map.setZoom(11);
                const marker = new google.maps.Marker({
                    position: latlng,
                    map: map,
                });
                infowindow.setContent(results[0].formatted_address);
                infowindow.open(map, marker);
            } else {
                window.alert("No results found");
            }
        } else {
            window.alert("Geocoder failed due to: " + status);
        }
    });
}

