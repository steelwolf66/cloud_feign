# Feign Client

### 1. 将各个服务的FeignClient汇总，提供给调用方
### 2. 此包中不提供fallback功能；如果想使用fallback功能请使用以下步骤
- copy一份要覆盖的interface
- 在新的interface中配置fallback
- 这里建议使用fallbackFactory，覆盖其中的create方法
### 3.此包中已引入了ztax的cloud-common包，引入feign后无需重复引用