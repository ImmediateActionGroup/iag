<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有帖子</title>
</head>
<body>
    <div>
        <table border="1">
            <tbody>
            <#list postss as posts>
                <tr>
                    <td>${posts.user.nickname}</td>
                    <td>${posts.title}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        ${posts.content}
                    </td>
                </tr>
            <tr>
                <td>
                    查看&nbsp;${posts.viewNum}
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    点赞&nbsp;${posts.praiseNum}
                </td>
                <td>发表时间&nbsp;${posts.publishTime}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</body>
</html>