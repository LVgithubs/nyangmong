function toggleLike(postId) {
    let likeIcon = $("#storyLikeIcon");

    if (likeIcon.hasClass("far")) { // 좋아요 하겠다

        $.ajax({
            type: "post",
            url: `/api/post/${postId}/likes`,
            dataType: "text"
        }).done(res=>{

            let likeCountStr = $("#storyLikeIcon").text();
            let likeCount = Number(likeCountStr) + 1;
            $("#storyLikeIcon").text(likeCount);

            likeIcon.addClass("fas");
            likeIcon.addClass("active");
            likeIcon.removeClass("far");
        }).fail(error=>{
            console.log("오류", error);
        });

    } else { // 좋아요취소 하겠다

        $.ajax({
            type: "delete",
            url: `/api/post/${postId}/unLikes`,
            dataType: "text"
        }).done(res=>{

            let likeCountStr = $("#storyLikeIcon").text();
            let likeCount = Number(likeCountStr) - 1;
            $("#storyLikeIcon").text(likeCount);

            likeIcon.removeClass("fas");
            likeIcon.removeClass("active");
            likeIcon.addClass("far");
        }).fail(error=>{
            console.log("오류", error);
        });
    }
}