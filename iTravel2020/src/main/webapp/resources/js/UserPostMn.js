$(document).ready(function () {
    onLoadInitData();
    $('#add').click(onAdd);
    uploadImage();
    uploadImage1();
    getCurrPostList();
    displayPostListOnHomePage();
    $('#upd').click(onUpdate);
    $('#del').click(onDelete);
    initMap();

    //show and hide edit form

    showHideForm();
    $('#show').on('click', function () {
        $('.center').show();
        $(this).hide();
    })

    $('#close').on('click', function () {
        $('.center').hide();
        $('#show').show();
    })
});
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

function getCurrPostList(){
    let $cmdType = "getPostList";
    //checkValidate();
    $.post("UserPostServLet", {cmdType : $cmdType}, disp_PostList);
}

function onLoadInitData(){
/*    // Get parameter from url
    let searchParams = new URLSearchParams(window.location.search);
    if (searchParams.has('userId') == false)
        return;
    let userId = searchParams.get('userId');
    alert (userId);
    //prepare parameters
    let $cmdType = "init";
    //checkValidate();
    $.post("UserPostServLet", {cmdType : $cmdType, userId : userId}, disp_PostList);
*/
    alert ("loooooaaaaaddd.... User post");
    //prepare parameters
    let $cmdType = "init";
    //checkValidate();
    $.post("UserPostServLet", {cmdType : $cmdType}, disp_PostList);
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
    // let $location;
    // if ($('#position').val()==false){
    //     $location="";
    // }
//     else {
//         function curr(position) {
// //     $location = position.coords.latitude + ", " + position.coords.longitude;
 //       }
// }
   //}
    $.post("UserPostServlet",
        {
            cmdType: $cmdType, userId: $userId,  title:$title, content:$content, category:$category, tags:$tags, time:$time
        }, disPostList);
    $('#formAdd').submit();
    uploadImage();

}

function onUpdate(){
    $('.updateImageEdit').hide();
    //alert("on update");
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
    // var $location = $('#aadddd').coords.latitude + "," + $('#add').coords.longitude;

    var $time= time.getMonth()+","+time.getDate()+","+time.getFullYear();

    $.post("UserPostServlet",
        {
            cmdType: $cmdType, id:$id, userId: $userId, image:$image, title:$title, content:$content, category:$category, tags:$tags, time:$time
        }, disPostList);
    $('#formUpdate').submit();

}
// var $location = navigator.geolocation.getCurrentPosition(coords.latitude +", "+ coords.longitude, );
// function getCurrPosition(){
//     if (navigator.geolocation) {
//         navigator.geolocation.getCurrentPosition(curr);
//
//     } else {
//          alert("Geolocation is not supported by this browser.");
//     }
// }
// function curr(position) {
//     $location = position.coords.latitude + ", " + position.coords.longitude;
// }
function onDelete(){
    let $cmdType = "del";
    let $id = $('#id').val();
    $.post("UserPostServlet",
        {
            cmdType:$cmdType, id:$id
        }, disPostList())
    //$('#formAdd').submit();

}
function disp_PostList(respJson) {
    // Remove old Data
    alert("hello");
    let $table = $('#_posts');
    $table.find($('._post')).remove();


    // Update new data
    $.each(respJson, function(i, item){
        // New Row
        console.log(item);
        let $row = "<tr class=\"_post\">"
            + "<td>" + item.id + "</td>"
            + "<td>" + item.image + "</td>"
            + "<td>" + item.title + "</td>"
            + "<td>" + item.content + "</td>"
            + "<td>" + item.category + "</td>"
            + "<td>" + item.tags + "</td>"
            + "<td>" + item.time + "</td>"
            + "<td>" + item.location + "</td>";
        $("#_posts").append($row);
    });
    alert("DOne")
}
function disPostList(respJson){
    alert("dis play post");

    let $table = $('#table');
    $table.find(($('.w3-container'))).append();
    $.each(respJson, function (i, item){
         console.log(item.userId);
         console.log(item.image);
         console.log(item.time);
        console.log(item.content);
        console.log(item.category);
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
        }else {
            console.log("display col");
            console.log($('.w3-border w3-padding').html())
        //create div
    //      var itm = document.getElementById("post");
    //
    // // Copy the <li> element and its child nodes
    //     var cln = itm.cloneNode(true);

    // // Append the cloned <li> element to <ul> with id="myList1"
    //     var $original = $("#post");
    //     var $newClone = original.clone();
    //     $original.appendChild($newClone);
    //     console.log($newClone);
      //   document.getElementById("post").appendChild(cln);
        let $col = "<td class=\"w3-container w3-card w3-white w3-round w3-margin\">"
            + "<td>" + $('.w3-border w3-padding').html(item.id) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.image) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.title) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.content) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.category) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.tags) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.time) + "</td>"
            + "<td>" + $('.w3-border w3-padding').html(item.location) + "</td>";

        $table.append($col);
    }

    if ($('#u-title').html()!=item.title)
        $('#u-title').html(item.title);
    if ($('#u-content').html()!=item.content)
        $('#u-content').html(item.content);
    // if ($('#u-category').html()!=item.category)
    //     $('#u-category').html(item.category);
    // if ($('#u-tags').html()!=item.tags)
    //     $('#u-tags').html(item.tags);

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

//show location

function initMap() {
    const map = new google.maps.Map(document.getElementById("location"), {
        zoom: 8,
        center: { lat: 41.01347, lng: -91.9589057 },
    });
    const geocoder = new google.maps.Geocoder();
    const infowindow = new google.maps.InfoWindow();
    document.getElementById("location").addEventListener("click", () => {
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
function displayPostListOnHomePage(respJson){
    let $table = $('#_posts');
 //   $table.find($('._post')).remove();


    // Update new data
    $.each(respJson, function(i, item) {

        $("#uimage").html(item.image);
        $("#uid").html(item.id);
        $('#utitle').html(item.title);
        $('#ucontent').html(item.content);
        $('#ucategory').html(item.category);
        $('#utag').html(item.tags);
        $('#utime').html(item.time);
        $table.append(displaySinglePost(item));
    });
    //console.log(item.time);
    // for(var i =0; i<10; i++){
    //
    // }
}
function displaySinglePost(post){
    var post = '<div class="w3-container w3-card w3-white w3-round w3-margin" id="post"><br>' +
        '<img src="/w3images/avatar2.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">'+

        '<span id="utime" class="w3-right w3-opacity">@Date@</span>'+
    '<label for="uid">Post ID: </label>'+
    '<span id="uid">@id@</span><br>'+
        '<label for="utitle">Title: </label>'+
        '<span id="utitle">@title@</span><br>'+
        '<div id="image_frame"><img src="@image@"></div>'+
        '<hr class="w3-clear">'+

            '<span id="ucontent">@content@</span>'+
            '<img src="" style="width:100%" class="image" id="image">'+
                '<div class="w3-row-padding" style="margin:0 -16px">'+
                    '<label for="ucategory">@category@</label>'+
                    '<div class="w3-half" id="ucategory">General</div>'+
                    '<label for="utag">In Mode: </label>'+
                    '<div class="w3-half" id="utag">@tag@</div>'+
                '</div>'+

                '<button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;Like</button>'+
                '<button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> &nbsp;Comment</button>'+
                '<br>'+
                    '<button id="show" type="button" class="w3-button w3-theme-d1 w3-margin-bottom" style="display: none;"><i class="fa fa-delete"></i> &nbsp;Update</button>'+
                    '<button id="del" type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-delete"></i> &nbsp;Delete</button>'+

                '</div>'
}