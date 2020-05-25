# My first spring project

## 资料
    
[Spring文档](https://spring.io/guides)

[github](https://github.com)

[git文档](http://git-scm.com/download)

[git_help文档](https://help.github.com/en/github/authenticating-to-github/checking-for-existing-ssh-keys)

[boolstrap组件](https://v3.bootcss.com/components/#navbar-default)

[github 授权登录流程](https://developer.github.com/apps/building-oauth-apps/)
[github 授权登录流程 doc](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)
[H2 database in Maven](https://mvnrepository.com/artifact/com.h2database/h2/1.4.199)
[h2 quickstart](http://www.h2database.com/html/quickstart.html)
[MySQL 菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html)
[Java 注解（Annotation)](https://www.runoob.com/w3cnote/java-annotation.html)


## tool 
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)    
## use git
### 创建本地仓库
#### git的最小配置
    设置用户名和邮箱
    git config --global user.name "your_name"
    git config --global user.email "your_email"
    //user.name "your_name" 这个之间没有等号，只为空格
    
    git config --local //
    git config --gloabl //
    git config --system //
    
    git config --local --list//
    git config --gloabl --list//
    git config --system --list//
    
    pwd
    
    alice.name = cmd
    
    //创建本地的git仓库
    
    cd 已有项目所在的文件夹
    git init
    
    cd 某个文件夹
    git init your_project
    cd your_project
    
    //为某个仓库设置,局部设置屏蔽全局设置
    git config --local user.name "your_name"       
    git config --local user.email "your_email"
    
    cp 被拷贝文件路径 拷贝文件路径
    
    git add 文件名 //将文件提交到缓存区，由git管理
    git add -u //git 管理的全部提交到暂存区
    git rm  文件名//删除文件
    git commit -m"提交理由（可省略）" 
    git commit --amend --no-edit  //追加
    
    //工作目录-git add files>暂存区-git commit> 历史版本
    
    git status //git的管理状态
    
    //rename example readme -> readme.md
    git mv readme readme.md//√
    
    mv readme readme.md//×
    git add readme.md
    git rm readme
    
    git reset --hard //清理掉工作路径和暂存区中的内容
    
    git log
    git log --oneline
    git log --n4 //最近的四次提交
    git log //查看当前分支
    git checkout -b temp 提交文件可识别的哈希值//创建分支
    git log --all
    git log --all --graph
    
    git log --oneline --all -n4 --graph
        
    git branch -av //查看git分支
    gitk //打开图形界面
    
    
    dir .git 查看文件，类似于ls
#### 探索.git 目录 
    git cat-file -t 哈希值//查看类型 commit tree blob
    git cat-file -p 哈希值//查看内容
    HEAD 所在的分支
    config 配置信息
    refs 应用和tags
    objects 对象
    
 > 文件内容相同即为相同的blob 
    
 ### git对象的存储关系
    commit:一个commit对应一颗树，为所有文件的快照
        tree
        parent
        author
        committter    
        
    tree：可以看做为文件夹，文件夹也为树
        tree 
        blob:tree 中包含 blob
        
    blob：具体的文件；文件内容相同，blob只有一个，与文件名无关
    
    find .git/objects -type -f
    FIND: 参数格式不正确

> 分离头指针：要做变更就要与某个分支（branch）挂钩，否则不安全
> 12分离头指针的情况下的注意事项

    工作在没有分支的情况下，git对commit产生变更，切换分支后，commit没有对应的branch和他挂钩，
    这些变更可能会被git当做垃圾清除掉
    尝试性的变更，可以不用挂钩branch，不需要就切换分支，丢掉不用的
    
    git checkout -b 分支名 分支来源  // 可以创建分支，切换分支
    
    git diff commit_1 commit_2 //比较commit_1 和commit_2 的差异
    git diff HEAD HEAD~1(^1)[/HEAD~2(^^)]
    git diff //工作区与暂存区比较
    git diff --cached//暂存区与HEAD比较
    
    git branch -d 分支名 // 删除分支
    git branch -D 分支名 // 
    
    git branch -av//显示所有分支
   
    git commit --amend --no-edit 追加到上次的
    git push
    
    git commit --amend //变更最近一次提交的commit的message
    git rebase -i commit号//   协同不要轻易使用,选择父亲的commit号
    
    git rebase -i      //交互式，内部有相应的选项，变基操作

    git reset HEAD//取消暂存,恢复和HEAD一样
    git reset HEAD -- 文件名//某文件恢复和HEAD对应的文件一样
    git checkout -- 文件名//从暂存区恢复某文件到工作区
    
    git reset --hard 恢复到某commit//恢复的commit，删除该commit之后的commit,暂存区，工作区同时
    
    git stash//暂存工作区
    git stash list//查看stash
    git stash apply//恢复工作区
    
## 备份
    git push //推
    git fetch //拉
    git pull //fetch merge合并
    git merge --allow-unrelated-histories// 允许不相干的树合并 
    
    
    git clone --bare  路径//克隆裸仓库，file://路径，智能协议
    git push --set-upstream 分支名 变更人
    git remote -v //协议版本    remote 远端
    git remote add github git@github.com:DustMerlin/TheFirstSpringBootExample.git
   
    git checkout -b 本地分支 远端依赖分支//创建切换到新分支

    
        
    
    
    
    
    生成SSH公钥和秘钥，方便通过git提交到github的仓库中
    
