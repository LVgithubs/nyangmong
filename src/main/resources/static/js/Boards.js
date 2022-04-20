$("#btn-write").click(() => {
    write();
});

$("#btn-delete").click(() => {
    deletePost();
});

// 2. 기능 함수
async function deletePost() {
    let boardsId = $("#boardsId").val();
    let response = await fetch(`/s/api/boards/${boardsId}/delete`, {
        method: "DELETE" // delete는 body가 없다.
    });
    let responseParse = await response.json();

    if (responseParse.code == 1) {
        alert("삭제성공");
        location.href = "/";
    } else {
        alert("삭제실패");
    }
}

async function write() {
    let writeDto = {
        title: $("#title").val()
    }
}