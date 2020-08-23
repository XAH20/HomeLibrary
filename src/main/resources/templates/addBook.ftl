<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>
<div>
    <form method="post" action="/addBook">
        <input type="text" name="title" placeholder="Название книги" />
        <input type="text" name="author" placeholder="Автор книги" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить книгу</button>
    </form>
</div>
    <div>${messageNewBook!}</div>
    <div><a href="/main">Вернуться к списку книг</a></div>
</@c.page>