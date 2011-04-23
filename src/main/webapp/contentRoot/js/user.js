var drawPostsCallback = function drawPost(result) {
    var div = getRefToDivNest("userPosts");
    div.innerHTML = "";
    var length = result.length;
    var html = "<ul>"
    for (var i = 0; i < length; i++) {
        html += "<li>"
        html += subjectLabel + " " + result[i].subject;
        html += "<br/>";
        html += txtLabel + " " + result[i].text;
        html += "<br/>";
        html += timeLabel + " " + result[i].timestamp;
        html += "<br/>";
        html += "<a href=\"showComments.htm?postId=" + result[i].postId + "\">" + seeCommentsLabel + "</a>";
        html += "</li>";
    }
    div.innerHTML += html;
}

function showUserPosts(nick) {
    blogService.getUserPosts(nick, drawPostsCallback);
}

function getRefToDivNest(divID) {
    if (document.getElementById) {
        return document.getElementById(divID);
    }
    if (document.all) {
        return document.all[divID];
    }
    return document[divID];
}
