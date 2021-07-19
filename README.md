## Ditto社区

## 资料
[Spring 文档](https://spring.io/guides)   
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[es](https://elasticsearch.cn/explore)  
[Github deploykey](https://developer.github.com/v3/guides/managing-depoly-keys/#deploy-keys)  
[Github deploy key 文档](https://docs.github.com/cn/github/authenticating-to-github/keeping-your-account-and-data-secure/creating-a-personal-access-token)  
[Github Oauth](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)


## 工具
[Git](https://git-scm.com/download)   
[Visual Paradigm](https://www.visual-paradigm.com)

## 脚本
```sql
create table USER
(
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
```