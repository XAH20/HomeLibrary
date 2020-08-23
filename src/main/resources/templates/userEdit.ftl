<#import "parts/common.ftl" as c>

<@c.page>
    Редактирование ролей
    <div> Пользователь: ${user.getUsername()} </div>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.getUsername()}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.getUserID()}" name="userID">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>