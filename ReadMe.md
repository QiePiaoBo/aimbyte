### MAVEN版本修改指令
统一修改版本号父子POM的
mvn versions:set -DnewVersion=1.1.3
回退
mvn versions:revert
确认
mvn versions:commit
commit 之后，不能做回退操作，并没有执行git的commit。 所以，常规操作只需要1和3

