INSERT INTO "user" (id, username, password, sex, bio, create_time, last_active_time) VALUES (1, 'dufu', '$2a$10$YbpFib4Os2KoAfsyojR/ZuIaoSoQnzSq.DVKD3LE437bPzRjfYuYG', 1, '哈哈哈', '2019-01-06 13:25:40.080552', null);
INSERT INTO "user" (id, username, password, sex, bio, create_time, last_active_time) VALUES (2, 'xiaohua', '234567', 2, '嘿嘿嘿', '2019-01-06 13:25:40.080552', null);

INSERT INTO public.doc (id, name, brief, header_url, user_id, delete_at, create_time, update_time) VALUES (1, 'PHP扩展开发及内核应用', '
虽然用了书名号，但它是我的一个业余项目而已，它以Sara Golemon在2005年著作的《Extending and Embedding PHP》一书为蓝本翻译修改而来。这里先对Sara女士表示感谢，为我们奉献了这么优秀的一本技术图书。截止到目前（2011年），这几年以来，PHP的应用在中国突飞猛进，已经渗透到了互联网的各个方面，现在每个公司里都不可能一点没有PHP的影子了。有关PHP语言自身的书籍也是层出不穷，而有关PHP扩展开发以及PHP内核方面的文字却都比较零散，比较系统的有TIPI项目、Zend上面的几篇文章以及《Extending and Embedding PHP》这本书的英文版，不能不说这直接限制住了部分人在PHP语言上的深入研究与学习。我在学校的时候就翻阅过这本书的电子版，但因为是英文的终究没有在那时深入研究下去，也算是一件憾事。 浏览本项目，希望你已经具备以下技能：

比较熟悉PHP语言。熟悉基本的C语言', null, 1, null, '2019-01-25 08:30:53.605000', '2019-01-25 08:30:55.847000');
INSERT INTO public.doc (id, name, brief, header_url, user_id, delete_at, create_time, update_time) VALUES (2, 'Microservices from Design to Deployment 中文版 《微服务：从设计到部署》', '
本书为 Chris Richardson 和 Floyd Smith 联合编写的微服务电子书 Designing and Deploying Microservices 中文版，其从不同角度全面介绍了微服务：微服务的优点与缺点、API 网关、进程间通信（IPC）、服务发现、事件驱动数据管理、微服务部署策略、重构单体。

Github：https://github.com/oopsguy/microservices-from-design-to-deployment-chinese
GitBook：https://www.gitbook.com/book/docshome/microservices/details
本书对 Nginx 的描述不是很多，主要针对微服务领域。如果您想了解更多关于 Nginx 的内容，请参阅正在更新的 Nginx 中文文档。', null, 1, null, '2019-01-25 08:33:51.958000', '2019-01-25 08:33:54.220000');


