// (1) 회원정보 수정
function update(userId, event) {

    event.preventDefault();  //폼태그 액션 막기!!

    let data = $("#profileUpdate").serialize();

    console.log(data);

    $.ajax({
        type: "put",
        url: `/api/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json"
    }).done(res => {  //HttpStatus 상태 200번대
        console.log("update 성공", res);
        location.href = `/user/${userId}`
    }).fail(error => { //HttpStatus 상태 200번대 아닐 때
        if (error.data == null) {
            console.log("update 실패", error);
            alert(error.responseJSON.data.name);
        } else {
            console.log("update 실패", error);
            alert(JSON.stringify(error.data.name));
        }
    });

}