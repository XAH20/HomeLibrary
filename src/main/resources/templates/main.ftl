<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">Список пользователей</a></span>
    </div>
    <a href="/addBook">Добавить книгу</a>
    <div>Список книг</div>

    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Найти</button>
    </form>
    <#if allbooks??>
        <#list allbooks as book>
            <div>
                <span>${book.getBookID()}</span>
                <b>${book.getTitle()}</b>
                <i> Автор(ы): </i>
                <#list book.getAuthors() as author>
                    <span>[${author.getNameAuthor()}]</span>
                <#else>
                    автор не указан
                </#list>
                <i> Тэги: </i>
                <#list book.getTags() as tag>
                    <span>[${tag.getNameTag()}]</span>
                <#else>
                    тегов нет
                </#list>
                <i> Кем прочитана: </i>
                <#list book.getReadUsers() as readUsers>
                    <span>[${readUsers.getUsername()}]</span>
                <#else>
                    никем
                </#list>
            </div>
        </#list>
    <#else>
        <div>Книг нет!</div>
    </#if>
</@c.page>