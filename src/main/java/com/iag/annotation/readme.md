### 自定义注解类
这里主要存放自定义注解类
每写一个自定义注解类都要在这个文档中写明，
 > 格式：注解类名称：含义（用来干什么）---谁创建的
 > 
 > 例如：AuthorityCheck:权限注解类（添加所需权限）---beishan
 
 - AuthorityCheck 权限注解类，用于标注一个方法需要权限校验
 
 > permission : 默认为空， 值类型--> 权限字符串 
 
 >例如：`user:query`