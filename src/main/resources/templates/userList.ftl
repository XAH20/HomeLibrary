<#import "parts/common.ftl" as c>

<@c.page>
    Список пользователей

    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Роли</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.getUsername()}</td>
                <td><#list user.getRoles() as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.getUserID()}"> Изменить</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>